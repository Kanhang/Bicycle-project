package com.aowin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.dao.Bicycle_DealMapper;
import com.aowin.dao.Bicycle_DeployMapper;
import com.aowin.dao.Bicycle_ImmigratePileMapper;
import com.aowin.dao.Bicycle_InfoMapper;
import com.aowin.dao.Bicycle_PileMapper;
import com.aowin.dao.Bicycle_RecordMapper;
import com.aowin.dao.Bicycle_StationMapper;
import com.aowin.model.Bicycle_Deal;
import com.aowin.model.Bicycle_Deploy;
import com.aowin.model.Bicycle_Info;
import com.aowin.model.Bicycle_Pile;
import com.aowin.model.Bicycle_Record;
import com.aowin.model.Bicycle_Station;
import com.aowin.model.Card;
import com.aowin.page.Page;
import com.aowin.service.BicycleService;
import com.aowin.util.PageUtil;

public class BicycleServiceImpl implements BicycleService {
      @Autowired
	private Bicycle_DealMapper bicycle_DealMapper;
      @Autowired
	private Bicycle_InfoMapper bicycle_InfoMapper;
      @Autowired
	private Bicycle_PileMapper bicycle_PileMapper;
      @Autowired
	private Bicycle_DeployMapper bicycle_DeployMapper;
      @Autowired
  	private Bicycle_StationMapper bicycle_StationMapper;
      @Autowired
  	private Bicycle_ImmigratePileMapper bicycle_ImmigratePileMapper;
      @Autowired
      private Bicycle_RecordMapper bicycle_RecordMapper;
	public Bicycle_RecordMapper getBicycle_RecordMapper() {
		return bicycle_RecordMapper;
	}
	public void setBicycle_RecordMapper(Bicycle_RecordMapper bicycle_RecordMapper) {
		this.bicycle_RecordMapper = bicycle_RecordMapper;
	}
	public Bicycle_ImmigratePileMapper getBicycle_ImmigratePileMapper() {
		return bicycle_ImmigratePileMapper;
	}
	public void setBicycle_ImmigratePileMapper(
			Bicycle_ImmigratePileMapper bicycle_ImmigratePileMapper) {
		this.bicycle_ImmigratePileMapper = bicycle_ImmigratePileMapper;
	}
	public Bicycle_StationMapper getBicycle_StationMapper() {
		return bicycle_StationMapper;
	}
	public void setBicycle_StationMapper(Bicycle_StationMapper bicycle_StationMapper) {
		this.bicycle_StationMapper = bicycle_StationMapper;
	}
	public Bicycle_DealMapper getBicycle_DealMapper() {
		return bicycle_DealMapper;
	}
	public void setBicycle_DealMapper(Bicycle_DealMapper bicycle_DealMapper) {
		this.bicycle_DealMapper = bicycle_DealMapper;
	}
	public Bicycle_InfoMapper getBicycle_InfoMapper() {
		return bicycle_InfoMapper;
	}
	public void setBicycle_InfoMapper(Bicycle_InfoMapper bicycle_InfoMapper) {
		this.bicycle_InfoMapper = bicycle_InfoMapper;
	}
	public Bicycle_PileMapper getBicycle_PileMapper() {
		return bicycle_PileMapper;
	}
	public void setBicycle_PileMapper(Bicycle_PileMapper bicycle_PileMapper) {
		this.bicycle_PileMapper = bicycle_PileMapper;
	}
	public Bicycle_DeployMapper getBicycle_DeployMapper() {
		return bicycle_DeployMapper;
	}
	public void setBicycle_DeployMapper(Bicycle_DeployMapper bicycle_DeployMapper) {
		this.bicycle_DeployMapper = bicycle_DeployMapper;
	}
	@Transactional(rollbackFor=Exception.class)
	public Page<Bicycle_Station> selectStationPage(int currentPage,
			Map<String, String> map) {
		return PageUtil.selectPage(bicycle_StationMapper, currentPage, map);
	}
@Transactional(rollbackFor=Exception.class)
	public Page<Bicycle_Pile> selectPilePage(int currentPage,
			Map<String, String> map) {
		System.out.println(bicycle_PileMapper+" && "+currentPage+"&&"+map);
		// TODO Auto-generated method stub
		return PageUtil.selectPage(bicycle_PileMapper, currentPage, map);
	}

	@Transactional(rollbackFor=Exception.class)
public int emigrate(Bicycle_Pile bicycle_pile, Integer bicycle_id,Card card) {
	// TODO Auto-generated method stub
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String create_time=dateFormat.format(new Date());
		Bicycle_Deploy bicycle_deploy= new Bicycle_Deploy();
		bicycle_deploy.setBicycle_id(bicycle_id);
		bicycle_deploy.setFrom_card_id(card.getCard_id());
		bicycle_deploy.setFrom_pile_id(bicycle_pile.getPile_id());
	bicycle_deploy.setFrom_time(create_time);
	bicycle_deploy.setRemark("普通调出");
	bicycle_deploy.setStatus("4");
bicycle_deploy.setTo_reason("普通调出");
bicycle_deploy.setFrom_reason("普通调出");
//deploy和deal需要设置自增
int k=bicycle_DeployMapper.insertBicycle_Deploy(bicycle_deploy);
	
		Bicycle_Deal bicycle_Deal = new Bicycle_Deal();
		bicycle_Deal.setChg_money(0.0);
		bicycle_Deal.setCreate_time(create_time);
		bicycle_Deal.setDeal_name("普通调出");
		bicycle_Deal.setDeal_type("4");
		bicycle_Deal.setRecord_id(1);//租借记录表？？
		bicycle_Deal.setCard_id(card.getCard_id());
		bicycle_Deal.setIs_fee("0");
		bicycle_Deal.setFee_type(4);
		bicycle_Deal.setBicycle_id(bicycle_id);
		bicycle_Deal.setPile_id(bicycle_pile.getPile_id());
		bicycle_Deal.setUser_id(1);
		int l= bicycle_DealMapper.insertBicycle_Deal(bicycle_Deal);
		Bicycle_Info bicycle_info= new Bicycle_Info();
		bicycle_info.setBicycle_id(bicycle_id);
		bicycle_info.setCard_id(card.getCard_id());
	int i=bicycle_InfoMapper.emigrate(bicycle_info);
	int j=bicycle_PileMapper.emigrateBicycle_Pile(bicycle_pile.getPile_code());
 System.out.println("i="+i+"j="+j+"k="+k+"l="+l);
	return i+j+k+l;
}
	public Bicycle_Pile search(String pile_code) {
		// TODO Auto-generated method stub

		return bicycle_PileMapper.searchPile(pile_code);
	}
	public Page<Bicycle_Info> selectInfoPage(int currentPage,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		return PageUtil.selectPage(bicycle_InfoMapper, currentPage, map);
	}
	public Page<Bicycle_Pile> selectImmigratePilePage(int currentPage,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		return PageUtil.selectPage(bicycle_ImmigratePileMapper, currentPage, map);
	}
	public Page<Bicycle_Record> selectRecordPage(int currentPage,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		return PageUtil.selectPage(bicycle_RecordMapper,currentPage, map);
	}
	

	@Transactional(rollbackFor=Exception.class)
	public int immigrate(Integer bicycle_id, Integer pile_id) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String create_time=dateFormat.format(new Date());
		Bicycle_Info bicycle_info= new Bicycle_Info();
		bicycle_info.setBicycle_id(bicycle_id);
		bicycle_info.setPile_id(pile_id);
		int i=bicycle_InfoMapper.immigrate(bicycle_info);
		Bicycle_Deploy bicycle_deploy= new Bicycle_Deploy();
		bicycle_deploy.setBicycle_id(bicycle_id);
	bicycle_deploy= bicycle_DeployMapper.immigrateDeploy(bicycle_deploy);
	bicycle_deploy.setBicycle_id(bicycle_id);	
	bicycle_deploy.setTo_pile_id(pile_id);
		bicycle_deploy.setTo_reason("普通调入");
		bicycle_deploy.setTo_time(create_time);
		bicycle_deploy.setStatus("5");
		bicycle_deploy.setRemark("普通调入");
		int j= bicycle_DeployMapper.updateBicycle_Deploy(bicycle_deploy);
		Bicycle_Deal bicycle_deal= new Bicycle_Deal();
		bicycle_deal.setCreate_time(create_time);
		bicycle_deal.setDeal_name("普通调入");
		bicycle_deal.setDeal_type("5");
		bicycle_deal.setRecord_id(1);
		bicycle_deal.setIs_fee("0");
		bicycle_deal.setChg_money(0.0);
		bicycle_deal.setFee_type(5);
		bicycle_deal.setBicycle_id(bicycle_id);
		bicycle_deal.setPile_id(pile_id);
		bicycle_deal.setUser_id(1);
		bicycle_deal.setCard_id(-1);
		int k=bicycle_DealMapper.insertBicycle_Deal(bicycle_deal);
		Bicycle_Pile bicycle_pile= new Bicycle_Pile();
		bicycle_pile.setPile_id(pile_id);
		bicycle_pile.setBicycle_id(String.valueOf(bicycle_id));

		int l=bicycle_PileMapper.immigrateBicycle_Pile(bicycle_pile);
		System.out.println("i="+i+"j="+j+"k="+k+"l="+l);
		
		
		return i+j+k+l;
	}

	
}
