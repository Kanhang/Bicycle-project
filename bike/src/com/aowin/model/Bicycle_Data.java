package com.aowin.model;

public class Bicycle_Data {
	Integer record_id;
	Integer bicycle_id;
	Integer card_id;
	String rent_time;
	Integer rent_pile_id;
	String return_time;
	Integer return_pile_id;
	Double money;
	String remark;
	Integer deal_id;
	String create_time;
	String deal_name;
	Double total_spent;
	String is_fee;
	Integer total;
	Integer rent_card;
	Double chg_money;
	Integer fee_type;
	Integer pile_id;
	Integer user_id;
	Double total_recharge;
	Double balance;
	Double frozen_balance;
	Integer total_rent_count;
	Integer total_rent_hours;
	String deal_type; 
	
	public Double getTotal_spent() {
		return total_spent;
	}
	@Override
	public String toString() {
		return "Bicycle_Data [record_id=" + record_id + ", bicycle_id="
				+ bicycle_id + ", card_id=" + card_id + ", rent_time="
				+ rent_time + ", rent_pile_id=" + rent_pile_id
				+ ", return_time=" + return_time + ", return_pile_id="
				+ return_pile_id + ", money=" + money + ", remark=" + remark
				+ ", deal_id=" + deal_id + ", create_time=" + create_time
				+ ", deal_name=" + deal_name + ", total_spent=" + total_spent
				+ ", is_fee=" + is_fee + ", total=" + total + ", rent_card="
				+ rent_card + ", chg_money=" + chg_money + ", fee_type="
				+ fee_type + ", pile_id=" + pile_id + ", user_id=" + user_id
				+ ", total_recharge=" + total_recharge + ", balance=" + balance
				+ ", frozen_balance=" + frozen_balance + ", total_rent_count="
				+ total_rent_count + ", total_rent_hours=" + total_rent_hours
				+ ", deal_type=" + deal_type + "]";
	}
	public Bicycle_Data() {
		// TODO Auto-generated constructor stub
	}
	public Bicycle_Data(Integer record_id, Integer bicycle_id, Integer card_id,
			String rent_time, Integer rent_pile_id, String return_time,
			Integer return_pile_id, Double money, String remark,
			Integer deal_id, String create_time, String deal_name,
			Double total_spent, String is_fee, Integer total,
			Integer rent_card, Double chg_money, Integer fee_type,
			Integer pile_id, Integer user_id, Double total_recharge,
			Double balance, Double frozen_balance, Integer total_rent_count,
			Integer total_rent_hours, String deal_type) {
		super();
		this.record_id = record_id;
		this.bicycle_id = bicycle_id;
		this.card_id = card_id;
		this.rent_time = rent_time;
		this.rent_pile_id = rent_pile_id;
		this.return_time = return_time;
		this.return_pile_id = return_pile_id;
		this.money = money;
		this.remark = remark;
		this.deal_id = deal_id;
		this.create_time = create_time;
		this.deal_name = deal_name;
		this.total_spent = total_spent;
		this.is_fee = is_fee;
		this.total = total;
		this.rent_card = rent_card;
		this.chg_money = chg_money;
		this.fee_type = fee_type;
		this.pile_id = pile_id;
		this.user_id = user_id;
		this.total_recharge = total_recharge;
		this.balance = balance;
		this.frozen_balance = frozen_balance;
		this.total_rent_count = total_rent_count;
		this.total_rent_hours = total_rent_hours;
		this.deal_type = deal_type;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRent_card() {
		return rent_card;
	}
	public void setRent_card(Integer rent_card) {
		this.rent_card = rent_card;
	}
	public void setTotal_spent(Double total_spent) {
		this.total_spent = total_spent;
	}
	public Double getTotal_recharge() {
		return total_recharge;
	}
	public void setTotal_recharge(Double total_recharge) {
		this.total_recharge = total_recharge;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getFrozen_balance() {
		return frozen_balance;
	}
	public void setFrozen_balance(Double frozen_balance) {
		this.frozen_balance = frozen_balance;
	}
	public Integer getTotal_rent_count() {
		return total_rent_count;
	}
	public void setTotal_rent_count(Integer total_rent_count) {
		this.total_rent_count = total_rent_count;
	}
	public Integer getTotal_rent_hours() {
		return total_rent_hours;
	}
	public void setTotal_rent_hours(Integer total_rent_hours) {
		this.total_rent_hours = total_rent_hours;
	}
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Integer bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public String getRent_time() {
		return rent_time;
	}
	public void setRent_time(String rent_time) {
		this.rent_time = rent_time;
	}
	public Integer getRent_pile_id() {
		return rent_pile_id;
	}
	public void setRent_pile_id(Integer rent_pile_id) {
		this.rent_pile_id = rent_pile_id;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public Integer getReturn_pile_id() {
		return return_pile_id;
	}
	public void setReturn_pile_id(Integer return_pile_id) {
		this.return_pile_id = return_pile_id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(Integer deal_id) {
		this.deal_id = deal_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getDeal_name() {
		return deal_name;
	}
	public void setDeal_name(String deal_name) {
		this.deal_name = deal_name;
	}
	public String getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(String deal_type) {
		this.deal_type = deal_type;
	}
	public String getIs_fee() {
		return is_fee;
	}
	public void setIs_fee(String is_fee) {
		this.is_fee = is_fee;
	}
	public Double getChg_money() {
		return chg_money;
	}
	public void setChg_money(Double chg_money) {
		this.chg_money = chg_money;
	}
	public Integer getFee_type() {
		return fee_type;
	}
	public void setFee_type(Integer fee_type) {
		this.fee_type = fee_type;
	}
	public Integer getPile_id() {
		return pile_id;
	}
	public void setPile_id(Integer pile_id) {
		this.pile_id = pile_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
}
