package com.self_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.UserInfoBean;
import com.self_study.mapper.IUserInfoMapper;
import com.self_study.service.IUserInfoService;


@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private IUserInfoMapper userInfoMapper;

	@Override
	public int addUser(UserInfoBean useInfo) {
		return userInfoMapper.addUser(useInfo);
	}

	@Override
	public UserInfoBean loginCheck(UserInfoBean userInfoBean) {
		return userInfoMapper.loginCheck(userInfoBean);
	}

	@Override
	public UserInfoBean selectByTel(UserInfoBean userInfoBean) {
		return userInfoMapper.selectByTel(userInfoBean);
	}

}
