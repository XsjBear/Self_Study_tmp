package com.self_study.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.service.IShareExperienceService;

/**
 * @author Xsj
 *
 */
@RestController
@RequestMapping("/experience")
public class ExperienceController {
	
	
	@Autowired
	private IShareExperienceService shareExperienceService;
	
	
	@RequestMapping("/addExperience")
	public int addExperience(HttpSession session ,String Info , String experienceContent) {
		JSONObject infomation = new JSONObject(Info);
		System.out.println(infomation + "  :  " + experienceContent);
		
		ShareExperienceBean shareExperience = new ShareExperienceBean();
		shareExperience.setUserid(String.valueOf(((UserInfoBean)session.getAttribute("UserInfo")).getUserid()));	//从session中获取userid并赋值
		shareExperience.setExperience(infomation.getString("shareType"));
		shareExperience.setExperience_title(infomation.getString("title"));
		shareExperience.setAnnoce_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//获取当前的时间
		shareExperience.setExperience_content(experienceContent);
		int result = shareExperienceService.addExperience(shareExperience);
		return result;
	}

}
