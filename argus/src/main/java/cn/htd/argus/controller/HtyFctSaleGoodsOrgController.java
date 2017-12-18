package cn.htd.argus.controller;

import cn.htd.argus.bean.GoodsAllHeadDTO;
import cn.htd.argus.dto.HtyFctProdAllOrgDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 商品数据分析头部
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/goods/All/head")
    public RestResult goodsAllHead(@RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "endTime", required = true) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsAllHead)商品销售分析入参,userId="+userId+",endTime="+endTime);
        RestResult result = new RestResult();
        try {
            GoodsAllHeadDTO dto = new GoodsAllHeadDTO();
            HtyFctProdAllOrgDTO htyFctProdAllOrgDTO = htyFctProdAllOrgDTOService.queryAllHead(userId,endTime);
            if(htyFctProdAllOrgDTO != null){
                dto.setProdNum(htyFctProdAllOrgDTO.getProdNum());
                dto.setProdNumWk(htyFctProdAllOrgDTO.getProdNumWk());
                dto.setProdNumBx(htyFctProdAllOrgDTO.getProdNumBx());
                dto.setProdNumBxWk(htyFctProdAllOrgDTO.getProdNumBxWk());
                dto.setProdNumDown(htyFctProdAllOrgDTO.getProdNumDown());
                dto.setProdNumDownWk(htyFctProdAllOrgDTO.getProdNumDownWk());
                dto.setProdNumQy(htyFctProdAllOrgDTO.getProdNumQy());
                dto.setProdNumQyWk(htyFctProdAllOrgDTO.getProdNumQyWk());
                dto.setProdNumSale(htyFctProdAllOrgDTO.getProdNumSale());
                dto.setProdNumSaleWk(htyFctProdAllOrgDTO.getProdNumSaleWk());
                result.setData(dto);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.ERROR_IS_NOT_MENBER.getCode());
                result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
            }
        } catch (Exception e) {
            logger.error("获取页头估值错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    @RequestMapping("/goods/All/bottom")
    public RestResult goodsAllBottom(@RequestParam(value = "userId", required = true) String userId,
                                     @RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "rows", required = false) Integer rows,
                                     @RequestParam(value = "endTime", required = false) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsAllBottom)商品销售分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows);
        RestResult result = new RestResult();
        return result;
    }
}
