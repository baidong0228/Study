/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.domain;

import java.util.Date;

public class AdultVideoStar {
    private Integer id;
    //中文名
    private String chinesename;
    //英文名
    private String englishname;
    //出生日期
    private Date birthday;
    //身高
    private Integer height;
    //三围
    private String measurements;
    //罩杯
    private String cup;
    //马赛克
    private String mosaic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename == null ? null : chinesename.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements == null ? null : measurements.trim();
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup == null ? null : cup.trim();
    }

    public String getMosaic() {
        return mosaic;
    }

    public void setMosaic(String mosaic) {
        this.mosaic = mosaic == null ? null : mosaic.trim();
    }
}