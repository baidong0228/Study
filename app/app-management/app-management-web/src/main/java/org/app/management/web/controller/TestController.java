/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.web.controller;    

import javax.servlet.http.HttpServletRequest;

import org.app.base.domain.Person;
import org.app.management.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller 
@RequestMapping(value = "/TestController")
public class TestController {
	@Autowired  
	private IPersonService personService;
	
	@RequestMapping("index")  
    public String index(HttpServletRequest request,Model model){ 
		Person person=personService.selectByPrimaryKey(1);
		model.addAttribute("person",person);
		return "index"; 
	}
}
  