package com.aowin.dao;

import com.aowin.model.Bicycle_Deploy;

//调配明细
public interface Bicycle_DeployMapper {
public int  insertBicycle_Deploy(Bicycle_Deploy bicycle_deploy);
//调出车辆时增加一个记录，调入部分不用写
//public Bicycle_Deploy Bicycle_DeploySearch(Integer deploy_id);
public int updateBicycle_Deploy(Bicycle_Deploy bicycle_deploy);
//调入的时候找到那个记录，并填写调入部分,并不需要删除之前，通过查询，bicyle id和 to_pileId 为null的情况 to_cardId不需要填写
public Bicycle_Deploy immigrateDeploy(Bicycle_Deploy bicycle_deploy);

}
