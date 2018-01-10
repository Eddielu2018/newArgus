package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctProdAllOrgDTO;
import cn.htd.argus.mappers.HtyFctProdAllOrgDTOMapper;
import cn.htd.argus.service.HtyFctProdAllOrgDTOService;
import cn.htd.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctProdAllOrgDTOServiceImpl implements HtyFctProdAllOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctProdAllOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctProdAllOrgDTOMapper dao;

    @Override
    public HtyFctProdAllOrgDTO queryAllHead(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        List<HtyFctProdAllOrgDTO> result = dao.selectAllHead(searchDTO);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<HtyFctProdAllOrgDTO> queryAllBottom(String userId, String endTime, Pager pager) {
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        return null;
    }
}
