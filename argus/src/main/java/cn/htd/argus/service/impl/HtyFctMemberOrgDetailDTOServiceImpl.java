package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctMemberOrgDetailMapper;
import cn.htd.argus.dto.HtyFctMemberOrgDetail;
import cn.htd.argus.service.HtyFctMemberOrgDetailDTOService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class HtyFctMemberOrgDetailDTOServiceImpl implements HtyFctMemberOrgDetailDTOService {
    @Autowired
    private HtyFctMemberOrgDetailMapper htyFctMemberOrgDetailMapperDao;
    @Override
    public HtyFctMemberOrgDetail selectByPrimaryKey(Long id) {
        return htyFctMemberOrgDetailMapperDao.selectByPrimaryKey(id);
    }

    @Override
    public List<HtyFctMemberOrgDetail> querySaleNumEachShop(HtyFctMemberOrgDetail htyFctMemberOrgDetail) {
        return htyFctMemberOrgDetailMapperDao.querySaleNumEachShop(htyFctMemberOrgDetail);
    }

    @Override
    public HtyFctMemberOrgDetail queryAllXsAmtEachMonth(HtyFctMemberOrgDetail htyFctMemberOrgDetail) {
        return htyFctMemberOrgDetailMapperDao.queryAllXsAmtEachMonth(htyFctMemberOrgDetail);
    }
    @Override
    public HtyFctMemberOrgDetail queryByCustCode(HtyFctMemberOrgDetail htyFctMemberOrgDetail) {
        return htyFctMemberOrgDetailMapperDao.queryByCustCode(htyFctMemberOrgDetail);
    }

    @Override
    public List<HtyFctMemberOrgDetail> querySaleNumEachShopAll(HtyFctMemberOrgDetail htyFctMemberOrgDetail) {
        return htyFctMemberOrgDetailMapperDao.querySaleNumEachShopAll(htyFctMemberOrgDetail);
    }
}
