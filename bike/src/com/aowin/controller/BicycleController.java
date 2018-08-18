package com.aowin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aowin.model.Bicycle_Info;
import com.aowin.model.Bicycle_Pile;
import com.aowin.model.Bicycle_Station;
import com.aowin.model.Card;
import com.aowin.page.Page;
import com.aowin.service.BicycleService;
import com.aowin.service.CardService;

@Controller
@SessionAttributes({ "error" })
public class BicycleController  {
	@Autowired
	private BicycleService bicycleService;
	@Autowired
	private CardService cardService;
	@RequestMapping(value="/stationDatalist")
	public ModelAndView stationDataListService(Integer currentPage,@RequestParam()Map<String,String>queryMap){
		ModelAndView mav=new ModelAndView();
		System.out.println(currentPage + "" + queryMap);
		System.out.println("%%%%%%");
		try{Page<Bicycle_Station>page= bicycleService.selectStationPage(currentPage, queryMap);
		System.out.println("*******"+page);
		mav.addObject("page",page);
		mav.setViewName("/emigrate.jsp");
		}catch(Exception e){
			mav.addObject("error", e.getMessage());
			mav.setViewName("/main.jsp");
		}
		return mav;
	}@RequestMapping(value="/stationTransfer")
	public ModelAndView stationTransferService(Integer station_id ){
		
		ModelAndView mav= new ModelAndView();
	mav.addObject("station_id",station_id);
	mav.setViewName("/pile.jsp");
		return mav;
	}
	@RequestMapping(value="/bicycleTransfer")
	public ModelAndView bicycleTransferService(Integer bicycle_id ){
		System.out.println("哈哈哈哈哈");
		System.out.println(bicycle_id);
		ModelAndView mav= new ModelAndView();
	mav.addObject("bicycle_id",bicycle_id);
	mav.setViewName("/immigrate_pile.jsp");
		return mav;
	}
	@RequestMapping(value="/pileDatalist")
	public ModelAndView pileDataListService(Integer currentPage,@RequestParam()Map<String,String>queryMap,String station_id){
		ModelAndView mav=new ModelAndView();
		try{queryMap.put("station_id", station_id);
			System.out.println(currentPage + "" + queryMap);
		
		Page<Bicycle_Pile>page= bicycleService.selectPilePage(currentPage, queryMap);
	  mav.addObject("station_id",station_id);
		mav.addObject("page",page);
		mav.setViewName("/pile.jsp");
		}catch(Exception e){
			e.printStackTrace();
			
			mav.addObject("error",e.getMessage());
			mav.setViewName("/main.jsp");
			
		}
		
		return mav;
	}
	@RequestMapping(value="/bicyclesDatalist")
	public ModelAndView bicyclesDataListService(Integer currentPage,@RequestParam()Map<String,String>queryMap){
		ModelAndView mav=new ModelAndView();
		try{
		
		Page<Bicycle_Info>page= bicycleService.selectInfoPage(currentPage, queryMap);

		mav.addObject("page",page);
		mav.setViewName("/bicycles.jsp");
		}catch(Exception e){
			e.printStackTrace();
			
			mav.addObject("error",e.getMessage());
			mav.setViewName("/main.jsp");
			
		}
		
		return mav;
	}
	@RequestMapping(value="/pileImmigrateDatalist")
	public ModelAndView pileImmigrateDataListService(Integer currentPage,@RequestParam()Map<String,String>queryMap){
		ModelAndView mav=new ModelAndView();
		try{
		
		Page<Bicycle_Pile>page= bicycleService.selectImmigratePilePage(currentPage, queryMap);

		mav.addObject("page",page);
		mav.setViewName("/immigrate_pile.jsp");
		}catch(Exception e){
			e.printStackTrace();
			
			mav.addObject("error",e.getMessage());
			mav.setViewName("/main.jsp");
			
		}
		
		return mav;
	}
	@RequestMapping(value="/emigrate",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String emigrateService( String card_code, String pile_code, String bicycle_id, Model model){
	
	
		try{
			Bicycle_Pile bicycle_pile= bicycleService.search(pile_code);
		Card card=cardService.Search(card_code);
		
		if(card==null){
			System.out.println("卡号不存在");
	return "卡号不存在";
         
		}
		else if(card.getCard_type()==4){
       int i= bicycleService.emigrate(bicycle_pile, Integer.parseInt(bicycle_id),card ) ;	
		if(i!=4){
		
			return "服务端异常";
		}
	return "调出成功";
		}else{
			return "卡号类型并非员工卡，无法调出";
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		return "未知错误，联系控制台";
		}
	
	}
	

@RequestMapping(value="/immigrate",produces = "application/json;charset=utf-8")
@ResponseBody
public String immigrateService( Integer bicycle_id,  Integer pile_id,Model model){
	try{//调配明细 业务流水 车桩 bicycle_info
		System.out.println(pile_id);
		int i= bicycleService.immigrate(bicycle_id, pile_id);
		
		if(i!=4){
			
			return "服务端异常";
		}
		return "调入成功";
	}
	catch(Exception e){
		e.printStackTrace();
	return "未知错误，联系控制台";
	}

}

}
