package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;
import cn.htd.argus.mappers.HtyFctProdDetailOrgDTOMapper;
import cn.htd.argus.service.HtyFctProdDetailOrgDTOService;
import cn.htd.common.Pager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/19.
 */
public class HtyFctProdDetailOrgDTOServiceImpl implements HtyFctProdDetailOrgDTOService {

    @Autowired
    private HtyFctProdDetailOrgDTOMapper dao;

    @Override
    public List<HtyFctProdDetailOrgDTO> queryAllBottom(String userId, String endTime, Pager pager) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        List<HtyFctProdDetailOrgDTO> result = dao.queryAllBottom(searchDTO, pager);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public Integer queryAllBottomCount(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);

        return dao.queryAllBottomCount(searchDTO);
    }
}
