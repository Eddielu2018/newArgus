package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctSaleOrgXzDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;
import cn.htd.argus.service.HtyFctSaleOrgXzDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgXzDTOServiceImpl implements HtyFctSaleOrgXzDTOService{

    @Autowired
    private HtyFctSaleOrgXzDTOMapper dao;

    @Override
    public HtyFctSaleOrgXzDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgXzDTO dto = new HtyFctSaleOrgXzDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }
}
