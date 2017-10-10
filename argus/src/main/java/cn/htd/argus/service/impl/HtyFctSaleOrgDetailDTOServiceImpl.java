package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctSaleOrgDetailDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.argus.service.HtyFctSaleOrgDetailDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgDetailDTOServiceImpl implements HtyFctSaleOrgDetailDTOService{

    @Autowired
    private HtyFctSaleOrgDetailDTOMapper dao;

    @Override
    public HtyFctSaleOrgDetailDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgDetailDTO dto = new HtyFctSaleOrgDetailDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }
}
