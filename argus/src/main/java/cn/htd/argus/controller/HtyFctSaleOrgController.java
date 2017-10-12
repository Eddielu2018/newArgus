package cn.htd.argus.controller;

import cn.htd.argus.bean.*;
import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.RestResult;
import cn.htd.common.Pager;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangtp on 2017/10/10.
 */
@RestController
@RequestMapping("/htyfctsaleorg")
public class HtyFctSaleOrgController {
    Logger logger = LoggerFactory.getLogger(HtyFctSaleOrgController.class);

    @Autowired
    private HtyFctSaleOrgAllDTOService htyFctSaleOrgAllDTOService;
    @Autowired
    private HtyFctSaleOrgDetailDTOService htyFctSaleOrgDetailDTOService;
    @Autowired
    private HtyFctSaleOrgProdDTOService htyFctSaleOrgProdDTOService;
    @Autowired
    private HtyFctSaleOrgXzDTOService htyFctSaleOrgXzDTOService;
    @Autowired
    private HtyFctSaleXzHotDTOService htyFctSaleXzHotDTOService;

    /**
     * 首页页头估值
     * @param userId
     * @return
     */
    @RequestMapping("/sale/all")
    public RestResult saleAll(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctSaleOrgController.indexForHandle)首页页头估值获得入参，userId="+userId);
        try {
            HtyFctSaleOrgAllDTO htyFctSaleOrgAllDTO = this.htyFctSaleOrgAllDTOService.selectByOrgCode(userId);
            if(htyFctSaleOrgAllDTO != null){
                htyFctSaleOrgAllDTO.setXsAmt(ArithUtil.div(htyFctSaleOrgAllDTO.getXsAmt().doubleValue(),10000,0));
                htyFctSaleOrgAllDTO.setXsLr(ArithUtil.div(htyFctSaleOrgAllDTO.getXsLr().doubleValue(),10000,0));
                result.setData(htyFctSaleOrgAllDTO);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("获取页头估值错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 行业销售趋势
     * @param userId
     * @param startTime
     * @param endTime
     * @param sort
     * @return
     */
    @RequestMapping("/sale/xz/list")
    public RestResult saleXzList(@RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "startTime", required = false) String startTime,
                                   @RequestParam(value = "endTime", required = false) String endTime,
                                   @RequestParam(value = "sort", required = true) String sort) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)品牌品类销售分析入参，userId="+userId+",startTime="+startTime+",endTime="+endTime+",sort="+sort);
        RestResult result = new RestResult();
        try {
            SaleXzListDTO dto = new SaleXzListDTO();

            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            endTime = DateUtil.conversionDate(endTime);
            if(StringUtils.isNotEmpty(userId)){
                searchDTO.setUserId(userId);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setEndTime(endTime);
            }
            List<SaleXzsDTO> saleXzDTOs = htyFctSaleOrgXzDTOService.selectBySearchDTO(searchDTO);

            List<String> wholeBottomDate = new ArrayList<String>();
            List<String> wholeBottom = new ArrayList<String>();
            List<String> wholeBottomPair = new ArrayList<String>();
            if(saleXzDTOs != null){
                if("1".equals(sort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getXsAmt().toString());
                        wholeBottomPair.add(i.getXsAmtXz().toString());
                    }
                }else if("2".equals(sort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getCnt().toString());
                        wholeBottomPair.add(i.getCntXz().toString());
                    }
                }else if("3".equals(sort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getRate().toString());
                        wholeBottomPair.add(i.getRateXz().toString());
                    }
                }
                dto.setXzBottom(wholeBottom);
                dto.setXzBottomDate(wholeBottomDate);
                dto.setXzBottomPair(wholeBottomPair);
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
                return result;
            }
            result.setData(dto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }


    /**
     * 品牌品类销售分析
     * @param userId
     * @param page
     * @param rows
     * @param startTime
     * @param endTime
     * @param sort 排序0：品牌 1：品类
     * @return
     */
    @RequestMapping("/sale/prod/list")
    public RestResult saleProdList(@RequestParam(value = "userId", required = true) String userId,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "rows", required = false) Integer rows,
                                 @RequestParam(value = "startTime", required = false) String startTime,
                                 @RequestParam(value = "endTime", required = false) String endTime,
                                 @RequestParam(value = "sort", required = true) String sort) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)品牌品类销售分析入参，userId="+userId+",startTime="+startTime+",endTime="+endTime+",sort="+sort);
        RestResult result = new RestResult();
        try {
            SaleProdListDTO saleProdListDTO = new SaleProdListDTO();
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            startTime = DateUtil.conversionDate(startTime);
            endTime = DateUtil.conversionDate(endTime);
            List<SaleProdDTO> list = htyFctSaleOrgProdDTOService.queryPage(userId, sort, startTime, endTime, pager);
            Long count = htyFctSaleOrgProdDTOService.queryPageCount(userId, startTime, endTime);
            saleProdListDTO.setSaleProdDTOList(list);
            saleProdListDTO.setSaleProdnum(count);

            result.setData(saleProdListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 商品销售分析
     * @param userId
     * @param page
     * @param rows
     * @param startTime
     * @param endTime
     * @param sort 0：爆款 1：滞款
     * @param prodName
     * @param plCode
     * @param ppCode
     * @return
     */
    @RequestMapping("/sale/detail/list")
    public RestResult saleDetailList(@RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "page", required = false) Integer page,
                                   @RequestParam(value = "rows", required = false) Integer rows,
                                   @RequestParam(value = "startTime", required = false) String startTime,
                                   @RequestParam(value = "endTime", required = false) String endTime,
                                   @RequestParam(value = "sort", required = true) String sort,
                                   @RequestParam(value = "prodName", required = false) String prodName,
                                   @RequestParam(value = "plCode", required = false) String plCode,
                                   @RequestParam(value = "ppCode", required = false) String ppCode) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)商品销售分析入参，userId="+userId+",startTime="+startTime+",endTime="+endTime+",sort="+sort);
        RestResult result = new RestResult();
        try {
            SaleDetailListDTO saleDetailListDTO = new SaleDetailListDTO();
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            startTime = DateUtil.conversionDate(startTime);
            endTime = DateUtil.conversionDate(endTime);
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setEndTime(endTime);
            }
            if(StringUtils.isNotEmpty(userId)){
                searchDTO.setUserId(userId);
            }
            if(StringUtils.isNotEmpty(sort)){
                searchDTO.setXsAmt(sort);
            }
            if(StringUtils.isNotEmpty(prodName)){
                searchDTO.setProdName(prodName);
            }
            if(StringUtils.isNotEmpty(plCode)){
                searchDTO.setPlCode(plCode);
            }
            if(StringUtils.isNotEmpty(ppCode)){
                searchDTO.setPpCode(ppCode);
            }
            List<SaleDetailDTO> list = htyFctSaleOrgDetailDTOService.queryPage(searchDTO, pager);
            Long count = htyFctSaleOrgDetailDTOService.queryPageCount(searchDTO);
            saleDetailListDTO.setDetainum(count);
            saleDetailListDTO.setSaleDetailDTOList(list);

            result.setData(saleDetailListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 爆款销售分析
     * @param page
     * @param rows
     * @param startTime
     * @param endTime
     * @param plCode
     * @param ppCode
     * @return
     */
    @RequestMapping("/sale/hot/list")
    public RestResult salehotList(@RequestParam(value = "page", required = false) Integer page,
                                   @RequestParam(value = "rows", required = false) Integer rows,
                                   @RequestParam(value = "startTime", required = false) String startTime,
                                   @RequestParam(value = "endTime", required = false) String endTime,
                                   @RequestParam(value = "plCode", required = false) String plCode,
                                   @RequestParam(value = "ppCode", required = false) String ppCode) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)爆款销售分析入参，plCode="+plCode+",startTime="+startTime+",endTime="+endTime+",ppCode="+ppCode);
        RestResult result = new RestResult();
        try {
            SaleHotListDTO saleHotListDTO = new SaleHotListDTO();
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();

            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }

            startTime = DateUtil.conversionDate(startTime);
            endTime = DateUtil.conversionDate(endTime);
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setEndTime(endTime);
            }
            if(StringUtils.isNotEmpty(plCode)){
                searchDTO.setPlCode(plCode);
            }
            if(StringUtils.isNotEmpty(ppCode)){
                searchDTO.setPpCode(ppCode);
            }
            List<SaleHotDTO> list = htyFctSaleXzHotDTOService.queryPage(searchDTO, pager);
            Long count = htyFctSaleXzHotDTOService.queryPageCount(searchDTO);
            saleHotListDTO.setSaleHostnum(count);
            saleHotListDTO.setSaleHotDTOList(list);

            result.setData(saleHotListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 销售分析
     * @param userId 公司id
     * @param page
     * @param rows
     * @param prodName 商品名称
     * @param startTime
     * @param endTime
     * @param plCode 品类
     * @param ppCode 品牌
     * @param xsAmt 销售金额（null:默认，0：顺序，1：倒序）
     * @param family 查询类型(1：品牌品类 2：在售商铺 3：爆款)
     * @return
     */
    @RequestMapping("/sale/detail")
    public RestResult saleDetail(@RequestParam(value = "userId", required = true) String userId,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "rows", required = false) Integer rows,
                                 @RequestParam(value = "prodName", required = true) String prodName,
                                 @RequestParam(value = "startTime", required = true) String startTime,
                                 @RequestParam(value = "endTime", required = true) String endTime,
                                 @RequestParam(value = "plCode", required = true) String plCode,
                                 @RequestParam(value = "ppCode", required = true) String ppCode,
                                 @RequestParam(value = "xsAmt", required = true) String xsAmt,
                                 @RequestParam(value = "family", required = true) String family) {
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(StringUtils.isNotEmpty(userId)){
                searchDTO.setUserId(userId);
            }
            if(StringUtils.isNotEmpty(prodName)){
                searchDTO.setProdName(prodName);
            }
            if(StringUtils.isNotEmpty(plCode)){
                searchDTO.setProdName(plCode);
            }
            if(StringUtils.isNotEmpty(ppCode)){
                searchDTO.setProdName(ppCode);
            }
            if(StringUtils.isNotEmpty(xsAmt)){
                searchDTO.setProdName(xsAmt);
            }

            if(family =="1"){

            }else if(family == "2"){

            }else if(family == "3"){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
