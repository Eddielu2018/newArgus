package cn.htd.argus.controller;

import cn.htd.argus.bean.GoodsAllBottomDTO;
import cn.htd.argus.bean.GoodsAllHeadDTO;
import cn.htd.argus.bean.GoodsWarningDTO;
import cn.htd.argus.dto.HtyFctInventoryWarnsDTO;
import cn.htd.argus.dto.HtyFctProdAllOrgDTO;
import cn.htd.argus.dto.HtyFctProdDetailOrgDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.RestResult;
import cn.htd.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private HtyFctInventoryWarnsDTOService htyFctInventoryWarnsDTOService;
    @Autowired
    private HtyFctProdAllOrgDTOService htyFctProdAllOrgDTOService;
    @Autowired
    private HtyFctProdDetailOrgDTOService htyFctProdDetailOrgDTOService;
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
            logger.error("商品数据分析头部" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 商品数据分析底部
     * @param userId
     * @param page
     * @param rows
     * @param endTime
     * @return
     */
    @RequestMapping("/goods/All/bottom")
    public RestResult goodsAllBottom(@RequestParam(value = "userId", required = true) String userId,
                                     @RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "rows", required = false) Integer rows,
                                     @RequestParam(value = "endTime", required = true) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsAllBottom)商品销售分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows);
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            GoodsAllBottomDTO dto = new GoodsAllBottomDTO();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            Integer num = htyFctProdDetailOrgDTOService.queryAllBottomCount(userId,endTime);
            if(num != null && num >0){
                List<HtyFctProdDetailOrgDTO> list = htyFctProdDetailOrgDTOService.queryAllBottom(userId,endTime,pager);
                if(list != null && list.size() >0 ){
                    dto.setNum(num);
                    dto.setList(list);
                    result.setData(dto);
                    result.setCode(ResultCodeEnum.SUCCESS.getCode());
                    result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
                }else{
                    result.setCode(ResultCodeEnum.ERROR_IS_NOT_MENBER.getCode());
                    result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
                }
            }else{
                dto.setNum(num);
                result.setData(dto);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }
        } catch (Exception e) {
            logger.error("商品数据分析底部" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 库存预警分析
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/goods/inventory/warning")
    public RestResult goodsInventoryWarning(@RequestParam(value = "userId", required = true) String userId,
                                            @RequestParam(value = "endTime", required = true) String endTime,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "rows", required = false) Integer rows,
                                            @RequestParam(value = "range", required = true) String range) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsInventoryWarning)商品销售分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows+",range="+range);
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            GoodsWarningDTO dto = new GoodsWarningDTO();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            Integer num = htyFctInventoryWarnsDTOService.queryInventoryWarnsCount(userId,endTime,range);
            if(num != null && num >0){
                List<HtyFctInventoryWarnsDTO> list = htyFctInventoryWarnsDTOService.queryInventoryWarns(userId,endTime,pager,range);
                if(list != null && list.size() >0 ){
                    dto.setNum(num);
                    dto.setList(list);
                    result.setData(dto);
                    result.setCode(ResultCodeEnum.SUCCESS.getCode());
                    result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
                }else{
                    result.setCode(ResultCodeEnum.ERROR_IS_NOT_MENBER.getCode());
                    result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
                }
            }else{
                dto.setNum(num);
                result.setData(dto);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }
        } catch (Exception e) {
            logger.error("库存预警分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }
}
