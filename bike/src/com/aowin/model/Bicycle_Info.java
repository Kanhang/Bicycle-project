package com.aowin.model;

public class Bicycle_Info {

	Integer bicycle_id;
	String bicycle_code;
	String status;
	Integer pile_id;
	String destory_date;
	Integer user_id;
	String operator_time;
     Integer card_id;
     String remark;
	public Bicycle_Info(Integer bicycle_id, String bicycle_code, String status,
			Integer pile_id, String destory_date, Integer user_id,
			String operator_time, Integer card_id, String remark) {
		super();
		this.bicycle_id = bicycle_id;
		this.bicycle_code = bicycle_code;
		this.status = status;
		this.pile_id = pile_id;
		this.destory_date = destory_date;
		this.user_id = user_id;
		this.operator_time = operator_time;
		this.card_id = card_id;
		this.remark = remark;
	}
	public Bicycle_Info() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bicycle_Info [bicycle_id=" + bicycle_id + ", bicycle_code="
				+ bicycle_code + ", status=" + status + ", pile_id=" + pile_id
				+ ", destory_date=" + destory_date + ", user_id=" + user_id
				+ ", operator_time=" + operator_time + ", card_id=" + card_id
				+ ", remark=" + remark + "]";
	}
	public Integer getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Integer bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getBicycle_code() {
		return bicycle_code;
	}
	public void setBicycle_code(String bicycle_code) {
		this.bicycle_code = bicycle_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPile_id() {
		return pile_id;
	}
	public void setPile_id(Integer pile_id) {
		this.pile_id = pile_id;
	}
	public String getDestory_date() {
		return destory_date;
	}
	public void setDestory_date(String destory_date) {
		this.destory_date = destory_date;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
