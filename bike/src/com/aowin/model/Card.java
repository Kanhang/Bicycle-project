package com.aowin.model;

public class Card {
	Integer card_id;
	String card_code;
	int  card_type;
	String name;
	String idcard;
	String sex;
    String telphone;
    String mobile;
    String email;
    String address;
    String work;
    String ZXBJ;
   Double monthly_money;
   Double frozen_money;
   Double wallet_money;
   Integer status;
   public Card(){};
public Integer getCard_id() {
	return card_id;
}
public void setCard_id(Integer card_id) {
	this.card_id = card_id;
}
public String getCard_code() {
	return card_code;
}
public void setCard_code(String card_code) {
	this.card_code = card_code;
}
public int getCard_type() {
	return card_type;
}
public void setCard_type(int card_type) {
	this.card_type = card_type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}

public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getWork() {
	return work;
}
public void setWork(String work) {
	this.work = work;
}
public String getZXBJ() {
	return ZXBJ;
}
public void setZXBJ(String zXBJ) {
	ZXBJ = zXBJ;
}
public Double getMonthly_money() {
	return monthly_money;
}
public void setMonthly_money(Double monthly_money) {
	this.monthly_money = monthly_money;
}
public Double getFrozen_money() {
	return frozen_money;
}
public void setFrozen_money(Double frozen_money) {
	this.frozen_money = frozen_money;
}
public Double getWallet_money() {
	return wallet_money;
}
public void setWallet_money(Double wallet_money) {
	this.wallet_money = wallet_money;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}

}
