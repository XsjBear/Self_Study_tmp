package com.self_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.FriendBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.mapper.IStudyFriendMapper;
import com.self_study.service.IStudyFriendService;


@Service
public class StudyFriendServiceImpl implements IStudyFriendService {
	
	@Autowired
	private IStudyFriendMapper studyFriendMapper;

	@Override
	public FriendBean selectByUserId(UserInfoBean userInfoBean) {
		return studyFriendMapper.selectByUserId(userInfoBean);
	}
	
	

}
