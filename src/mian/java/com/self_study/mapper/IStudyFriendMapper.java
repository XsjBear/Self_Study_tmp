package com.self_study.mapper;

import com.self_study.bean.FriendBean;
import com.self_study.bean.UserInfoBean;

public interface IStudyFriendMapper {

	
	/**
	 * 按照session中的用户信息中的userid查找出friend表中关于当前用户的相关信息
	 * @param userInfoBean	session中存储的用户信息
	 * @return	friend表中关于此user的相关信息
	 */
	public FriendBean selectByUserId(UserInfoBean userInfoBean);
	
}
