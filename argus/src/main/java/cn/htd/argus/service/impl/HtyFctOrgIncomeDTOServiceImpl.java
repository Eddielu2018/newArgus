package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctOrgCustIncomeSaleDTOMapper;
import cn.htd.argus.dao.HtyFctOrgIncomeDTOMapper;
import cn.htd.argus.dto.HtyFctOrgIncomeDTO;
import cn.htd.argus.service.HtyFctOrgIncomeDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgIncomeDTOServiceImpl implements HtyFctOrgIncomeDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgIncomeDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgIncomeDTOMapper dao;

    @Override
    public HtyFctOrgIncomeDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }
}
