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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
    
public class MapUtil {
//	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
//        if (map == null)  
//            return null;  
//  
//        Object obj = beanClass.newInstance();  
//  
//        org.apache.commons.beanutils.BeanUtils.populate(obj, map);  
//  
//        return obj;  
//    }  
//	
	public static Object transMap2Bean(Map<String, Object> map, Class<?> beanClass,String pattern) { 
		if (map == null)  return null;  
		 
		Object obj = null ;
		try {
			obj = beanClass.newInstance();  
			
			Field[] fields = obj.getClass().getDeclaredFields();   
	        for (Field field : fields) {  
	        	try{
	        		int mod = field.getModifiers();    
		            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
		                continue;    
		            }    
		            field.setAccessible(true);
		            if(map.get(field.getName())!=null){
		            	if(Date.class.equals(field.getType())){
			            	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			            	Date date = sdf.parse(map.get(field.getName()).toString());
			            	field.set(obj, date);   
			            }else if(Integer.class.equals(field.getType())||int.class.equals(field.getType())){
			            	field.set(obj,Integer.parseInt( map.get(field.getName()).toString())); 
						}else if(Long.class.equals(field.getType())){
			            	field.set(obj,Long.parseLong( map.get(field.getName()).toString())); 
						}else if(Float.class.equals(field.getType())){
							field.set(obj,Float.parseFloat( map.get(field.getName()).toString())); 
						}else if(Double.class.equals(field.getType())){
							field.set(obj,Double.parseDouble( map.get(field.getName()).toString())); 
						}else{
							field.set(obj,map.get(field.getName()).toString()); 
						}
		            }
	        	}catch(Exception e){
	        		System.out.println("transMap2Bean Error " + e);
	        	}
	        }   
		} catch (Exception e) {
			System.out.println("transMap2Bean Error " + e);
		}
		return obj;
	}
}
  