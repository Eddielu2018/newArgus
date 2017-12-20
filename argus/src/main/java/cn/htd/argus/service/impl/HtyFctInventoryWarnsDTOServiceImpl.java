package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctInventoryWarnsDTO;
import cn.htd.argus.mappers.HtyFctInventoryWarnsDTOMapper;
import cn.htd.argus.service.HtyFctInventoryWarnsDTOService;
import cn.htd.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/19.
 */
public class HtyFctInventoryWarnsDTOServiceImpl implements HtyFctInventoryWarnsDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctInventoryWarnsDTOServiceImpl.class);

    @Autowired
    private HtyFctInventoryWarnsDTOMapper dao;

    @Override
    public List<HtyFctInventoryWarnsDTO> queryInventoryWarns(String userId, String endTime, Pager pager, String range) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        searchDTO.setRange(range);
        List<HtyFctInventoryWarnsDTO> result = dao.queryInventoryWarns(searchDTO, pager);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Integer queryInventoryWarnsCount(String userId, String endTime, String range) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        searchDTO.setRange(range);
        return dao.queryInventoryWarnsCount(searchDTO);
    }
}
