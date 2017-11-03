package cn.htd.argus.controller;

import cn.htd.argus.service.HtyConfigZcfzSubjcodeDTOService;
import cn.htd.argus.service.HtyFctL1ZcfzSubjamtDTOService;
import cn.htd.argus.service.HtyFctL2DupontDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 财务效率
 * Created by wangtp on 2017/10/31.
 */
@RestController
@RequestMapping("/htyfctzcfz")
public class HtyFctZcfzController {
    Logger logger = LoggerFactory.getLogger(HtyFctZcfzController.class);

    @Autowired
    private HtyConfigZcfzSubjcodeDTOService htyConfigZcfzSubjcodeDTOService;
    @Autowired
    private HtyFctL1ZcfzSubjamtDTOService htyFctL1ZcfzSubjamtDTOService;
    @Autowired
    private HtyFctL2DupontDTOService htyFctL2DupontDTOService;
}
