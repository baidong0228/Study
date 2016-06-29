/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * This class is used for Excel工具
 * 
 * @author Bdong
 * @version 1.0, 2016年6月8日 上午9:31:46
 */
public class ExcelUtil<T>   {

	/**
	 * 导出excel
	 * 
	 * @param title
	 *            sheet名称
	 * @param headers
	 *            表格标题行
	 * @param dataset
	 *            实际数据集
	 * @param out
	 *            输出流
	 * @param pattern
	 *            输出文件格式
	 * @author Bdong
	 */
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("Bdong");

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				Field field = fields[i];
				String fieldName = field.getName();//属性名
				String getMethodName = "get"//拼接反射需要的方法名
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});//调用方法获取属性值
					if(value!=null){
						// 判断值的类型后进行强制类型转换
						HSSFCellStyle cellStyle = workbook.createCellStyle();   
						if (value instanceof Integer || value instanceof Long) {//整数
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
							cell.setCellValue(Long.parseLong(value.toString()));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof Float || value instanceof Double) {//浮点数
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
							cell.setCellValue(Double.parseDouble(value.toString()));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof Date) {//日期
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(pattern);
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(pattern));
							cell.setCellValue(sdf.format(date));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof byte[]) {//
							// 有图片时，设置行高为60px;
							row.setHeightInPoints(60);
							// 设置图片所在列宽度为80px,注意这里单位的一个换算
							sheet.setColumnWidth(i, (short) (35.7 * 80));
							byte[] bsValue = (byte[]) value;
							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
									1023, 255, (short) 6, index, (short) 6, index);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, workbook.addPicture(
									bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						} else {
							// 其它数据类型都当作字符串简单处理
							cell.setCellValue(value.toString());
						}
					}
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 清理资源
				}
				// 生成边框样式
				HSSFCellStyle style2 = workbook.createCellStyle();
				style2.setFillForegroundColor(HSSFColor.WHITE.index);
				style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
				style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
				style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				// 生成另一个字体
				HSSFFont font2 = workbook.createFont();
				font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
				// 把字体应用到当前的样式
				style2.setFont(font2);
				cell.setCellStyle(style2);//设置边框样式
			}

		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param title
	 *            sheet名称
	 * @param headers
	 *            表格标题行
	 * @param keys Map的key
	 * @param dataset
	 *            实际数据集
	 * @param out
	 *            输出流
	 * @param pattern
	 *            输出文件格式
	 * @author Bdong
	 */
	public void exportExcel(String title, String[] headers,String[] keys,
			List<Map<String,?>> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("Bdong");

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 遍历List数据，产生数据行
		for(int i=0;i<dataset.size();i++){
			row = sheet.createRow(i+1);
			Map<String,?> map = dataset.get(i);
			for (int j = 0; j < keys.length; j++) {
				HSSFCell cell = row.createCell(j);
				try {
					Object value = map.get(keys[j]);
					if(value!=null){
						// 判断值的类型后进行强制类型转换
						HSSFCellStyle cellStyle = workbook.createCellStyle();   
						if (value instanceof Integer || value instanceof Long) {//整数
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
							cell.setCellValue(Long.parseLong(value.toString()));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof Float || value instanceof Double) {//浮点数
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
							cell.setCellValue(Double.parseDouble(value.toString()));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof Date) {//日期
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(pattern);
							cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(pattern));
							cell.setCellValue(sdf.format(date));
							cell.setCellStyle(cellStyle);
						} else if (value instanceof byte[]) {//
							// 有图片时，设置行高为60px;
							row.setHeightInPoints(60);
							// 设置图片所在列宽度为80px,注意这里单位的一个换算
							sheet.setColumnWidth(i, (short) (35.7 * 80));
							byte[] bsValue = (byte[]) value;
							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
									1023, 255, (short) 6, i, (short) 6, i);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, workbook.addPicture(
									bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						} else {
							// 其它数据类型都当作字符串简单处理
							cell.setCellValue(value.toString());
						}
					}
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 清理资源
				}
				// 生成边框样式
				HSSFCellStyle style2 = workbook.createCellStyle();
				style2.setFillForegroundColor(HSSFColor.WHITE.index);
				style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
				style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
				style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				// 生成另一个字体
				HSSFFont font2 = workbook.createFont();
				font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
				// 把字体应用到当前的样式
				style2.setFont(font2);
				cell.setCellStyle(style2);//设置边框样式
			}

		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
