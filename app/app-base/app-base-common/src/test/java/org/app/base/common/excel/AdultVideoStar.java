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

import java.util.Date;
    
public class AdultVideoStar {
	//中文名
	private String chineseName;
	//英文名
	private String englishName;
	//出生日期
	private Date birthday;
	//身高
	private int height;
	//三围
	private String measurements;
	//罩杯
	private String cup;
	//马赛克
	private String mosaic;
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCup() {
		return cup;
	}
	public void setCup(String cup) {
		this.cup = cup;
	}
	public String getMeasurements() {
		return measurements;
	}
	public void setMeasurements(String measurements) {
		this.measurements = measurements;
	}
	public String getMosaic() {
		return mosaic;
	}
	public void setMosaic(String mosaic) {
		this.mosaic = mosaic;
	}
}
  