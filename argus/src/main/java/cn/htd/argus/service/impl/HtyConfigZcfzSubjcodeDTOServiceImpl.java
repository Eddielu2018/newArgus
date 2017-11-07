package cn.htd.argus.service.impl;

import cn.htd.argus.mappers.HtyConfigZcfzSubjcodeDTOMapper;
import cn.htd.argus.service.HtyConfigZcfzSubjcodeDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/10/31.
 */
public class HtyConfigZcfzSubjcodeDTOServiceImpl implements HtyConfigZcfzSubjcodeDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyConfigZcfzSubjcodeDTOServiceImpl.class);

    @Autowired
    private HtyConfigZcfzSubjcodeDTOMapper dao;
}
