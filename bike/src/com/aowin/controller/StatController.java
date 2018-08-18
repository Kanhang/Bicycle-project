package com.aowin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aowin.model.Bicycle_Data;
import com.aowin.model.Bicycle_Info;
import com.aowin.model.Bicycle_Record;
import com.aowin.model.Card;
import com.aowin.page.Page;
import com.aowin.service.BicycleService;
import com.aowin.service.CardService;
import com.aowin.service.StatService;
@Controller
public class StatController {
	@Autowired
	private StatService statService;
	@Autowired
	private CardService cardService;
	@Autowired
	private BicycleService bicycleService;
	@RequestMapping(value = "/totalData")
	public ModelAndView totalDataService(Integer currentPage,
			@RequestParam() Map<String, String> queryMap) {
		ModelAndView mav = new ModelAndView();

		try {System.out.println(currentPage + "" + queryMap);
			Bicycle_Data totalData=statService.totalData();
			System.out.println("total_recharge"+totalData.getTotal_recharge());
	      mav.addObject("totalData",totalData );
	      Page<Card> page = cardService.selectPage(currentPage, queryMap);
			mav.addObject("page", page);
			mav.setViewName("/totalData.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;
}
	@RequestMapping(value = "/singleData")
	public ModelAndView singleDataService(Integer currentPage,
			@RequestParam() Map<String, String> queryMap,String card_code) {
		ModelAndView mav = new ModelAndView();
		Card card= cardService.Search(card_code);
		System.out.println("*************");
		System.out.println("card_code"+card_code);
		System.out.println("card_id"+card.getCard_id());	
		Integer card_id=card.getCard_id();

		try {System.out.println(currentPage + "" + queryMap);
			Bicycle_Data singleData=statService.singleData(card_id);
			System.out.println("total_spent"+singleData.getTotal_spent());
			System.out.println("total_recharge"+singleData.getTotal_recharge());
	      mav.addObject("singleData",singleData );
	    mav.addObject("card_id",card_id);
	      queryMap.put("card_id", String.valueOf(card_id));
	    Page<Bicycle_Record> page = bicycleService.selectRecordPage(currentPage, queryMap);
			mav.addObject("page", page);
			mav.setViewName("/singleData.jsp");
		} catch (Exception e) {
			mav.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		return mav;
}

}
