package com.aowin.dao;

import com.aowin.model.Bicycle_Data;
public interface Bicycle_DataMapper extends BaseMapper<Bicycle_Data> {
public Bicycle_Data singleData(Integer card_id);
public Bicycle_Data totalData();
public Bicycle_Data dealData();
public Bicycle_Data countRent();
public Bicycle_Data totalDataMonth();
public Bicycle_Data totalDataYear();
public Bicycle_Data singleDataMonth();
public Bicycle_Data singleDataYear();
public Bicycle_Data singleRecharge(Integer card_id);
public Bicycle_Data totalRecharge();
}
