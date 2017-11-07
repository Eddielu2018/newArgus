package cn.htd.argus.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.HtyFctSaleCityProdDTOService;
import cn.htd.argus.service.HtyFctXwB2bConvFunnelDTOService;
import cn.htd.argus.service.HtyFctXwB2bItemAccessDTOService;
import cn.htd.argus.service.HtyFctXwB2bLndPageDTOService;
import cn.htd.argus.service.HtyFctXwB2bSearchKeyDTOService;
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
            @RequestParam(value = "period",required = false)String period
    ) {
        RestResult result = new RestResult();
        try {
            UserBeHaviorSearchDTO userBeHaviorSearchDTO = new UserBeHaviorSearchDTO();// 返回值
            HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO = new HtyFctUserBeHaviorSearchDTO();// 获得参数的对象
            if (StringUtils.isNotEmpty(startTime)) {
                htyFctUserBeHaviorSearchDTO.setStartTime(startTime);
            }
            if (StringUtils.isNotEmpty(endTime)) {
                htyFctUserBeHaviorSearchDTO.setEndTime(endTime);
            }
            if (StringUtils.isEmpty(period)){
                String date= DateTimeUtil.getTodayChar8();
                htyFctUserBeHaviorSearchDTO.setPeriod(date);
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

            //全国 暂时没有国外
            if(radio.equals("0")||radio==null||radio==""){
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
            if(radio.equals("1")){
                //关键词
                HtyFctXwB2bSearchKeyDTO searchKeyProName =htyFctXwB2bSearchKeyDTOService.queryProNameSearchKey(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bSearchKey.setProvinceName(searchKeyProName.getProvinceName());
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
                HtyFctXwB2bLndPageDTO b2bLndPageProName =htyFctXwB2bLndPageDTOService.queryProName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bLndPage.setProvinceName(b2bLndPageProName.getProvinceName());
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
                HtyFctXwB2bItemAccessDTO b2bItemAccessPro=htyFctXwB2bItemAccessDTOService.queryProName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bItemAccess.setProvinceName(b2bItemAccessPro.getProvinceName());
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
                HtyFctXwB2bConvFunnelDTO b2bConvFunnelProName=htyFctXwB2bConvFunnelDTOService.queryProName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bConvFunnel.setProvinceName(b2bConvFunnelProName.getProvinceName());
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
                HtyFctXwB2bConvFunnelDTO b2bConvFunnelProNameRepeat=htyFctXwB2bConvFunnelDTOService.queryProName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bConvFunnelRePeat.setProvinceName(b2bConvFunnelProNameRepeat.getProvinceName());
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
                HtyFctSaleCityProdDTO htyFctSaleCityProdProName=htyFctSaleCityProdDTOService.queryProName(htyFctUserBeHaviorSearchDTO);
                htyFctSaleCityProd.setCustProName(htyFctSaleCityProdProName.getCustProName());
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
            if(radio.equals("2")) {
                //关键词
                HtyFctXwB2bSearchKeyDTO searchKeyCityName = htyFctXwB2bSearchKeyDTOService.queryCityNameSearchKey(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bSearchKey.setCityName(searchKeyCityName.getCityName());
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
                HtyFctXwB2bLndPageDTO b2bLndPageCityName = htyFctXwB2bLndPageDTOService.queryCityName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bLndPage.setCityName(b2bLndPageCityName.getCityName());
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
                HtyFctXwB2bItemAccessDTO b2bItemAccessCity = htyFctXwB2bItemAccessDTOService.queryCityName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bItemAccess.setCityName(b2bItemAccessCity.getCityName());
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
                HtyFctXwB2bConvFunnelDTO b2bConvFunnelCityName = htyFctXwB2bConvFunnelDTOService.queryCityName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bConvFunnel.setCityName(b2bConvFunnelCityName.getCityName());
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
                HtyFctXwB2bConvFunnelDTO b2bConvFunnelCityNameRepeat = htyFctXwB2bConvFunnelDTOService.queryCityName(htyFctUserBeHaviorSearchDTO);
                htyFctXwB2bConvFunnelRePeat.setCityName(b2bConvFunnelCityNameRepeat.getCityName());
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
                HtyFctSaleCityProdDTO htyFctSaleCityProdCityName = htyFctSaleCityProdDTOService.queryCityName(htyFctUserBeHaviorSearchDTO);
                htyFctSaleCityProd.setCustProName(htyFctSaleCityProdCityName.getCustProName());
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
