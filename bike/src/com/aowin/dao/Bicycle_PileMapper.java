package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_Pile;

public interface Bicycle_PileMapper extends BaseMapper<Bicycle_Pile> {

	 //public int insertBicycle_Pile();不用做
	 //public int updateBicycle_Pile();不用做
	 public Bicycle_Pile searchPile(String Pile_code);
     //public List<Bicycle_Pile> listPile();不用做
     public int immigrateBicycle_Pile(Bicycle_Pile bicycle_pile);
     public int emigrateBicycle_Pile(String pile_code);
     
}