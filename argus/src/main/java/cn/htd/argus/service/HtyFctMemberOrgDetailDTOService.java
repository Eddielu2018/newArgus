package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctMemberOrgDetail;

import java.util.List;

/**
 * Created by suntao on 2017/10/31.
 */
public interface HtyFctMemberOrgDetailDTOService {
    HtyFctMemberOrgDetail selectByPrimaryKey(Long id);
    List<HtyFctMemberOrgDetail> querySaleNumEachShop(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    HtyFctMemberOrgDetail queryAllXsAmtEachMonth(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    HtyFctMemberOrgDetail queryByCustCode(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
    List<HtyFctMemberOrgDetail>  querySaleNumEachShopAll(HtyFctMemberOrgDetail htyFctMemberOrgDetail);
}
