/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.excel;

import org.app.base.common.utils.ExcelUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class TestExcel {
    public static void main(String[] args) {
        try {
            ExcelUtils<AdultVideoStar> eu = new ExcelUtils<AdultVideoStar>();//初始化Excel工具
            /**入参准备 start**/
            /**Excel表头，表头顺序与对象属性顺序一致**/
            String[] headers = {"中文名", "英文名", "出生日期", "身高(cm)", "三围", "罩杯", "作战兵种"};
            OutputStream out = new FileOutputStream("/Users/Bdong/Downloads/AdultVideoStar.xls");//Excel存放位置
            Calendar c = Calendar.getInstance();//获取一个日历实例
            Date date = new Date();
            List<AdultVideoStar> AVStarList = new ArrayList<AdultVideoStar>();//Excel实际数据
            AdultVideoStar AVStar1 = new AdultVideoStar();
            AVStar1.setChineseName("波多野结衣");
            AVStar1.setEnglishName("Yui Hatano");
            c.set(1988, 05 - 1, 24);//设定日历的日期
            date = c.getTime();
            AVStar1.setBirthday(date);
            AVStar1.setHeight(163);
            AVStar1.setMeasurements("(88-59-85)cm,(35-23-33)in");
            AVStar1.setCup("E");
            AVStar1.setMosaic("步兵");
            AVStarList.add(AVStar1);

            AdultVideoStar AVStar2 = new AdultVideoStar();
            AVStar2.setChineseName("小泽玛利亚");
            AVStar2.setEnglishName("Maria Ozawa");
            c.set(1986, 1 - 1, 8);//设定日历的日期
            date = c.getTime();
            AVStar2.setBirthday(date);
            AVStar2.setHeight(162);
            AVStar2.setMeasurements("(88-58-86)cm,(35-23-34)in");
            AVStar2.setCup("E");
            AVStar2.setMosaic("步兵");
            AVStarList.add(AVStar2);

            AdultVideoStar AVStar3 = new AdultVideoStar();
            AVStar3.setChineseName("松岛枫");
            AVStar3.setEnglishName("Kaede Matshushima");
            c.set(1982, 11 - 1, 7);//设定日历的日期
            date = c.getTime();
            AVStar3.setBirthday(date);
            AVStar3.setHeight(160);
            AVStar3.setMeasurements("(85-58-84)cm,(33-23-33)in");
            AVStar3.setCup("D");
            AVStar3.setMosaic("骑兵");
            AVStarList.add(AVStar3);

            AdultVideoStar AVStar4 = new AdultVideoStar();
            AVStar4.setChineseName("苍井空");
            AVStar4.setEnglishName("Aoi Sora");
            c.set(1983, 11 - 1, 11);//设定日历的日期
            date = c.getTime();
            AVStar4.setBirthday(date);
            AVStar4.setHeight(155);
            AVStar4.setMeasurements("(90-58-83)cm,(35-22-33)in");
            AVStar4.setCup("G");
            AVStar4.setMosaic("骑兵");
            AVStarList.add(AVStar4);

            AdultVideoStar AVStar5 = new AdultVideoStar();
            AVStar5.setChineseName("饭岛爱");
            AVStar5.setEnglishName("Hitomi Shiraishi");
            c.set(1972, 10 - 1, 31);//设定日历的日期
            date = c.getTime();
            AVStar5.setBirthday(date);
            AVStar5.setHeight(163);
            AVStar5.setMeasurements("(86-58-85)cm,(34-22-33)in");
            AVStar5.setCup("--");
            AVStar5.setMosaic("步兵");
            AVStarList.add(AVStar5);
            /**入参准备 end**/

            /**如果Excel包含日期格式，可按指定格式进行统一格式化，如yyy-MM-dd**/
            eu.exportExcel("AdultVideoStar", headers, AVStarList, out, "yyy-MM-dd");//执行导出
            out.close();//关闭输出流
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
  