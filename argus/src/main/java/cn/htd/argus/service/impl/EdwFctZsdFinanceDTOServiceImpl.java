package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctZsdFinanceDTO;
import cn.htd.argus.mappers.EdwFctZsdFinanceDTOMapper;
import cn.htd.argus.service.EdwFctZsdFinanceDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/11/9.
 */
public class EdwFctZsdFinanceDTOServiceImpl implements EdwFctZsdFinanceDTOService {

    @Autowired
    private EdwFctZsdFinanceDTOMapper dao;

    @Override
    public EdwFctZsdFinanceDTO select(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("endTime id is null");
        }
        HtyFctSaleSearchDTO dto = new HtyFctSaleSearchDTO();
        dto.setEndTime(endTime);
        dto.setUserId(userId);
        return dao.select(dto);
    }

    @Override
    public EdwFctZsdFinanceDTO selectSupport(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("endTime id is null");
        }
        HtyFctSaleSearchDTO dto = new HtyFctSaleSearchDTO();
        dto.setEndTime(endTime);
        dto.setUserId(userId);
        return dao.selectSupport(dto);
    }
}
