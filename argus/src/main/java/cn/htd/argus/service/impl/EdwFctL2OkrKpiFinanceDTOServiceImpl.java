package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctL2OkrKpiFinanceDTO;
import cn.htd.argus.mappers.EdwFctL2OkrKpiFinanceDTOMapper;
import cn.htd.argus.service.EdwFctL2OkrKpiFinanceDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/11/9.
 */
public class EdwFctL2OkrKpiFinanceDTOServiceImpl implements EdwFctL2OkrKpiFinanceDTOService {

    @Autowired
    private EdwFctL2OkrKpiFinanceDTOMapper dao;
    @Override
    public EdwFctL2OkrKpiFinanceDTO select(String userId, String endTime) {
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
}
