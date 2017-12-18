package cn.htd.argus.service.impl;

import cn.htd.argus.mappers.HtyFctProdAllOrgDTOMapper;
import cn.htd.argus.service.HtyFctProdAllOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctProdAllOrgDTOServiceImpl implements HtyFctProdAllOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctProdAllOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctProdAllOrgDTOMapper dao;
}
