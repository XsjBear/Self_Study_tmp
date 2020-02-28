package com.self_study.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.TargetBean;
import com.self_study.mapper.ITargetMapper;
import com.self_study.service.ITargetService;


@Service
public class TargetServiceImpl implements ITargetService {
	
	@Autowired
	private ITargetMapper TargetMapper;

	@Override
	public ArrayList<TargetBean> selectAll() {
		return TargetMapper.selectAll();
	}
	
	

}
