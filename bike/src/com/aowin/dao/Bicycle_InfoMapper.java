package com.aowin.dao;

import com.aowin.model.Bicycle_Info;

public interface Bicycle_InfoMapper extends BaseMapper<Bicycle_Info> {

	public int updateBicycle_Info();
	public int emigrate(Bicycle_Info bicycle_info);
	public int immigrate(Bicycle_Info bicycle_info);
}
