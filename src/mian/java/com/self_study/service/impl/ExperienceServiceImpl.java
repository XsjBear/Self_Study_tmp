package com.self_study.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.TargetBean;
import com.self_study.mapper.IExperienceMapper;
import com.self_study.service.IExperienceService;


@Service
public class ExperienceServiceImpl implements IExperienceService {
	
	@Autowired
	private IExperienceMapper experienceMapper;

	@Override
	public ArrayList<TargetBean> selectAll() {
		return experienceMapper.selectAll();
	}

	

	
	

}
