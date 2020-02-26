package com.self_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由控制器，用以访问WEB-INF目录下的页面
 * @author Xsj
 *
 */
@Controller
public class RoteController {
	
	
	
	@RequestMapping("/HomePage")
	public String HomePage(HttpSession session) {
		return "HomePage";
	}
	
	
	@RequestMapping("/StudyFriend")
	public String StudyFriend(HttpSession session) {
		return "StudyFriend";
	}
	
	
	@RequestMapping("/SelfInfo")
	public String SelfInfo(HttpSession session) {
		return "SelfInfo";
	}

}
