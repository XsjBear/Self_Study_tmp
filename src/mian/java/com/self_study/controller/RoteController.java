package com.self_study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.self_study.bean.FriendInfoBean;
import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.StudyFriendInfoBean;
import com.self_study.bean.TargetBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IShareExperienceService;
import com.self_study.service.IStudyFriendService;
import com.self_study.service.ITargetService;
import com.self_study.service.IUserInfoService;

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
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IShareExperienceService shareExperienceService;
	
	
	@RequestMapping("/Share")
	public String Share() {
		return "Share";
	}
	
	
	
	@RequestMapping("/MyShare")
	public String MyShare(HttpSession session , ModelMap model) {
		
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		ArrayList<ShareExperienceBean> shareExperienceList = shareExperienceService.selectByUserId(userInfo);
		if(shareExperienceList.size() == 0) {
			//表示没有查询出任何的分享文章
			model.addAttribute("MyShareNum", 0);
		}else {
			model.addAttribute("MyShareNum", shareExperienceList.size());
			model.addAttribute("MyShare", shareExperienceList);
		}
		return "MyShare";
	}
	
	
	@RequestMapping("/AboutSelf")
	public String AboutSelf(String userid ,HttpSession session , ModelMap model) {
		UserInfoBean userInfo = null;
		//如果前台没有传userid过来，说明访问的是自己的主页，从session中获取个人信息，如果前台传了userid过来，说明访问的是别人的主页，则根据传输过来的useri查询出对应的信息
		if(userid == null) {
			//说明是自己访问自己的个人主页
			model.addAttribute("isSelf", "true");
			userInfo = (UserInfoBean)session.getAttribute("UserInfo");	//从session中获取用户信息
		}else {
			//说明不是访问自己的主页，查询对应id的信息并且不提供修改个人信息按钮
			model.addAttribute("isSelf", "false");
			userInfo = new UserInfoBean();
			userInfo.setUserid(Integer.valueOf(userid));
			userInfo = userInfoService.selectAllByUserId(userInfo);
		}
		//查询出对应的学习小伙伴的信息
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
	public String SearchFriend(HttpSession session , ModelMap model) {
		UserInfoBean userInfo = (UserInfoBean)session.getAttribute("UserInfo");
		ArrayList<StudyFriendInfoBean> list = studyFriendService.selectAll(userInfo);
		model.addAttribute("AllFriendInfo", list);
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
