package com.self_study.service;


import java.util.ArrayList;

import org.springframework.data.repository.query.Param;

import com.self_study.bean.ShareExperienceArticleBean;
import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.UserInfoBean;

public interface IShareExperienceService {

	
	/**
	 * 根据userid查询出对应的分享
	 * @param shareExperience
	 * @return
	 */
	public ArrayList<ShareExperienceBean> selectByUserId(UserInfoBean userInfo);
	
	
	/**
	 * 根据userid查询出除自己外的一些分享
	 * @param shareExperience
	 * @return
	 */
	public ArrayList<ShareExperienceBean> selectExceptSelf(UserInfoBean userInfo);
	

	
	
	/**
	 * 添加分享经验
	 * @return
	 */
	public int addExperience(ShareExperienceBean shareExperience);
	
	/**
	 * 根据shareid查询出对应的分享文章
	 * @param shareid
	 * @return
	 */
	public ShareExperienceArticleBean selectByShareId(@Param(value = "shareid") String shareid);
	

	
}
