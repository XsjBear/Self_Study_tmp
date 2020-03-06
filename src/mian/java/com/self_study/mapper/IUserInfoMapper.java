package com.self_study.mapper;

import com.self_study.bean.UserInfoBean;


public interface IUserInfoMapper {

	/**
	 * 增加用户
	 * @param useInfo	新加用户的相关信息
	 * @return	操作成功的行数
	 */
	public int addUser(UserInfoBean useInfo);
	
	/**
	 * 对用户的登陆行为进行验证
	 * @param userInfoBean
	 * @return
	 */
	public UserInfoBean loginCheck(UserInfoBean userInfoBean);
	
	
	/**
	 * 根据用户的手机号进行查询，如果存在则返回用户信息。
	 * @param userInfoBean
	 * @return
	 */
	public UserInfoBean selectByTel(UserInfoBean userInfoBean);
	
	
	/**
	 * 根据userid查询出用户的相关信息
	 * @return
	 */
	public UserInfoBean selectAllByUserId(UserInfoBean userInfo);
	
	
	/**
	 * 根据userid以及传输的数据更新用户信息
	 * @param userInfoBean
	 * @return
	 */
	public int updataUserInfo(UserInfoBean userInfoBean);
	
}
