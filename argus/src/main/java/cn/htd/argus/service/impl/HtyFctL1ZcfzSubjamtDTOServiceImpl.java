package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctL1ZcfzSubjamtDTOMapper;
import cn.htd.argus.service.HtyFctL1ZcfzSubjamtDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/31.
 */
public class HtyFctL1ZcfzSubjamtDTOServiceImpl implements HtyFctL1ZcfzSubjamtDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctL1ZcfzSubjamtDTOServiceImpl.class);

    @Autowired
    private HtyFctL1ZcfzSubjamtDTOMapper dao;
}
