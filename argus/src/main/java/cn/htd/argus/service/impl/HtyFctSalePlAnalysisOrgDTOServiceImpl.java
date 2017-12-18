package cn.htd.argus.service.impl;

import cn.htd.argus.mappers.HtyFctSalePlAnalysisOrgDTOMapper;
import cn.htd.argus.service.HtyFctSalePlAnalysisOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctSalePlAnalysisOrgDTOServiceImpl implements HtyFctSalePlAnalysisOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctSalePlAnalysisOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctSalePlAnalysisOrgDTOMapper dao;
}
