package com.aowin.dao;

import com.aowin.model.Card_Record;

public interface Card_RecordMapper {//卡消费流水表

	public int insertRecord(Card_Record record);
  public Card_Record searchRecord(Card_Record record);
 public Card_Record searchRecharge(Integer card_id);
}
