package com.self_study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self_study.bean.FriendBean;
import com.self_study.bean.TargetBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IStudyFriendService;
import com.self_study.service.ITargetService;

/**
 * 路由控制器，用以访问WEB-INF目录下的页面
 * @author Xsj
 *
 */
@Controller
public class RoteController {
	
	@Autowired
	private IStudyFriendService studyFriendService;
	
	@Autowired
	private ITargetService targetService;
	
	/**
	 * 页面一加载时就发送此请求来加载表单中用户的个人信息
	 */
	@RequestMapping("/PageLoad")
	public String loadRequest(HttpSession session , Model model) {
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo");
		FriendBean friendInfo = studyFriendService.selectByUserId(userInfo);
		ArrayList<TargetBean> targetList = targetService.selectAll();
		
		model.addAttribute("targetList", targetList);
		
		if(friendInfo == null) {
			model.addAttribute("friendInfo" , null);
		}else {
			System.out.println(friendInfo);
			model.addAttribute("friendInfo" , friendInfo);
		}
		return "SelfInfo";
	}
	
	
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
	
	@RequestMapping("/FriendInfo")
	public String FriendInfo(HttpSession session) {
		return "FriendInfo";
	}

}
