package cn.htd.argus.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.htd.argus.dto.*;
import cn.htd.argus.service.*;
import cn.htd.argus.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.utils.StringUtils;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.bean.UserBeHaviorSearchDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.RestResult;

/**
 * 用户行为
 * Created by suntao on 2017/10/16.
 */
@RestController
@RequestMapping("/userBehavior")
public class HtyFctUserBeHaviorController {
    // 日志
    Logger logger = LoggerFactory.getLogger(HtyFctUserBeHaviorController.class);
    // 落地页面的访问数量
    @Autowired
    private HtyFctXwB2bLndPageDTOService htyFctXwB2bLndPageDTOService;
    // 搜索量
    @Autowired
    private HtyFctXwB2bSearchKeyDTOService htyFctXwB2bSearchKeyDTOService;
    // 单品的访问量
    @Autowired
    private HtyFctXwB2bItemAccessDTOService htyFctXwB2bItemAccessDTOService;
    // 单品销售数量
    @Autowired
    private HtyFctSaleCityProdDTOService htyFctSaleCityProdDTOService;
    // 漏斗转化及复购
    @Autowired
    private HtyFctXwB2bConvFunnelDTOService htyFctXwB2bConvFunnelDTOService;
    @Autowired
    private HtyFctCustAllDTOService htyFctCustAllDTOService;
    /**
     * 用户行为
     *
     * @param
     * @return
     */
    @RequestMapping("/behavior/whole")
    public RestResult HtyFctUserBeHavior(
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "radio", required = false) String radio,
            @RequestParam(value = "userId",required = true)String userId
    ) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctUserBeHaviorController.HtyFctUserBeHavior)用户分行为获取入参，userId="+userId);
        try {
            UserBeHaviorSearchDTO userBeHaviorSearchDTO = new UserBeHaviorSearchDTO();// 返回值
            HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO = new HtyFctUserBeHaviorSearchDTO();// 获得参数的对象
            if (userId!=null){
                htyFctUserBeHaviorSearchDTO.setUserId(userId);
            }
            if (StringUtils.isNotEmpty(startTime)) {
                htyFctUserBeHaviorSearchDTO.setStartTime(startTime);
            }
            if (StringUtils.isNotEmpty(endTime)) {
                htyFctUserBeHaviorSearchDTO.setEndTime(endTime);
            }
            if ("".equals(startTime)&&"".equals(endTime)||startTime==null&&endTime==null){
                htyFctUserBeHaviorSearchDTO.setStartTime(DateTimeUtil.getTodayChar8());
                htyFctUserBeHaviorSearchDTO.setEndTime(DateTimeUtil.getTodayChar8());
            }
            List<String> b2bLndPageList=new ArrayList<String>();
            List<BigDecimal> b2bLndPageNumList=new ArrayList<BigDecimal>();
            List<String> b2bSearchKeyList=new ArrayList<String>();
            List<BigDecimal> b2bSearchKeyNumList=new ArrayList<BigDecimal>();
            List<String> b2bItemAccessList=new ArrayList<String>();
            List<BigDecimal> b2bItemAccessNumList=new ArrayList<BigDecimal>();
            List<String> b2bConvFunnelList=new ArrayList<String>();
            List<BigDecimal> b2bConvFunnelNumList=new ArrayList<BigDecimal>();
            List<String> b2bRepeatBuyList=new ArrayList<String>();
            List<BigDecimal> b2bRepeatBuyNumList=new ArrayList<BigDecimal>();
            List<String> b2bSaleCityProdyList=new ArrayList<String>();
            List<BigDecimal> b2bSaleCityProdNumList=new ArrayList<BigDecimal>();

            HtyFctXwB2bLndPageDTO htyFctXwB2bLndPage=new HtyFctXwB2bLndPageDTO();
            HtyFctXwB2bSearchKeyDTO htyFctXwB2bSearchKey=new HtyFctXwB2bSearchKeyDTO();
            HtyFctXwB2bItemAccessDTO htyFctXwB2bItemAccess=new HtyFctXwB2bItemAccessDTO();
            HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnel=new HtyFctXwB2bConvFunnelDTO();
            HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnelRePeat=new HtyFctXwB2bConvFunnelDTO();
            HtyFctSaleCityProdDTO htyFctSaleCityProd=new HtyFctSaleCityProdDTO();
            HtyFctCustAllDto htyFctCustAllDTO=htyFctCustAllDTOService.queryCityAndProByUserId(htyFctUserBeHaviorSearchDTO);

            //全国 暂时没有国外
            if("0".equals(radio)||radio==null){
                // 落地页面的访问数量
                List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO= htyFctXwB2bLndPageDTOService
                        .queryAllAccessQty(htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bLndPageDTO.size()>0){
                    for (HtyFctXwB2bLndPageDTO b2bLndPage:htyFctXwB2bLndPageDTO){
                        b2bLndPageNumList.add(b2bLndPage.getAccessQty());
                        b2bLndPageList.add(b2bLndPage.getPageTitle());
                    }
                    userBeHaviorSearchDTO.setB2bLndPageList(b2bLndPageList);
                    userBeHaviorSearchDTO.setB2bLndPageNumList(b2bLndPageNumList);
                }
                // 关键词搜索
                List<HtyFctXwB2bSearchKeyDTO> htyFctXwB2bSearchKeyDTO = htyFctXwB2bSearchKeyDTOService
                        .queryAllSearchKeyWord(htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bSearchKeyDTO.size()>0){
                    for(HtyFctXwB2bSearchKeyDTO b2bSearchKey:htyFctXwB2bSearchKeyDTO){
                        b2bSearchKeyList.add(b2bSearchKey.getSearchKeyword());
                        b2bSearchKeyNumList.add(b2bSearchKey.getSearchQty());
                    }
                    userBeHaviorSearchDTO.setB2bSearchKeyList(b2bSearchKeyList);
                    userBeHaviorSearchDTO.setB2bSearchKeyNumList(b2bSearchKeyNumList);
                }
                // 单品访问数量
                List<HtyFctXwB2bItemAccessDTO> htyFctXwB2bItemAccessDTO = htyFctXwB2bItemAccessDTOService
                        .queryOneItemAccessQty(htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bItemAccessDTO.size()>0){
                    for (HtyFctXwB2bItemAccessDTO b2bItemAccess:htyFctXwB2bItemAccessDTO){
                        b2bItemAccessList.add(b2bItemAccess.getItemId());
                        b2bItemAccessNumList.add(b2bItemAccess.getAccessQty());
                    }
                    userBeHaviorSearchDTO.setB2bItemAccessNumList(b2bItemAccessNumList);
                    userBeHaviorSearchDTO.setB2bItemAccessList(b2bItemAccessList);
                }
                // 漏斗转换及复购
                // 1漏斗购买
                List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTO = htyFctXwB2bConvFunnelDTOService
                        .queryStepSequenceNum(htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bConvFunnelDTO.size()>0){
                    for (HtyFctXwB2bConvFunnelDTO b2bConvFunnel:htyFctXwB2bConvFunnelDTO){
                        b2bConvFunnelList.add(b2bConvFunnel.getStepName());
                        b2bConvFunnelNumList.add(b2bConvFunnel.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bConvFunnelList(b2bConvFunnelList);
                    userBeHaviorSearchDTO.setB2bConvFunnelNumList(b2bConvFunnelNumList);
                }
                // 2重复购买
                List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTORepeatBuy = htyFctXwB2bConvFunnelDTOService
                        .queryByPaySuccessNextDay(htyFctUserBeHaviorSearchDTO);

                if(htyFctXwB2bConvFunnelDTORepeatBuy.size()>0){
                    for(HtyFctXwB2bConvFunnelDTO repeatBuy:htyFctXwB2bConvFunnelDTORepeatBuy){
                        b2bRepeatBuyList.add(repeatBuy.getStepName());
                        b2bRepeatBuyNumList.add(repeatBuy.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bRepeatBuyList(b2bRepeatBuyList);
                    userBeHaviorSearchDTO.setB2bRepeatBuyNumList(b2bRepeatBuyNumList);
                }
                // 成交单品
                List<HtyFctSaleCityProdDTO> htyFctSaleCityProdDTO = htyFctSaleCityProdDTOService
                        .querySaleOutItemNum(htyFctUserBeHaviorSearchDTO);
                if(htyFctSaleCityProdDTO.size()>0){
                    for (HtyFctSaleCityProdDTO saleCityProd:htyFctSaleCityProdDTO){
                        b2bSaleCityProdyList.add(saleCityProd.getProdName());
                        b2bSaleCityProdNumList.add(saleCityProd.getXsQty());
                    }
                    userBeHaviorSearchDTO.setB2bSaleCityProdyList(b2bSaleCityProdyList);
                    userBeHaviorSearchDTO.setB2bSaleCityProdNumList(b2bSaleCityProdNumList);
                }
            }
            //省查询
            if("1".equals(radio)){
             String proName=htyFctCustAllDTO.getAreaProName();
                //关键词
                htyFctXwB2bSearchKey.setProvinceName(proName);
                List<HtyFctXwB2bSearchKeyDTO>  htyFctXwB2bSearchKeyDTO= htyFctXwB2bSearchKeyDTOService.queryByNameSearchKey(htyFctXwB2bSearchKey, htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bSearchKeyDTO.size()>0){
                    for (HtyFctXwB2bSearchKeyDTO b2bSearchKey:htyFctXwB2bSearchKeyDTO){
                        b2bSearchKeyList.add(b2bSearchKey.getSearchKeyword());
                        b2bSearchKeyNumList.add(b2bSearchKey.getSearchQty());
                    }
                    userBeHaviorSearchDTO.setB2bSearchKeyList(b2bSearchKeyList);
                    userBeHaviorSearchDTO.setB2bSearchKeyNumList(b2bSearchKeyNumList);
                }
                //落地页
                htyFctXwB2bLndPage.setProvinceName(proName);
                List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO= htyFctXwB2bLndPageDTOService.queryByProNameAndCityName(htyFctXwB2bLndPage, htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bLndPageDTO.size()>0){
                    for (HtyFctXwB2bLndPageDTO b2bLndPage:htyFctXwB2bLndPageDTO){
                        b2bLndPageNumList.add(b2bLndPage.getAccessQty());
                        b2bLndPageList.add(b2bLndPage.getPageTitle());
                    }
                    userBeHaviorSearchDTO.setB2bLndPageList(b2bLndPageList);
                    userBeHaviorSearchDTO.setB2bLndPageNumList(b2bLndPageNumList);
                }
                //单品访问量
                htyFctXwB2bItemAccess.setProvinceName(proName);
                List<HtyFctXwB2bItemAccessDTO>htyFctXwB2bItemAccessDTO=htyFctXwB2bItemAccessDTOService.queryByProAndCity(htyFctXwB2bItemAccess,htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bItemAccessDTO.size()>0){
                    for (HtyFctXwB2bItemAccessDTO b2bItemAccess:htyFctXwB2bItemAccessDTO){
                        b2bItemAccessList.add(b2bItemAccess.getItemId());
                        b2bItemAccessNumList.add(b2bItemAccess.getAccessQty());
                    }
                    userBeHaviorSearchDTO.setB2bItemAccessNumList(b2bItemAccessNumList);
                    userBeHaviorSearchDTO.setB2bItemAccessList(b2bItemAccessList);
                }
                // 漏斗转换及复购
                // 1漏斗购买、
                htyFctXwB2bConvFunnel.setProvinceName(proName);
                List<HtyFctXwB2bConvFunnelDTO>htyFctXwB2bConvFunnelDTO=htyFctXwB2bConvFunnelDTOService.queryByProAndCity(htyFctXwB2bConvFunnel,htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bConvFunnelDTO.size()>0){
                    for (HtyFctXwB2bConvFunnelDTO b2bConvFunnel:htyFctXwB2bConvFunnelDTO){
                        b2bConvFunnelList.add(b2bConvFunnel.getStepName());
                        b2bConvFunnelNumList.add(b2bConvFunnel.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bConvFunnelList(b2bConvFunnelList);
                    userBeHaviorSearchDTO.setB2bConvFunnelNumList(b2bConvFunnelNumList);
                }
                // 2重复购买
                htyFctXwB2bConvFunnelRePeat.setProvinceName(proName);
                List<HtyFctXwB2bConvFunnelDTO>htyFctXwB2bConvFunnelDTORepeatBuy=htyFctXwB2bConvFunnelDTOService.queryByProAndCityRepeat(htyFctXwB2bConvFunnelRePeat, htyFctUserBeHaviorSearchDTO);
                if(htyFctXwB2bConvFunnelDTORepeatBuy.size()>0){
                    for(HtyFctXwB2bConvFunnelDTO repeatBuy:htyFctXwB2bConvFunnelDTORepeatBuy){
                        b2bRepeatBuyList.add(repeatBuy.getStepName());
                        b2bRepeatBuyNumList.add(repeatBuy.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bRepeatBuyList(b2bRepeatBuyList);
                    userBeHaviorSearchDTO.setB2bRepeatBuyNumList(b2bRepeatBuyNumList);
                }
                // 成交单品
                htyFctSaleCityProd.setCustProName(proName);
                List<HtyFctSaleCityProdDTO>htyFctSaleCityProdDTO=htyFctSaleCityProdDTOService.queryProAndCity(htyFctSaleCityProd,htyFctUserBeHaviorSearchDTO);
                if(htyFctSaleCityProdDTO.size()>0){
                    for (HtyFctSaleCityProdDTO saleCityProd:htyFctSaleCityProdDTO){
                        b2bSaleCityProdyList.add(saleCityProd.getProdName());
                        b2bSaleCityProdNumList.add(saleCityProd.getXsQty());
                    }
                    userBeHaviorSearchDTO.setB2bSaleCityProdyList(b2bSaleCityProdyList);
                    userBeHaviorSearchDTO.setB2bSaleCityProdNumList(b2bSaleCityProdNumList);
                }
            }
            //市查询
            if("2".equals(radio)) {
              String cityName= htyFctCustAllDTO.getAreaCityName();
                //关键词
                htyFctXwB2bSearchKey.setCityName(cityName);
                List<HtyFctXwB2bSearchKeyDTO> htyFctXwB2bSearchKeyDTO = htyFctXwB2bSearchKeyDTOService.queryByNameSearchKey(htyFctXwB2bSearchKey, htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bSearchKeyDTO.size() > 0) {
                    for (HtyFctXwB2bSearchKeyDTO b2bSearchKey : htyFctXwB2bSearchKeyDTO) {
                        b2bSearchKeyList.add(b2bSearchKey.getSearchKeyword());
                        b2bSearchKeyNumList.add(b2bSearchKey.getSearchQty());
                    }
                    userBeHaviorSearchDTO.setB2bSearchKeyList(b2bSearchKeyList);
                    userBeHaviorSearchDTO.setB2bSearchKeyNumList(b2bSearchKeyNumList);
                }
                //落地页
                htyFctXwB2bLndPage.setCityName(cityName);
                List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO = htyFctXwB2bLndPageDTOService.queryByProNameAndCityName(htyFctXwB2bLndPage, htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bLndPageDTO.size() > 0) {
                    for (HtyFctXwB2bLndPageDTO b2bLndPage : htyFctXwB2bLndPageDTO) {
                        b2bLndPageNumList.add(b2bLndPage.getAccessQty());
                        b2bLndPageList.add(b2bLndPage.getPageTitle());
                    }
                    userBeHaviorSearchDTO.setB2bLndPageList(b2bLndPageList);
                    userBeHaviorSearchDTO.setB2bLndPageNumList(b2bLndPageNumList);
                }
                //单品访问量
                htyFctXwB2bItemAccess.setCityName(cityName);
                List<HtyFctXwB2bItemAccessDTO> htyFctXwB2bItemAccessDTO = htyFctXwB2bItemAccessDTOService.queryByProAndCity(htyFctXwB2bItemAccess, htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bItemAccessDTO.size() > 0) {
                    for (HtyFctXwB2bItemAccessDTO b2bItemAccess : htyFctXwB2bItemAccessDTO) {
                        b2bItemAccessList.add(b2bItemAccess.getItemId());
                        b2bItemAccessNumList.add(b2bItemAccess.getAccessQty());
                    }
                    userBeHaviorSearchDTO.setB2bItemAccessNumList(b2bItemAccessNumList);
                    userBeHaviorSearchDTO.setB2bItemAccessList(b2bItemAccessList);
                }

                // 漏斗转换及复购
                // 1漏斗购买、
                htyFctXwB2bConvFunnel.setCityName(cityName);
                List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTO = htyFctXwB2bConvFunnelDTOService.queryByProAndCity(htyFctXwB2bConvFunnel, htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bConvFunnelDTO.size() > 0) {
                    for (HtyFctXwB2bConvFunnelDTO b2bConvFunnel : htyFctXwB2bConvFunnelDTO) {
                        b2bConvFunnelList.add(b2bConvFunnel.getStepName());
                        b2bConvFunnelNumList.add(b2bConvFunnel.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bConvFunnelList(b2bConvFunnelList);
                    userBeHaviorSearchDTO.setB2bConvFunnelNumList(b2bConvFunnelNumList);
                }
                // 2重复购买
                htyFctXwB2bConvFunnelRePeat.setCityName(cityName);
                List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTORepeatBuy = htyFctXwB2bConvFunnelDTOService.queryByProAndCityRepeat(htyFctXwB2bConvFunnelRePeat, htyFctUserBeHaviorSearchDTO);
                if (htyFctXwB2bConvFunnelDTORepeatBuy.size() > 0) {
                    for (HtyFctXwB2bConvFunnelDTO repeatBuy : htyFctXwB2bConvFunnelDTORepeatBuy) {
                        b2bRepeatBuyList.add(repeatBuy.getStepName());
                        b2bRepeatBuyNumList.add(repeatBuy.getStepSequence());
                    }
                    userBeHaviorSearchDTO.setB2bRepeatBuyList(b2bRepeatBuyList);
                    userBeHaviorSearchDTO.setB2bRepeatBuyNumList(b2bRepeatBuyNumList);
                }
                // 成交单品
                htyFctSaleCityProd.setCustProName(cityName);
                List<HtyFctSaleCityProdDTO> htyFctSaleCityProdDTO = htyFctSaleCityProdDTOService.queryProAndCity(htyFctSaleCityProd, htyFctUserBeHaviorSearchDTO);
                if (htyFctSaleCityProdDTO.size() > 0) {
                    for (HtyFctSaleCityProdDTO saleCityProd : htyFctSaleCityProdDTO) {
                        b2bSaleCityProdyList.add(saleCityProd.getProdName());
                        b2bSaleCityProdNumList.add(saleCityProd.getXsQty());
                    }
                    userBeHaviorSearchDTO.setB2bSaleCityProdyList(b2bSaleCityProdyList);
                    userBeHaviorSearchDTO.setB2bSaleCityProdNumList(b2bSaleCityProdNumList);
                }
            }
            // 组装到 result里  响应的返回数据
            result.setData(userBeHaviorSearchDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取用户行为的查询" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
}
