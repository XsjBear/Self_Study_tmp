package com.self_study.mapper;

import com.self_study.bean.FriendShipBean;

public interface IFriendShipMapper {

	/**
	 * 增加一个伙伴关系
	 * @param friendship
	 * @return
	 */
	public int addOne(FriendShipBean friendship);
	
}
