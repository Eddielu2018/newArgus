package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctOrgCustIncomeSaleDTOMapper;
import cn.htd.argus.dto.HtyFctOrgCustIncomeSaleDTO;
import cn.htd.argus.service.HtyFctOrgCustIncomeSaleDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgCustIncomeSaleDTOServiceImpl implements HtyFctOrgCustIncomeSaleDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustIncomeSaleDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgCustIncomeSaleDTOMapper dao;

    @Override
    public HtyFctOrgCustIncomeSaleDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctOrgCustIncomeSaleDTO select(HtyFctOrgCustIncomeSaleDTO dto) {
        List<HtyFctOrgCustIncomeSaleDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
