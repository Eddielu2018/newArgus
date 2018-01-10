package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctInventoryTurnsOrgDTO;
import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;
import cn.htd.argus.mappers.HtyFctInventoryTurnsOrgDTOMapper;
import cn.htd.argus.service.HtyFctInventoryTurnsOrgDTOService;
import cn.htd.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctInventoryTurnsOrgDTOServiceImpl implements HtyFctInventoryTurnsOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctInventoryTurnsOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctInventoryTurnsOrgDTOMapper dao;

    @Override
    public List<HtyFctInventoryTurnsOrgDTO> queryInventoryTurns(String userId, String endTime, Pager pager, String range) {
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
        List<HtyFctInventoryTurnsOrgDTO> result = dao.queryInventoryTurns(searchDTO, pager);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Integer queryInventoryTurnsCount(String userId, String endTime, String range) {
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
        return dao.queryInventoryTurnsCount(searchDTO);
    }
}
