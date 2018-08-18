package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aowin.dao.Bicycle_DataMapper;
import com.aowin.model.Bicycle_Data;
import com.aowin.service.StatService;

public class StatServiceImpl implements StatService {

@Autowired
	private Bicycle_DataMapper bicycle_DataMapper;

public Bicycle_Data totalData() {
	// TODO Auto-generated method stub
	Bicycle_Data bicycle_data= bicycle_DataMapper.totalData();

	bicycle_data.setRent_card(bicycle_DataMapper.countRent().getRent_card());
	bicycle_data.setTotal_recharge(bicycle_DataMapper.totalRecharge().getTotal_recharge());
	System.out.println(bicycle_DataMapper.totalRecharge().getTotal_recharge());
	return bicycle_data;
}

public Bicycle_DataMapper getBicycle_DataMapper() {
	return bicycle_DataMapper;
}

public void setBicycle_DataMapper(Bicycle_DataMapper bicycle_DataMapper) {
	this.bicycle_DataMapper = bicycle_DataMapper;
}

public Bicycle_Data singleData(Integer card_id) {
	Bicycle_Data bicycle_data=bicycle_DataMapper.singleData(card_id);
	System.out.println("哈哈哈"+bicycle_data.getCard_id());
	if(bicycle_DataMapper.singleRecharge(card_id)!=null){//只要没有充值记录就返回null
		
	bicycle_data.setTotal_recharge(bicycle_DataMapper.singleRecharge(card_id).getTotal_recharge());
	if(bicycle_DataMapper.singleRecharge(card_id).getTotal_recharge()==null){
		bicycle_data.setTotal_recharge(0.0);
	}
	
	System.out.println(bicycle_DataMapper.singleRecharge(card_id).getTotal_recharge());
	}
	else {
		bicycle_data.setTotal_recharge(0.0);
	
	}return bicycle_data;
}




}
