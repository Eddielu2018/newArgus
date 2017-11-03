package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctL2DupontDTOMapper;
import cn.htd.argus.service.HtyFctL2DupontDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/31.
 */
public class HtyFctL2DupontDTOServiceImpl implements HtyFctL2DupontDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctL2DupontDTOServiceImpl.class);

    @Autowired
    private HtyFctL2DupontDTOMapper dao;
}
