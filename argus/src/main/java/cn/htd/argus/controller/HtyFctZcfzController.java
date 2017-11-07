package cn.htd.argus.controller;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleAllDTO;
import cn.htd.argus.dto.HtyFctL2DupontDTO;
import cn.htd.argus.service.HtyConfigZcfzSubjcodeDTOService;
import cn.htd.argus.service.HtyFctL1ZcfzSubjamtDTOService;
import cn.htd.argus.service.HtyFctL2DupontDTOService;
import cn.htd.argus.util.RestResult;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/dupont/all")
    public RestResult dupontAll(@RequestParam(value = "userId", required = true) String userId,
                              @RequestParam(value = "endTime", required = false) String endTime) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctZcfzController.dupontAll)首页页头估值获得入参，userId=" + userId);
        HtyFctL2DupontDTO htyFctL2DupontDTO = this.htyFctL2DupontDTOService.select(userId,endTime);
        System.out.println(htyFctL2DupontDTO);
        return null;
    }
}
