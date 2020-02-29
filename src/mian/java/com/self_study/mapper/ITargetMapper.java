package com.self_study.mapper;

import java.util.ArrayList;

import com.self_study.bean.TargetBean;

public interface ITargetMapper {

	/**
	 * 查询出所有的目标
	 * @return
	 */
	public ArrayList<TargetBean> selectAll();
	
	
	/**
	 * 通过内容查询出id等信息
	 * @param targetBean
	 * @return
	 */
	public TargetBean selectIdByContent(TargetBean targetBean);
	
}
