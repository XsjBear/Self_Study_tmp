package com.self_study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.FriendBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IStudyFriendService;
import com.self_study.service.ITargetService;

/**
 * 用户学习小伙伴发送的相关请求
 * @author Xsj
 *
 */
@RestController
@RequestMapping("/SF")
public class StudyFriendController {
	
	@Autowired
	private IStudyFriendService studyFriendService;
	
	@Autowired
	private ITargetService targetService;
	
//	/**
//	 * 页面一加载时就发送此请求来加载表单中用户的个人信息
//	 */
//	@RequestMapping("/PageLoad")
//	public Map<String, Object> loadRequest(HttpSession session) {
//		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo");
//		FriendBean friendInfo = studyFriendService.selectByUserId(userInfo);
//		ArrayList<TargetBean> targetList = targetService.selectAll();
//		
//		Map<String, Object> transMap = new HashMap<String , Object>();
//		transMap.put("target", targetList);
//		if(friendInfo == null) {
//			transMap.put("UserInfo", null);
//		}else {
//			transMap.put("UserInfo", friendInfo);
//		}
//		System.out.println(transMap);
//		return transMap;
//	}
	
	
	
	
	@RequestMapping(value="/searchSelf")
	@ResponseBody
	public int searchSelf(HttpSession session) {
		System.out.println("后台接收到检查自身的请求");
		int result = 0;
//		Map<String,String> resultMap = new HashMap<String,String>();
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo"); 	//获取当前登陆用户信息
		FriendBean friendBean = studyFriendService.selectByUserId(userInfo);	
		if(friendBean == null) {
			//则说明当前friend表中不存在该用户的相关信息
//			resultMap.put("Result", "-1");
			result = -1;
		}else {
			//表示该用户使用过该功能，friend表中哦给存在着该用户的相关信息
//			resultMap.put("Result", "1");
			result = 1;
		}
		System.out.println("Result : " + result);
		return result;
	}
	
	
	
	

}
