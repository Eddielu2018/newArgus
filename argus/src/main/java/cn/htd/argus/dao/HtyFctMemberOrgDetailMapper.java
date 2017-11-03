package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctMemberOrgDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface HtyFctMemberOrgDetailMapper {
    HtyFctMemberOrgDetail selectByPrimaryKey(Long id);
    List<HtyFctMemberOrgDetail> querySaleNumEachShop(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    HtyFctMemberOrgDetail queryAllXsAmtEachMonth(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    HtyFctMemberOrgDetail queryByCustCode(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    List<HtyFctMemberOrgDetail>  querySaleNumEachShopAll(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
}
