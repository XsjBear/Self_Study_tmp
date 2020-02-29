package com.self_study.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.FriendBean;
import com.self_study.bean.FriendInfoBean;
import com.self_study.bean.TargetBean;
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
	
	@RequestMapping("/addFriendInfo")
	@ResponseBody
	public int addFriendInfo(HttpSession session ,String Info , String targetDescription) {
		UserInfoBean userInfoBean = (UserInfoBean)session.getAttribute("UserInfo");
		JSONObject infomation = new JSONObject(Info);
		 
		 String currentState = "1";
		 if("on".equals((String)infomation.get("open"))) {
			 //表示当前用户同意公开自己的联系方式
			 currentState = "1";
		 }else {
			 //表示当前用户不同意公开自己的联系方式
			 currentState = "2";
		 }
		 //根据前台选择的目标查询出该目标的全部信息
		 TargetBean taegetBean = targetService.selectIdByContent(new TargetBean(null,(String)infomation.get("interest"),null));
		 FriendBean friendBeanInfo = new FriendBean(0,userInfoBean.getUserid(),Integer.valueOf(taegetBean.getTargetid()),currentState,targetDescription);
		 int result = studyFriendService.addFriendInfo(friendBeanInfo);
		 System.out.println(friendBeanInfo);
		 return result;
	}
	
	
	
	@RequestMapping(value="/searchSelf")
	@ResponseBody
	public int searchSelf(HttpSession session) {
		System.out.println("后台接收到检查自身的请求");
		int result = 0;
//		Map<String,String> resultMap = new HashMap<String,String>();
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("UserInfo"); 	//获取当前登陆用户信息
		FriendInfoBean friendInfoBean = studyFriendService.selectByUserId(userInfo);	
		if(friendInfoBean == null) {
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
