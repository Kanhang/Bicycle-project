package com.aowin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.CardMapper;
import com.aowin.dao.Card_Info_RecordMapper;
import com.aowin.dao.Card_RecordMapper;
import com.aowin.model.Card;
import com.aowin.model.Card_Info_Record;
import com.aowin.model.Card_Record;
import com.aowin.page.Page;
import com.aowin.service.CardService;
import com.aowin.util.PageUtil;

@Transactional(rollbackFor = Exception.class)
public class CardServiceImpl implements CardService {
	@Autowired
	private CardMapper cardMapper;
	// 这里必要要写getter和setter 不然会报gettersetter错误

	@Autowired
	private Card_Info_RecordMapper card_Info_RecordMapper;
	@Autowired
	private Card_RecordMapper card_RecordMapper;

	public Card_RecordMapper getCard_RecordMapper() {
		return card_RecordMapper;
	}

	public void setCard_RecordMapper(Card_RecordMapper card_RecordMapper) {
		this.card_RecordMapper = card_RecordMapper;
	}

	public CardMapper getCardMapper() {
		return cardMapper;
	}

	public void setCardMapper(CardMapper cardMapper) {
		this.cardMapper = cardMapper;
	}

	public Card_Info_RecordMapper getCard_Info_RecordMapper() {
		return card_Info_RecordMapper;
	}

	public void setCard_Info_RecordMapper(
			Card_Info_RecordMapper card_Info_RecordMapper) {
		this.card_Info_RecordMapper = card_Info_RecordMapper;
	}

	@Transactional(rollbackFor = Exception.class)
	public Page<Card> selectPage(int currentPage, Map<String, String> map) {

		return PageUtil.selectPage(cardMapper, currentPage, map);

	}

	@Transactional(rollbackFor = Exception.class)
	public int insertCard(String card_code, int card_type, String name,
			String idcard, String sex, String telphone, String mobile,
			String email, String address, String work, String createdate,
			String remark) {
		Card addCard = new Card();
		Card_Info_Record addInfoRecord = new Card_Info_Record();
		addCard.setCard_code(card_code);
		addCard.setCard_type(card_type);
		addCard.setName(name);
		addCard.setIdcard(idcard);
		addCard.setSex(sex);
		addCard.setTelphone(telphone);
		addCard.setMobile(mobile);
		addCard.setEmail(email);
		addCard.setAddress(address);
		addCard.setWork(work);
		addCard.setZXBJ("0");
		addCard.setMonthly_money(0.0);
		addCard.setFrozen_money(0.0);
		addCard.setWallet_money(0.0);
		addCard.setStatus(1);
		int i = cardMapper.insertCard(addCard);
		Card card = cardMapper.searchCard(card_code);
		Integer card_id = card.getCard_id();
		addInfoRecord.setCreate_time(createdate);
		addInfoRecord.setUser_id(1);
		addInfoRecord.setRemark(remark);
		addInfoRecord.setCard_id(card_id);
		addInfoRecord.setInfo_type(1);
		int j = card_Info_RecordMapper.insertCardRecord(addInfoRecord);

		return i + j;
		// TODO Auto-generated method stub

	}

	@Transactional(rollbackFor = Exception.class)
	public int updateCard(String card_code, int card_type, String name,
			String idcard, String sex, String telphone, String mobile,
			String email, String address, String work) {
		Card updateCard = new Card();
		updateCard.setCard_code(card_code);
		updateCard.setCard_type(card_type);
		updateCard.setName(name);
		updateCard.setIdcard(idcard);
		updateCard.setSex(sex);
		updateCard.setTelphone(telphone);
		updateCard.setMobile(mobile);
		updateCard.setEmail(email);
		updateCard.setZXBJ("0");
		updateCard.setAddress(address);
		updateCard.setWork(work);
		updateCard.setStatus(1);
		int i = cardMapper.updateCard(updateCard);
		Card card = cardMapper.searchCard(card_code);
		Integer card_id = card.getCard_id();
		Card_Info_Record updateInfoRecord = new Card_Info_Record();
		updateInfoRecord.setCard_id(card_id);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String create_time = dateFormat.format(new Date());
		updateInfoRecord.setCreate_time(create_time);
		updateInfoRecord.setInfo_type(4);
		updateInfoRecord.setRemark("修改卡");
		updateInfoRecord.setUser_id(1);
		int j = card_Info_RecordMapper.insertCardRecord(updateInfoRecord);

		// TODO Auto-generated method stub
		return i + j;
	}

	public Card Search(String card_code) {
		// TODO Auto-generated method stub
		Card card = cardMapper.searchCard(card_code);
		return card;
	}

	@Transactional(rollbackFor = Exception.class)
	public int reportLoss(String card_code) {

		// TODO Auto-generated method stub

		int i = cardMapper.lossCard(card_code);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String create_time = dateFormat.format(new Date());
		Card_Info_Record lossCard = new Card_Info_Record();
		Card card = cardMapper.searchCard(card_code);
		Integer card_id = card.getCard_id();
		lossCard.setCreate_time(create_time);
		lossCard.setCard_id(card_id);
		lossCard.setInfo_type(2);
		lossCard.setRemark("挂失卡");
		int j = card_Info_RecordMapper.insertCardRecord(lossCard);
		return i + j;
	}

	@Transactional(rollbackFor = Exception.class)
	public int logOff(String card_code, String reason) {
		int i = cardMapper.logOffCard(card_code);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String create_time = dateFormat.format(new Date());
		Card_Info_Record lossCard = new Card_Info_Record();

		Card card = cardMapper.searchCard(card_code);
		double chg_monthly_money = -card.getMonthly_money();
		double chg_frozen_money = -card.getMonthly_money();
		double chg_wallet_money = -card.getWallet_money();
		Integer card_id = card.getCard_id();
		lossCard.setCreate_time(create_time);
		lossCard.setCard_id(card_id);
		lossCard.setInfo_type(3);
		lossCard.setRemark("注销卡");
		int j = card_Info_RecordMapper.insertCardRecord(lossCard);
		Card_Record record = new Card_Record();
		record.setCard_id(card_id);
		record.setChg_frozen_money(chg_frozen_money);
		record.setChg_monthly_money(chg_monthly_money);
		record.setChg_wallet_money(chg_wallet_money);
		record.setCreate_time(create_time);
		record.setUser_id(1);
		reason = "123";
		record.setRemark(reason);
		record.setZXBJ("1");
		record.setFee_type(2);
		int k = card_RecordMapper.insertRecord(record);
		return i + j + k;
	}

	public int insertCard(Card card) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateCard(Card card) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public int recharge(Double money, String fee_type, String card_id) {
		// TODO Auto-generated method stub
		Card card = new Card();
		int i = 0;
		Card_Record record = new Card_Record();
		card = cardMapper.searchCard(card_id);
		System.out.println("*********************");
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String create_time = dateFormat.format(new Date());
		record.setCreate_time(create_time);
		if (fee_type.equals("wallet")) {
			record.setFee_type(1);
			card.setWallet_money(money + card.getWallet_money());
			record.setChg_monthly_money(0.0);
			record.setChg_frozen_money(0.0);
			record.setChg_wallet_money(money);
			i = cardMapper.recharge_wallet(card);
			record.setRemark("充值钱包");
		} else if (fee_type.equals("monthly")) {
			record.setFee_type(2);
	
			card.setMonthly_money(money + card.getMonthly_money());
			i = cardMapper.recharge_monthly(card);
			record.setChg_monthly_money(money);
			record.setChg_frozen_money(0.0);
			record.setChg_wallet_money(0.0);
			record.setRemark("充值月票");
		}
		record.setZXBJ("0");
	record.setCard_id(card.getCard_id());
		record.setUser_id(1);

		int j = card_RecordMapper.insertRecord(record);
		System.out.println("&&&&&&&&&&&&&&&&&&&&7");
		return i + j;
	}

	public Card_Record searchRecharge(Integer card_id) {
		// TODO Auto-generated method stub
		Card_Record record= new Card_Record();
		record= card_RecordMapper.searchRecharge(card_id);
		return record ;
	}

}
