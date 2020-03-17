package com.self_study.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.FriendBean;
import com.self_study.bean.FriendInfoBean;
import com.self_study.bean.FriendShipBean;
import com.self_study.bean.StudyFriendInfoBean;
import com.self_study.bean.UserInfoBean;
import com.self_study.mapper.IStudyFriendMapper;
import com.self_study.service.IStudyFriendService;


@Service
public class StudyFriendServiceImpl implements IStudyFriendService {
	
	@Autowired
	private IStudyFriendMapper studyFriendMapper;

	@Override
	public FriendInfoBean selectByUserId(UserInfoBean userInfoBean) {
		return studyFriendMapper.selectByUserId(userInfoBean);
	}

	@Override
	public int addFriendInfo(FriendBean firendBean) {
		return studyFriendMapper.addFriendInfo(firendBean);
	}

	@Override
	public int updataFriendInfo(FriendBean firendBean) {
		return studyFriendMapper.updataFriendInfo(firendBean);
	}

	@Override
	public ArrayList<FriendShipBean> selectAll(UserInfoBean userInfo) {
		return studyFriendMapper.selectAll(userInfo);
	}

	@Override
	public ArrayList<StudyFriendInfoBean> selectMyFriend(UserInfoBean userInfo) {
		return studyFriendMapper.selectMyFriend(userInfo);
	}

	@Override
	public ArrayList<StudyFriendInfoBean> selectByList(List list) {
		return studyFriendMapper.selectByList(list);
	}

	@Override
	public ArrayList<StudyFriendInfoBean> selectNotFriendByList(List<Integer> list) {
		// TODO Auto-generated method stub
		return studyFriendMapper.selectNotFriendByList(list);
	}



}
