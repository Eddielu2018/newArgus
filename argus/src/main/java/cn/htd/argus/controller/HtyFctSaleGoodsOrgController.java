package cn.htd.argus.controller;

import cn.htd.argus.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品数据分析
 * Created by wangtp on 2017/12/18.
 */
@RestController
@RequestMapping("/htyfctgoods")
public class HtyFctSaleGoodsOrgController {
    Logger logger = LoggerFactory.getLogger(HtyFctSaleGoodsOrgController.class);

    @Autowired
    private HtyFctInventoryTurnsOrgDTOService htyFctInventoryTurnsOrgDTOService;
    @Autowired
    private HtyFctProdAllOrgDTOService htyFctProdAllOrgDTOService;
    @Autowired
    private HtyFctSalePlAnalysisOrgDTOService htyFctSalePlAnalysisOrgDTOService;
    @Autowired
    private HtyFctSalePpAnalysisOrgDTOService htyFctSalePpAnalysisOrgDTOService;
}
