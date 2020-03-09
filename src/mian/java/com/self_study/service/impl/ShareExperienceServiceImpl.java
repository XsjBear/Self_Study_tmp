package com.self_study.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.mapper.IShareExperienceMapper;
import com.self_study.service.IShareExperienceService;


@Service
public class ShareExperienceServiceImpl implements IShareExperienceService {
	
	@Autowired
	private IShareExperienceMapper experienceMapper;

	@Override
	public ArrayList<ShareExperienceBean> selectByUserId(UserInfoBean userInfo) {
		// TODO Auto-generated method stub
		return experienceMapper.selectByUserId(userInfo);
	}


	

	
	

}
