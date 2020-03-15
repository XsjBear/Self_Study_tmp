package com.self_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_study.bean.FriendShipBean;
import com.self_study.mapper.IFriendShipMapper;
import com.self_study.service.IFriendShipService;


@Service
public class FriendShipServiceImpl implements IFriendShipService {
	
	@Autowired
	private IFriendShipMapper friendShipMapper;

	@Override
	public int addOne(FriendShipBean friendship) {
		return friendShipMapper.addOne(friendship);
	}


	

	
	

}
