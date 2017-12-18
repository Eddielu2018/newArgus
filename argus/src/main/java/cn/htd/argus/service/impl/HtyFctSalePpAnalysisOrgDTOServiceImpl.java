package cn.htd.argus.service.impl;

import cn.htd.argus.mappers.HtyFctSalePpAnalysisOrgDTOMapper;
import cn.htd.argus.service.HtyFctSalePpAnalysisOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctSalePpAnalysisOrgDTOServiceImpl implements HtyFctSalePpAnalysisOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctSalePpAnalysisOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctSalePpAnalysisOrgDTOMapper dao;
}
