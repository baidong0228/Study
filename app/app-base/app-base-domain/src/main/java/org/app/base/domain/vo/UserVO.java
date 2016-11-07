/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.domain.vo;


import org.app.base.domain.User;

public class UserVO extends User {
	/**
	 * 登录时间
	 */
	private String loginDate;
	/**
	 * 组织机构编码
	 */
	private String groupCode;
	/**
	 * 组织机构名称
	 */
	private String groupName;
	/**
	 * 组织机构编码路径
	 */
	private String groupCodePath;
	/**
	 * 组织机构名称路径
	 */
	private String groupNamePath;
	/**
	 * 返回信息
	 */
	private String returnInfo;
	/**
	 * 跳转路径
	 */
	private String loginUrl;
	
	
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupCodePath() {
		return groupCodePath;
	}
	public void setGroupCodePath(String groupCodePath) {
		this.groupCodePath = groupCodePath;
	}
	public String getGroupNamePath() {
		return groupNamePath;
	}
	public void setGroupNamePath(String groupNamePath) {
		this.groupNamePath = groupNamePath;
	}
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
}
  