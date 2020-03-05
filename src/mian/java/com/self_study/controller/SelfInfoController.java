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
 * 用户信息一栏请求
 * @author Xsj
 *
 */
@RestController
@RequestMapping("/selfInfo")
public class SelfInfoController {
	
	@Autowired
	private ITargetService targetService;
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IStudyFriendService studyFriendService;
	
	@RequestMapping("/changeInfo")
	public Map<String,Integer> changeSelfInfo(HttpSession session ,String Info , String targetDescription) {
		HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
		UserInfoBean sessionUserInfo = (UserInfoBean)session.getAttribute("UserInfo");	//获取session中的用户信息
		JSONObject infomation = new JSONObject(Info);
		UserInfoBean updataUserInfo = new UserInfoBean();
		FriendBean updataFriendInfo = new FriendBean();
		
		//将前台传输的需要修改的数据存储进upadtaFriendInfo中
		updataUserInfo.setUserid(sessionUserInfo.getUserid());
		updataUserInfo.setNickname((String)infomation.get("nickname"));
		updataUserInfo.setRealname((String)infomation.get("realname"));
		updataUserInfo.setTel((String)infomation.get("tel"));
		updataUserInfo.setMail((String)infomation.get("email"));
		updataUserInfo.setSex((String)infomation.get("sex"));
		updataUserInfo.setBirthday((String)infomation.get("birthday"));
		updataUserInfo.setQq((String)infomation.get("QQ"));
		updataUserInfo.setWechat((String)infomation.get("WeChat"));
		updataUserInfo.setSchool((String)infomation.get("school"));
		updataUserInfo.setStu_num((String)infomation.get("stu_num"));
		updataUserInfo.setMajor((String)infomation.get("major"));
		updataUserInfo.setClass_num((String)infomation.get("class"));
		
		//将前台传输的需要修改的数据存储进updataFriendInfo中
		updataFriendInfo.setUserid(sessionUserInfo.getUserid());
		TargetBean targetBean = targetService.selectIdByContent(new TargetBean(null,(String)infomation.get("interest"),null));
		String currentState = "1";
		 if("on".equals((String)infomation.get("open"))) {
			 //表示当前用户同意公开自己的联系方式
			 currentState = "1";
		 }else {
			 //表示当前用户不同意公开自己的联系方式
			 currentState = "2";
		 }
		 updataFriendInfo.setTargetid(Integer.valueOf(targetBean.getTargetid()));
		 updataFriendInfo.setCurrent_state(currentState);
		 updataFriendInfo.setTarget_description(targetDescription);
		 
		 int userInfoUpadataResult = userInfoService.updataUserInfo(updataUserInfo);
		 int friendInfoUpdataResult = studyFriendService.updataFriendInfo(updataFriendInfo);
		 resultMap.put("UserInfoUpdataResult", userInfoUpadataResult);
		 resultMap.put("friendInfoUpdataResult", friendInfoUpdataResult);
		 resultMap.put("all", userInfoUpadataResult + friendInfoUpdataResult);
		 System.out.println(resultMap);
		 if(userInfoUpadataResult == 1) {
			 session.setAttribute("UserInfo", updataUserInfo);
		 }
		 return resultMap;
	}
	
	
	
	
	

}
