package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctOrgCustDTOMapper;
import cn.htd.argus.dto.HtyFctOrgCustDTO;
import cn.htd.argus.service.HtyFctOrgCustDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgCustDTOServiceImpl implements HtyFctOrgCustDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgCustDTOMapper dao;

    @Override
    public HtyFctOrgCustDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }
}
