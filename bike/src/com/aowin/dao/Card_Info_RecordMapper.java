package com.aowin.dao;

import com.aowin.model.Card_Info_Record;

public interface Card_Info_RecordMapper {//卡变动记录表
public int insertCardRecord(Card_Info_Record record);
public Card_Info_RecordMapper searchCardRecord(Card_Info_Record record);

}
