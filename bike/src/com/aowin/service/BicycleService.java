package com.aowin.service;

import java.util.Map;

import com.aowin.model.Bicycle_Deal;
import com.aowin.model.Bicycle_Info;
import com.aowin.model.Bicycle_Pile;
import com.aowin.model.Bicycle_Record;
import com.aowin.model.Bicycle_Station;
import com.aowin.model.Card;

import com.aowin.page.Page;

public interface BicycleService {
	public  Page<Bicycle_Station> selectStationPage(int currentPage, Map<String,String> map);
	public  Page<Bicycle_Pile> selectPilePage(int currentPage, Map<String, String >map);
	public Page<Bicycle_Info>selectInfoPage(int currentPage, Map<String, String >map);
	public Page<Bicycle_Pile>selectImmigratePilePage(int currentPage, Map<String, String >map);
	public  int emigrate(Bicycle_Pile bicycle_pile,Integer bicycle_id ,Card card );
    public Bicycle_Pile search(String pile_code);
    public int immigrate(Integer bicycle_id,Integer Pile_id);
    public Page<Bicycle_Record>selectRecordPage(int currentPage, Map<String, String >map);
}
