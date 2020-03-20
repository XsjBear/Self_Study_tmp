package com.self_study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.FriendBean;
import com.self_study.bean.TargetBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IStudyFriendService;
import com.self_study.service.ITargetService;
import com.self_study.service.IUserInfoService;

/**
 * 答疑解惑一栏请求
 * @author Xsj
 *
 */
@RestController
public class FAQController {
	
	
	@RequestMapping("/changeInfo")
	public String changeSelfInfo(HttpSession session) {
		
		
		return "";
	}
	
	
	
	
	

}
