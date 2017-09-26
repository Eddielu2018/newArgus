package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctOrgValueDTOMapper;
import cn.htd.argus.dto.HtyFctOrgValueDTO;
import cn.htd.argus.service.HtyFctOrgValueDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgValueDTOServiceImpl implements HtyFctOrgValueDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustIncomeSaleDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgValueDTOMapper dao;
    @Override
    public HtyFctOrgValueDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }
}
