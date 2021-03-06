package cn.htd.argus.controller;

import cn.htd.argus.bean.*;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.DateTimeUtil;
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

import java.util.ArrayList;
import java.util.List;


/**
 * 选品定价
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
     *  全页刷新
     * @param userId 公司Code
     * @param page 分页
     * @param rows 分页
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param xzSort 行业趋势 类型 0：销量  1：订单数  2：毛利率
     * @param prodSort 品牌品类排序 排序 0：品牌  1：品类
     * @param detailSort 商品销售排序 0:爆款  1：滞销款
     * @param listSort 列表类型 0：品牌  1：商品  2：爆款
     * @param dateType 查询的时间类型 0：月  1：年　2：季
     * @param prodName 商品名称
     * @param plCode 品类Code
     * @param ppCode 品牌Code
     * @return
     */
    @RequestMapping("/sale/all")
    public RestResult saleAll(@RequestParam(value = "userId", required = true) String userId,
                              @RequestParam(value = "page", required = false) Integer page,
                              @RequestParam(value = "rows", required = false) Integer rows,
                              @RequestParam(value = "startTime", required = false) String startTime,
                              @RequestParam(value = "endTime", required = false) String endTime,
                              @RequestParam(value = "xzSort", required = true) String xzSort,
                              @RequestParam(value = "prodSort", required = true) String prodSort,
                              @RequestParam(value = "detailSort", required = true) String detailSort,
                              @RequestParam(value = "listSort", required = true) String listSort,
                              @RequestParam(value = "dateType", required = true) String dateType,
                              @RequestParam(value = "prodName", required = false) String prodName,
                              @RequestParam(value = "plCode", required = false) String plCode,
                              @RequestParam(value = "ppCode", required = false) String ppCode) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctSaleOrgController.saleAll)首页页头估值获得入参，userId="+userId);
        try {
            SaleAllDTO dto = new SaleAllDTO();
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            //endTime = DateUtil.conversionDate(endTime);
            //startTime = DateUtil.conversionDate(startTime);
            if(startTime == null || endTime == null || startTime == "" || endTime == ""){
                if("2".equals(dateType)){
                    startTime = DateUtil.getCurrentQuarterStartTime();
                    endTime = DateUtil.getCurrentQuarterEndTime();
                }else{
                    endTime = DateUtil.getNowMonthWithOut01();
                    startTime = DateUtil.getNowMonthWithOut01();
                }
            }
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setEndTime(endTime);
            }
            if(StringUtils.isNotEmpty(userId)){
                searchDTO.setUserId(userId);
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


            //1.上部统计
            SaleCompareDTO saleCompareDTO = this.htyFctSaleOrgAllDTOService.selectCompareByOrgCode(userId, startTime, endTime);
            dto.setSaleCompareDTO(saleCompareDTO);


            //2.中部趋势图
            SaleXzListDTO saleXzListDTO = new SaleXzListDTO();
            List<SaleXzsDTO> saleXzDTOs = htyFctSaleOrgXzDTOService.selectByMonthDTO(userId, endTime, dateType);
            List<String> wholeBottomDate = new ArrayList<String>();
            List<String> wholeBottom = new ArrayList<String>();
            List<String> wholeBottomPair = new ArrayList<String>();
            if(saleXzDTOs != null){
                if("0".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getXsAmt().toString());
                        wholeBottomPair.add(i.getXsAmtXz().toString());
                    }
                }else if("1".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getCnt().toString());
                        wholeBottomPair.add(i.getCntXz().toString());
                    }
                }else if("2".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getRate().toString());
                        wholeBottomPair.add(i.getRateXz().toString());
                    }
                }
                saleXzListDTO.setXzBottom(wholeBottom);
                saleXzListDTO.setXzBottomDate(wholeBottomDate);
                saleXzListDTO.setXzBottomPair(wholeBottomPair);
            }
            dto.setSaleXzListDTO(saleXzListDTO);


            //3.下部列表页
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            if("0".equals(listSort)){
                //3.1品牌品类list
                SaleProdListDTO saleProdListDTO = new SaleProdListDTO();
                List<SaleProdDTO> list = htyFctSaleOrgProdDTOService.queryPage(userId, prodSort, startTime, endTime, pager);
                Long count = htyFctSaleOrgProdDTOService.queryPageSumCount(userId, startTime, endTime);
                saleProdListDTO.setSaleProdDTOList(list);
                saleProdListDTO.setSaleProdnum(count);
                dto.setSaleProdListDTO(saleProdListDTO);
            }else if("1".equals(listSort)){
                //3.2商品销售list
                if(StringUtils.isNotEmpty(detailSort)){
                    searchDTO.setXsAmt(detailSort);
                }
                SaleDetailListDTO saleDetailListDTO = new SaleDetailListDTO();
                List<SaleDetailDTO> list = htyFctSaleOrgDetailDTOService.queryPage(searchDTO, pager);
                searchDTO.setProdCode(null);
                Long count = htyFctSaleOrgDetailDTOService.queryPageSumCount(searchDTO);
                saleDetailListDTO.setDetainum(count);
                saleDetailListDTO.setSaleDetailDTOList(list);
                dto.setSaleDetailListDTO(saleDetailListDTO);
            }else if("2".equals(listSort)){
                //3.3爆款
                SaleHotListDTO saleHotListDTO = new SaleHotListDTO();
                List<SaleHotDTO> list = htyFctSaleXzHotDTOService.queryPage(searchDTO, pager);
                Long count = htyFctSaleXzHotDTOService.queryPageSumCount(searchDTO);
                saleHotListDTO.setSaleHostnum(count);
                saleHotListDTO.setSaleHotDTOList(list);
                dto.setSaleHotListDTO(saleHotListDTO);
            }

            result.setData(dto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取页头估值错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 行业销售趋势
     * @param userId
     * @param endTime
     * @param xzSort 类型0：销量 1：订单数 2：毛利率
     * @return
     */
    @RequestMapping("/sale/xz/list")
    public RestResult saleXzList(@RequestParam(value = "userId", required = true) String userId,
                                 @RequestParam(value = "endTime", required = false) String endTime,
                                 @RequestParam(value = "dateType", required = true) String dateType,
                                 @RequestParam(value = "xzSort", required = true) String xzSort) {
        logger.info("调用(HtyFctSaleOrgController.saleXzList)行业销售趋势入参，userId="+userId+",endTime="+endTime+",xzSort="+xzSort);
        RestResult result = new RestResult();
        try {
            if(endTime == null || endTime == "" ){
                if("2".equals(dateType)){
                    endTime = DateUtil.getCurrentQuarterEndTime();
                }else{
                    endTime = DateUtil.getNowMonthWithOut01();
                }
            }

            SaleXzListDTO dto = new SaleXzListDTO();
            List<SaleXzsDTO> saleXzDTOs = htyFctSaleOrgXzDTOService.selectByMonthDTO(userId, endTime, dateType);

            List<String> wholeBottomDate = new ArrayList<String>();
            List<String> wholeBottom = new ArrayList<String>();
            List<String> wholeBottomPair = new ArrayList<String>();
            if(saleXzDTOs != null){
                if("0".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getXsAmt().toString());
                        wholeBottomPair.add(i.getXsAmtXz().toString());
                    }
                }else if("1".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        wholeBottom.add(i.getCnt().toString());
                        wholeBottomPair.add(i.getCntXz().toString());
                    }
                }else if("2".equals(xzSort)){
                    for(SaleXzsDTO i:saleXzDTOs){
                        wholeBottomDate.add(i.getDateKey());
                        if(i.getRate() == null){
                            wholeBottom.add(null);
                        }else{
                            wholeBottom.add(i.getRate().toString());
                        }
                        if(i.getRateXz() == null){
                            wholeBottomPair.add(null);
                        }else{
                            wholeBottomPair.add(i.getRateXz().toString());
                        }
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
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
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
     * @param prodSort 排序0：品牌 1：品类
     * @return
     */
    @RequestMapping("/sale/prod/list")
    public RestResult saleProdList(@RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "page", required = false) Integer page,
                                   @RequestParam(value = "rows", required = false) Integer rows,
                                   @RequestParam(value = "startTime", required = false) String startTime,
                                   @RequestParam(value = "endTime", required = false) String endTime,
                                   @RequestParam(value = "prodSort", required = true) String prodSort) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)品牌品类销售分析入参，userId="+userId+",startTime="+startTime+",endTime="+endTime+",prodSort="+prodSort);
        RestResult result = new RestResult();
        try {
            if(startTime == null || endTime == null || startTime == "" || endTime == ""){
                endTime = DateTimeUtil.getTodayChar6();
                startTime = DateTimeUtil.getTodayChar6();
            }

            SaleProdListDTO saleProdListDTO = new SaleProdListDTO();
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            //startTime = DateUtil.conversionDate(startTime);
            //endTime = DateUtil.conversionDate(endTime);
            List<SaleProdDTO> list = htyFctSaleOrgProdDTOService.queryPage(userId, prodSort, startTime, endTime, pager);
            Long count = htyFctSaleOrgProdDTOService.queryPageSumCount(userId, startTime, endTime);
            saleProdListDTO.setSaleProdDTOList(list);
            saleProdListDTO.setSaleProdnum(count);

            result.setData(saleProdListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
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
     * @param detailSort 排序 0：爆款 1：滞款
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
                                     @RequestParam(value = "detailSort", required = true) String detailSort,
                                     @RequestParam(value = "prodName", required = false) String prodName,
                                     @RequestParam(value = "plCode", required = false) String plCode,
                                     @RequestParam(value = "ppCode", required = false) String ppCode) {
        logger.info("调用(HtyFctSaleOrgController.saleProdList)商品销售分析入参，userId="+userId+",startTime="+startTime+",endTime="+endTime+",detailSort="+detailSort);
        RestResult result = new RestResult();
        try {

            if(startTime == null || endTime == null || startTime == "" || endTime == ""){
                endTime = DateTimeUtil.getTodayChar6();
                startTime = DateTimeUtil.getTodayChar6();
            }

            SaleDetailListDTO saleDetailListDTO = new SaleDetailListDTO();
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            //startTime = DateUtil.conversionDate(startTime);
            //endTime = DateUtil.conversionDate(endTime);
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setEndTime(endTime);
            }
            if(StringUtils.isNotEmpty(userId)){
                searchDTO.setUserId(userId);
            }
            if(StringUtils.isNotEmpty(detailSort)){
                searchDTO.setXsAmt(detailSort);
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
            searchDTO.setProdCode(null);
            Long count = htyFctSaleOrgDetailDTOService.queryPageSumCount(searchDTO);
            saleDetailListDTO.setDetainum(count);
            saleDetailListDTO.setSaleDetailDTOList(list);

            result.setData(saleDetailListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
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
            if(startTime == null || endTime == null || startTime == "" || endTime == ""){
                endTime = DateTimeUtil.getTodayChar6();
                startTime = DateTimeUtil.getTodayChar6();
            }

            SaleHotListDTO saleHotListDTO = new SaleHotListDTO();
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();

            Pager pager = new Pager();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }

            //startTime = DateUtil.conversionDate(startTime);
            //endTime = DateUtil.conversionDate(endTime);
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
            Long count = htyFctSaleXzHotDTOService.queryPageSumCount(searchDTO);
            saleHotListDTO.setSaleHostnum(count);
            saleHotListDTO.setSaleHotDTOList(list);

            result.setData(saleHotListDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌品类销售分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 获取商品品类
     * @return
     */
    @RequestMapping("/sale/detail/query/brand")
    public RestResult saleDetailQueryBrand() {
        RestResult result = new RestResult();
        try {
            //1.销售商品品牌品类
            List<BrandSortDTO> detailCategory = this.htyFctSaleOrgDetailDTOService.queryBrand();

            result.setData(detailCategory);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取获取品牌品类错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 获取爆款品类
     * @return
     */
    @RequestMapping("/sale/hot/query/brand")
    public RestResult saleHotQueryBrand() {
        RestResult result = new RestResult();
        try {
            //2:销售爆款品牌品来
            List<BrandSortDTO> hotCategory = this.htyFctSaleXzHotDTOService.queryBrand();

            result.setData(hotCategory);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取获取品牌品类错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 获取品牌
     * @param ppCode
     * @param type 类型1：商品   2：爆款
     * @return
     */
    @RequestMapping("/sale/query/category")
    public RestResult saleQueryCategory(@RequestParam(value = "ppCode", required = true) String ppCode,
                                     @RequestParam(value = "type", required = true) String type) {
        RestResult result = new RestResult();
        try {
            List<BrandSortDTO> brandList = new ArrayList<BrandSortDTO>();
            if("1".equals(type)){
                brandList = this.htyFctSaleOrgDetailDTOService.queryCategoryByBrand(ppCode);
            }else if("2".equals(type)){
                brandList = this.htyFctSaleXzHotDTOService.queryCategoryByBrand(ppCode);
            }
            result.setData(brandList);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取品牌错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }
}
