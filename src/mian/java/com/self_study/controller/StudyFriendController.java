package com.self_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.FriendBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IStudyFriendService;

/**
 * 用户学习小伙伴发送的相关请求
 * @author Xsj
 *
 */
@RestController
@ResponseBody
@RequestMapping("/SF")
public class StudyFriendController {
	
	@Autowired
	private IStudyFriendService studyFriendService;
	
	
	@RequestMapping("/searchSelf")
	public int searchSelf(HttpSession session) {
		System.out.println("后台接收到检查自身的请求");
		int result = 0;
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo"); 	//获取当前登陆用户信息
		FriendBean friendBean = studyFriendService.selectByUserId(userInfo);	
		if(friendBean == null) {
			//则说明当前friend表中不存在该用户的相关信息
			result = -1;
		}else {
			//表示该用户使用过该功能，friend表中哦给存在着该用户的相关信息
			result = 1;
		}
		System.out.println("Result : " + result);
		return result;
	}
	
	
	
	

}
