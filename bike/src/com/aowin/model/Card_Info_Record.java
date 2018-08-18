package com.aowin.model;

public class Card_Info_Record {
	Integer record_id;
	Integer card_id;
	int info_type;
	String create_time;
	int user_id;
	String remark;
	public Card_Info_Record(){}
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public int getInfo_type() {
		return info_type;
	}
	public void setInfo_type(int info_type) {
		this.info_type = info_type;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
