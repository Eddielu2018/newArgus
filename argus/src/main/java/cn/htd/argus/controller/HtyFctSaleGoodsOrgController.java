package cn.htd.argus.controller;

import cn.htd.argus.bean.*;
import cn.htd.argus.dto.*;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.DateTimeUtil;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.RestResult;
import cn.htd.common.Pager;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

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
    @RequestMapping("/goods/all/head")
    public RestResult goodsAllHead(@RequestParam(value = "userId", required = true) String userId,
                                   @RequestParam(value = "endTime", required = false) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsAllHead)商品销售分析入参,userId="+userId+",endTime="+endTime);
        RestResult result = new RestResult();
        try {
            if(StringUtils.isEmpty(endTime)){
                endTime = DateUtil.getNextDay(new Date());
            }
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
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
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
    @RequestMapping("/goods/all/bottom")
    public RestResult goodsAllBottom(@RequestParam(value = "userId", required = true) String userId,
                                     @RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "rows", required = false) Integer rows,
                                     @RequestParam(value = "endTime", required = false) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsAllBottom)商品销售分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows);
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            GoodsAllBottomDTO dto = new GoodsAllBottomDTO();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            if(StringUtils.isEmpty(endTime)){
                endTime = DateUtil.getNextDay(new Date());
            }else{
                endTime = DateTimeUtil.getTodayMonth();
            }
            Integer num = htyFctProdDetailOrgDTOService.queryAllBottomCount(userId, endTime);
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
                                            @RequestParam(value = "endTime", required = false) String endTime,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "rows", required = false) Integer rows,
                                            @RequestParam(value = "range", required = true) String range) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsInventoryWarning)库存预警分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows+",range="+range);
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            GoodsWarningDTO dto = new GoodsWarningDTO();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            if(endTime == null || endTime == ""){
                endTime = DateUtil.getCurDateStr1("yyyyMM");
            }
            Integer num = htyFctInventoryWarnsDTOService.queryInventoryWarnsCount(userId, endTime, range);
            if(num != null && num >0){
                List<HtyFctInventoryWarnsDTO> list = htyFctInventoryWarnsDTOService.queryInventoryWarns(userId, endTime, pager, range);
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

    /**
     * 商品库存滞销分析
     * @param userId
     * @param endTime
     * @param page
     * @param rows
     * @param range 0：30天内   1：60天内   2：90天内   3：180天内   4：超过180天
     * @return
     */
    @RequestMapping("/goods/inventory/turns")
    public RestResult goodsInventoryTurns(@RequestParam(value = "userId", required = true) String userId,
                                            @RequestParam(value = "endTime", required = false) String endTime,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "rows", required = false) Integer rows,
                                            @RequestParam(value = "range", required = true) String range) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsInventoryTurns)商品销售分析入参,userId="+userId+",endTime="+endTime+",page="+page+",rows="+rows+",range="+range);
        RestResult result = new RestResult();
        try {
            Pager pager = new Pager();
            GoodsTurnsDTO dto = new GoodsTurnsDTO();
            if(page != null && rows != null){
                pager.setRows(rows);
                pager.setPage(page);
            }
            if(endTime == null || endTime == ""){
                endTime = DateUtil.getCurDateStr1("yyyyMM");
            }
            Integer num = htyFctInventoryTurnsOrgDTOService.queryInventoryTurnsCount(userId, endTime, range);
            if(num != null && num >0){
                List<HtyFctInventoryTurnsOrgDTO> list = htyFctInventoryTurnsOrgDTOService.queryInventoryTurns(userId, endTime, pager, range);
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
            logger.error("商品库存滞销分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * TOP5品类品类销售情况
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/goods/sale/pl")
    public RestResult goodsSalePl(@RequestParam(value = "userId", required = true) String userId,
                                  @RequestParam(value = "endTime", required = false) String endTime) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsSalePl)TOP5品类销售情况入参,userId="+userId+",endTime="+endTime);
        RestResult result = new RestResult();
        try {
            GoodsSalePlDTO restDto = new GoodsSalePlDTO();
            List<Map<String,String>> wholePl = new ArrayList<Map<String,String>>();
            List<Map<String,String>> wholePp = new ArrayList<Map<String,String>>();
            BigDecimal amtAllPl = null;
            BigDecimal amtAllPp = null;
            if(StringUtils.isEmpty(endTime)){
                endTime = DateUtil.getNextDay(new Date());
            }
            //1.品类
            List<HtyFctSalePlAnalysisOrgDTO> restList = htyFctSalePlAnalysisOrgDTOService.querySalePlAnalysisOrg(userId,endTime,"","");
            //判断是否有其他项
            if(CollectionUtils.isNotEmpty(restList)){
                if(restList.size() >5){
                    HtyFctSalePlAnalysisOrgDTO dto = null;
                    List<HtyFctSalePlAnalysisOrgDTO> list = new ArrayList<HtyFctSalePlAnalysisOrgDTO>();
                    List<List<HtyFctSalePlAnalysisOrgDTO>> lists = getSplitList(restList);
                    for(HtyFctSalePlAnalysisOrgDTO i:lists.get(1)){
                        if(dto == null){
                            dto = i ;
                        }else{
                            dto.setSaleQvt(ArithUtil.add(dto.getSaleQvt().doubleValue(),i.getSaleQvt().doubleValue()));
                            dto.setSaleAmtYear(ArithUtil.add(dto.getSaleAmtYear().doubleValue(),i.getSaleAmtYear().doubleValue()));
                            dto.setSaleAvg(ArithUtil.add(dto.getSaleAvg().doubleValue(),i.getSaleAvg().doubleValue()));
                        }
                    }
                    dto.setPlNameLv3("其他");
                    list = lists.get(0);
                    list.add(dto);
                    for(HtyFctSalePlAnalysisOrgDTO j:list){
                        j.setSaleAmtYear(ArithUtil.div(j.getSaleAmtYear().doubleValue(), new BigDecimal(10000).doubleValue(),2));
                        Map<String,String> map1 = new HashMap<String,String>();
                        map1.put("name", j.getPlNameLv3());
                        map1.put("value", String.valueOf(j.getSaleAmtYear()));
                        wholePl.add(map1);
                    }
                    restDto.setPlList(list);
                    restDto.setWholePl(wholePl);
                }else{
                    for(HtyFctSalePlAnalysisOrgDTO j:restList){
                        j.setSaleAmtYear(ArithUtil.div(j.getSaleAmtYear().doubleValue(), new BigDecimal(10000).doubleValue(),2));
                        Map<String,String> map1 = new HashMap<String,String>();
                        map1.put("name", j.getPlNameLv3());
                        map1.put("value", String.valueOf(j.getSaleAmtYear()));
                        wholePl.add(map1);
                    }
                    restDto.setPlList(restList);
                    restDto.setWholePl(wholePl);
                }
                amtAllPl = ArithUtil.div(restList.get(0).getSaleAmtAll().doubleValue(),new BigDecimal(10000).doubleValue(),2);
            }
            restDto.setAmtAllPl(amtAllPl);
            //2.品牌
            List<HtyFctSalePpAnalysisOrgDTO> restListPp = htyFctSalePpAnalysisOrgDTOService.querySalePpAnalysisOrg(userId, endTime, "", "");
            //判断是否有其他项
            if(CollectionUtils.isNotEmpty(restListPp)){
                if(restListPp.size() >5){
                    HtyFctSalePpAnalysisOrgDTO dto = null;
                    List<HtyFctSalePpAnalysisOrgDTO> list = new ArrayList<HtyFctSalePpAnalysisOrgDTO>();
                    List<List<HtyFctSalePpAnalysisOrgDTO>> lists = getSplitList(restListPp);
                    for(HtyFctSalePpAnalysisOrgDTO i:lists.get(1)){
                        if(dto == null){
                            dto = i ;
                        }else{
                            dto.setSaleQvt(ArithUtil.add(dto.getSaleQvt().doubleValue(),i.getSaleQvt().doubleValue()));
                            dto.setSaleAmtYear(ArithUtil.add(dto.getSaleAmtYear().doubleValue(),i.getSaleAmtYear().doubleValue()));
                            dto.setSaleAvg(ArithUtil.add(dto.getSaleAvg().doubleValue(),i.getSaleAvg().doubleValue()));
                        }
                    }
                    dto.setPpName("其他");
                    list = lists.get(0);
                    list.add(dto);
                    for(HtyFctSalePpAnalysisOrgDTO j:list){
                        j.setSaleAmtYear(ArithUtil.div(j.getSaleAmtYear().doubleValue(), new BigDecimal(10000).doubleValue(),2));
                        Map<String,String> map1 = new HashMap<String,String>();
                        map1.put("name", j.getPpName());
                        map1.put("value", String.valueOf(j.getSaleAmtYear()));
                        wholePp.add(map1);
                    }
                    restDto.setPpList(list);
                    restDto.setWholePp(wholePp);
                }else{
                    for(HtyFctSalePpAnalysisOrgDTO j:restListPp){
                        j.setSaleAmtYear(ArithUtil.div(j.getSaleAmtYear().doubleValue(), new BigDecimal(10000).doubleValue(),2));
                        Map<String,String> map1 = new HashMap<String,String>();
                        map1.put("name", j.getPpName());
                        map1.put("value", String.valueOf(j.getSaleAmtYear()));
                        wholePp.add(map1);
                    }
                    restDto.setPpList(restListPp);
                    restDto.setWholePp(wholePp);
                }
                amtAllPp = ArithUtil.div(restListPp.get(0).getSaleAmtAll().doubleValue(),new BigDecimal(10000).doubleValue(),2);
            }
            restDto.setAmtAllPp(amtAllPp);
            result.setData(restDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());

        } catch (Exception e) {
            logger.error("TOP5品类销售情况" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 品类销售趋势分析
     * @param userId
     * @param endTime
     * @param plCode
     * @return
     */
    @RequestMapping("/goods/sale/pl/ratio")
    public RestResult goodsSalePlRatio(@RequestParam(value = "userId", required = true) String userId,
                                       @RequestParam(value = "endTime", required = false) String endTime,
                                       @RequestParam(value = "plCode", required = true) String plCode) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsSalePlRatio)品类销售趋势分析入参,userId="+userId+",endTime="+endTime);
        RestResult result = new RestResult();
        try {
            if(endTime == null || endTime == ""){
                endTime = DateUtil.getCurDateStr1("yyyy"); //结束年份 2017
            }
            String startTime = DateUtil.dateFormatYear(endTime, 1); //开始年份 2016

            List<String> plDate = new ArrayList<String>();
            List<String> plEnd = new ArrayList<String>();
            List<String> plStart = new ArrayList<String>();
            SalePlGoosDTO dto = new SalePlGoosDTO();
            List<HtyFctSalePlAnalysisOrgDTO> list = setList(); //拟定12个月数据
            List<HtyFctSalePlAnalysisOrgDTO> endList = htyFctSalePlAnalysisOrgDTOService.querySalePlAnalysisOrg(userId,endTime,"1",plCode);
            List<HtyFctSalePlAnalysisOrgDTO> startList = htyFctSalePlAnalysisOrgDTOService.querySalePlAnalysisOrg(userId,startTime,"1",plCode);
            if(CollectionUtils.isNotEmpty(startList)){
                for(HtyFctSalePlAnalysisOrgDTO j:list){
                    for(HtyFctSalePlAnalysisOrgDTO i:startList){
                        if(j.getStatDay().equals(i.getStatDay().substring(4,6))){
                            j.setSaleAmtMon(i.getSaleAmtMon());
                        }
                    }
                }
            }
            if(CollectionUtils.isNotEmpty(endList)){
                for(HtyFctSalePlAnalysisOrgDTO j:list){
                    for(HtyFctSalePlAnalysisOrgDTO i:endList){
                        if(j.getStatDay().equals(i.getStatDay().substring(4,6))){
                            j.setSaleAmtYear(i.getSaleAmtMon());
                        }
                    }
                }

            }
            for(HtyFctSalePlAnalysisOrgDTO j:list){
                plDate.add(j.getStatDay());
                plEnd.add(j.getSaleAmtYear().toString());
                plStart.add(j.getSaleAmtMon().toString());
            }
            dto.setPlDate(plDate);
            dto.setPlEnd(plEnd);
            dto.setPlStart(plStart);
            result.setData(dto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());

        } catch (Exception e) {
            logger.error("品类销售趋势分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 品牌销售趋势分析
     * @param userId
     * @param endTime
     * @param ppCode
     * @return
     */
    @RequestMapping("/goods/sale/pp/ratio")
    public RestResult goodsSalePpRatio(@RequestParam(value = "userId", required = true) String userId,
                                       @RequestParam(value = "endTime", required = false) String endTime,
                                       @RequestParam(value = "ppCode", required = true) String ppCode) {
        logger.info("调用(HtyFctSaleGoodsOrgController.goodsSalePlRatio)品类销售趋势分析入参,userId="+userId+",endTime="+endTime+"ppCode="+ppCode);
        RestResult result = new RestResult();
        try {
            if(endTime == null || endTime == ""){
                endTime = DateUtil.getCurDateStr1("yyyy"); //结束年份 2017
            }
            String startTime = DateUtil.dateFormatYear(endTime, 1); //开始年份 2016

            List<String> plDate = new ArrayList<String>();
            List<String> plEnd = new ArrayList<String>();
            List<String> plStart = new ArrayList<String>();
            SalePlGoosDTO dto = new SalePlGoosDTO();
            List<HtyFctSalePlAnalysisOrgDTO> list = setList(); //拟定12个月数据
            List<HtyFctSalePpAnalysisOrgDTO> endList = htyFctSalePpAnalysisOrgDTOService.querySalePpAnalysisOrg(userId, endTime, "1", ppCode);
            List<HtyFctSalePpAnalysisOrgDTO> startList = htyFctSalePpAnalysisOrgDTOService.querySalePpAnalysisOrg(userId, startTime, "1", ppCode);
            if(CollectionUtils.isNotEmpty(startList)){
                for(HtyFctSalePlAnalysisOrgDTO j:list){
                    for(HtyFctSalePpAnalysisOrgDTO i:startList){
                        if(j.getStatDay().equals(i.getStatDay().substring(4,6))){
                            j.setSaleAmtMon(i.getSaleAmtMon());
                        }
                    }
                }
            }
            if(CollectionUtils.isNotEmpty(endList)){
                for(HtyFctSalePlAnalysisOrgDTO j:list){
                    for(HtyFctSalePpAnalysisOrgDTO i:endList){
                        if(j.getStatDay().equals(i.getStatDay().substring(4,6))){
                            j.setSaleAmtYear(i.getSaleAmtMon());
                        }
                    }
                }

            }
            for(HtyFctSalePlAnalysisOrgDTO j:list){
                plDate.add(j.getStatDay());
                plEnd.add(j.getSaleAmtYear().toString());
                plStart.add(j.getSaleAmtMon().toString());
            }
            dto.setPlDate(plDate);
            dto.setPlEnd(plEnd);
            dto.setPlStart(plStart);
            result.setData(dto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());

        } catch (Exception e) {
            logger.error("品类销售趋势分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * @param list 要拆分的集合
     * @return
     */
    public static <T> List<List<T>> getSplitList(List<T> list)
    {
        List<List<T>> returnList = new ArrayList<List<T>>();
        int size = list.size();
        returnList.add(list.subList(0, 5));
        returnList.add(list.subList(5, size));
        return returnList;
    }

    private List<HtyFctSalePlAnalysisOrgDTO> setList(){
        List<HtyFctSalePlAnalysisOrgDTO> list = new ArrayList<HtyFctSalePlAnalysisOrgDTO>();
        BigDecimal zero = new BigDecimal(0);
        for(int i= 0 ; i<12 ;i++){
            HtyFctSalePlAnalysisOrgDTO dto = new HtyFctSalePlAnalysisOrgDTO();
            dto.setStatDay(String.format("%02d", i + 1));
            //开始时间
            dto.setSaleAmtMon(zero);
            //结束时间
            dto.setSaleAmtYear(zero);
            list.add(dto);
        }
        return list;
    }
}
