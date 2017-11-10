package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.mappers.HtyFctL2DupontDTOMapper;
import cn.htd.argus.dto.HtyFctL2DupontDTO;
import cn.htd.argus.service.HtyFctL2DupontDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/31.
 */
public class HtyFctL2DupontDTOServiceImpl implements HtyFctL2DupontDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctL2DupontDTOServiceImpl.class);

    @Autowired
    private HtyFctL2DupontDTOMapper dao;

    @Override
    public HtyFctL2DupontDTO select(String userId, String endTime) {
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
    public HtyFctL2DupontDTO selectTb(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("endTime id is null");
        }
        HtyFctSaleSearchDTO dto = new HtyFctSaleSearchDTO();
        dto.setEndTime(endTime);
        dto.setUserId(userId);
        return dao.selectTb(dto);
    }
}
