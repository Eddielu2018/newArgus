package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctSaleOrgProdDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;
import cn.htd.argus.service.HtyFctSaleOrgProdDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgProdDTOServiceImpl implements HtyFctSaleOrgProdDTOService{

    @Autowired
    private HtyFctSaleOrgProdDTOMapper dao;

    @Override
    public HtyFctSaleOrgProdDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgProdDTO dto = new HtyFctSaleOrgProdDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }
}
