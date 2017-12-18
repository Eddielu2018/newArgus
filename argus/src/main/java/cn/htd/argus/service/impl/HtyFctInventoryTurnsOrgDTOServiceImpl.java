package cn.htd.argus.service.impl;

import cn.htd.argus.mappers.HtyFctInventoryTurnsOrgDTOMapper;
import cn.htd.argus.service.HtyFctInventoryTurnsOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctInventoryTurnsOrgDTOServiceImpl implements HtyFctInventoryTurnsOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctInventoryTurnsOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctInventoryTurnsOrgDTOMapper dao;
}
