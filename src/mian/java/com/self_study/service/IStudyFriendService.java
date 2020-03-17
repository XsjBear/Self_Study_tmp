package com.self_study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.self_study.bean.FriendBean;
import com.self_study.bean.FriendInfoBean;
import com.self_study.bean.FriendShipBean;
import com.self_study.bean.StudyFriendInfoBean;
import com.self_study.bean.UserInfoBean;

public interface IStudyFriendService {

	/**
	 * 按照session中的用户信息中的userid查找出friend表中关于当前用户的相关信息
	 * @param userInfoBean	session中存储的用户信息
	 * @return	friend表中关于此user的相关信息
	 */
	public FriendInfoBean selectByUserId(UserInfoBean userInfoBean);
	
	/**
	 *插入相关信息
	 * @param firendBean
	 * @return
	 */
	public int addFriendInfo(FriendBean firendBean);
	
	/**
	 *更新相关信息
	 * @param firendBean
	 * @return
	 */
	public int updataFriendInfo(FriendBean firendBean);
	
	/**
	 * 查询出friend表中所有的非好友用户
	 * @return
	 */
	public ArrayList<FriendShipBean> selectAll(UserInfoBean userInfo);
	
	/**
	 * 查询出friend表中所有的好友用户信息
	 * @return
	 */
	public ArrayList<StudyFriendInfoBean> selectMyFriend(UserInfoBean userInfo);
	
	
	/**
	 * 根据list中的userid值查询出对应的好友信息
	 * @param list
	 * @return
	 */
	public ArrayList<StudyFriendInfoBean> selectByList(@Param("list")List<Integer> list);
	
	/**
	 * 根据list中的userid值查询出对应的非好友信息
	 * @param list
	 * @return
	 */
	public ArrayList<StudyFriendInfoBean> selectNotFriendByList(@Param("list")List<Integer> list);
}
