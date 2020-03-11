package com.self_study.mapper;

import java.util.ArrayList;

import com.self_study.bean.ExperienceBean;

public interface IExperienceMapper {

	/**
	 * 查询出所有内容
	 * @return
	 */
	public ArrayList<ExperienceBean> selectAll();
	
}
