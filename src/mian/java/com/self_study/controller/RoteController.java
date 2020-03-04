package com.self_study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self_study.bean.FriendInfoBean;
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
	
	@RequestMapping("/AboutSelf")
	public String AboutSelf(HttpSession session , ModelMap model) {
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");	//从session中获取用户信息
		FriendInfoBean friendInfo = studyFriendService.selectByUserId(userInfo);
		//如果用户未完善学习小伙伴的相关信息，则创建一个身份展示其他信息为空的对象
		if(friendInfo == null) {
			friendInfo = new FriendInfoBean("","","","1","");
		}
		ArrayList<TargetBean> targetList = targetService.selectAll();
		model.addAttribute("targetList", targetList);
		model.addAttribute("FriendInfo", friendInfo);
		model.addAttribute("UserInfo", userInfo);
		return "AboutSelf";
	}
	
	@RequestMapping("/SearchFriend")
	public String SearchFriend() {
		return "SearchFriend";
	}
	
	@RequestMapping("/MyFriend")
	public String MyFriend() {
		return "MyFriend";
	}
	
	
	/**
	 * 页面一加载时就发送此请求来加载表单中用户的个人信息
	 */
	@RequestMapping("/PageLoad")
	public String loadRequest(HttpSession session , Model model) {
//		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo");
//		FriendBean friendInfo = studyFriendService.selectByUserId(userInfo);
		ArrayList<TargetBean> targetList = targetService.selectAll();
//		ArrayList<FriendBean> friendList = new ArrayList<>();
		model.addAttribute("targetList", targetList);
//		if(friendInfo == null) {
//			friendList.add(targetList.get(0));
//		}else {
//			friendList.add(friendInfo);
//		}
//		model.addAttribute("friendInfo" , friendList);
		return "FriendInfo";
	}
	
	
	@RequestMapping("/HomePage")
	public String HomePage() {
		return "HomePage";
	}
	
	
	@RequestMapping("/StudyFriend")
	public String StudyFriend() {
		return "StudyFriend";
	}
	
	
	@RequestMapping("/SelfInfo")
	public String SelfInfo() {
		return "SelfInfo";
	}
	
	@RequestMapping("/FriendInfo")
	public String FriendInfo() {
		return "FriendInfo";
	}

}
