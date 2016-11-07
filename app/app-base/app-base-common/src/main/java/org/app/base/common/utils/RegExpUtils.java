/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
    
/**
 * 正则
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年9月25日 上午10:10:25
 */
public class RegExpUtils {
    //①构造一个模式. 
	//特殊符号
    static Pattern pSign=Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]{12,}$"); 
    //大小写字母
    static Pattern pA=Pattern.compile("^([A-Z]|[a-z]){12,}$");  
    //数字
    static Pattern pNum=Pattern.compile("^[0-9]{12,}$");
    
  //由大小写字母+数字+特殊字符三种组成，且长度不得小于12
    public static String verify(String str){
    	String returnInfo ="由大小写字母+数字+特殊字符三种组成，且长度不得小于12";
    	if(str.length()<12){
    		return returnInfo+",当前长度不符合规范！";
    	}
    	Matcher mSign = pSign.matcher(str);  
        Matcher mA = pA.matcher(str);  
        Matcher mNum = pNum.matcher(str); 
        
        if(mA.matches()){
        	return returnInfo+",当前只包含大小写字母，不符合规范！";
        }else if(mNum.matches()){
        	return returnInfo+",当前只包含数字，不符合规范！";
        }else if(mSign.matches()){
        	return returnInfo+",当前只包含特殊字符，不符合规范！";
        }else if(Pattern.compile("^([A-Z]|[a-z]|[0-9]){12,}$").matcher(str).matches()){
        	return returnInfo+",当前不包含特殊字符，不符合规范！";
        }else if(Pattern.compile("^([A-Z]|[a-z]|[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){12,}$").matcher(str).matches()){
        	return returnInfo+",当前不包含数字，不符合规范！";
        }else if(Pattern.compile("^([0-9]|[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){12,}$").matcher(str).matches()){
        	return returnInfo+",当前不包含大写小字母，不符合规范！";
        }else{
        	return "true";
        }
    }
}
  