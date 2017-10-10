package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctSaleOrgAllDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;
import cn.htd.argus.service.HtyFctSaleOrgAllDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgAllDTOServiceImpl implements HtyFctSaleOrgAllDTOService{

    @Autowired
    private HtyFctSaleOrgAllDTOMapper dao;

    @Override
    public HtyFctSaleOrgAllDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgAllDTO dto = new HtyFctSaleOrgAllDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }
}
