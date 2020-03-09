package com.self_study.mapper;

import java.util.ArrayList;

import com.self_study.bean.ShareExperienceBean;
import com.self_study.bean.UserInfoBean;

public interface IShareExperienceMapper {

	
	/**
	 * 根据userid查询出对应的分享
	 * @param shareExperience
	 * @return
	 */
	public ArrayList<ShareExperienceBean> selectByUserId(UserInfoBean userInfo);
	
}
