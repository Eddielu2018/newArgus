package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctSaleXzHotDTOMapper;
import cn.htd.argus.dto.HtyFctSaleXzHotDTO;
import cn.htd.argus.service.HtyFctSaleXzHotDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleXzHotDTOServiceImpl implements HtyFctSaleXzHotDTOService{

    @Autowired
    private HtyFctSaleXzHotDTOMapper dao;

    @Override
    public HtyFctSaleXzHotDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleXzHotDTO dto = new HtyFctSaleXzHotDTO();
        return null;
    }
}
