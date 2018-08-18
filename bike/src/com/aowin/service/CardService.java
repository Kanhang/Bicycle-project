package com.aowin.service;

import java.util.Map;

import com.aowin.model.Card;
import com.aowin.model.Card_Info_Record;
import com.aowin.model.Card_Record;
import com.aowin.page.Page;

public interface CardService {
public  Page<Card>selectPage(int currentPage, Map<String,String> map);
public int insertCard(String card_code, int card_type,
		String name, String idcard,String sex, 
		String telphone, String mobile, String email,
		String address, String work,String createdate, String remark);
public int updateCard(String card_code,int card_type,String name,
		String idcard, String sex, String telphone, String mobile, String email,
 String address, String work);

	public Card Search(String card_code);
	public Card_Record searchRecharge(Integer integer);
public int recharge(Double money, String fee_type, String card_id );
public int reportLoss(String card_code);
public int logOff(String card_code,String reason);
//public int insertCard_Info_Record(Integer card_id,int info_type, String create_time,Integer user_id,String remark);

}
