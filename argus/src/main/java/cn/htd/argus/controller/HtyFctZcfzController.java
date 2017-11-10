package cn.htd.argus.controller;

import cn.htd.argus.bean.*;
import cn.htd.argus.dto.EdwFctL2OkrKpiFinanceDTO;
import cn.htd.argus.dto.EdwFctZsdFinanceDTO;
import cn.htd.argus.dto.EdwFctl1DupontDetailDTO;
import cn.htd.argus.dto.HtyFctL2DupontDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.*;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 财务效率
 * Created by wangtp on 2017/10/31.
 */
@RestController
@RequestMapping("/htyfctzcfz")
public class HtyFctZcfzController {
    Logger logger = LoggerFactory.getLogger(HtyFctZcfzController.class);

    @Autowired
    private HtyFctL2DupontDTOService htyFctL2DupontDTOService;
    @Autowired
    private EdwFctZsdFinanceDTOService edwFctZsdFinanceDTOService;
    @Autowired
    private EdwFctL2OkrKpiFinanceDTOService edwFctL2OkrKpiFinanceDTOService;
    @Autowired
    private EdwFctl1DupontDetailDTOService edwFctl1DupontDetailDTOService;


    /**
     * 杜邦分析
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/dupont/all")
    public RestResult dupontAll(@RequestParam(value = "userId", required = true) String userId,
                              @RequestParam(value = "endTime", required = false) String endTime) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctZcfzController.dupontAll)首页页头估值获得入参，userId=" + userId+"，endTime="+endTime);
        try {
            DupontAllDTO dupontAllDTO = new DupontAllDTO();
            DupontRadarDTO dupontRadarDTO = null;
            //1.雷达
            HtyFctL2DupontDTO htyFctL2DupontDTO = this.htyFctL2DupontDTOService.select(userId,endTime);
            if(htyFctL2DupontDTO != null){
                dupontRadarDTO = getRadar(htyFctL2DupontDTO);
            }
            //2.主图上部
            HtyFctL2DupontDTO htyFctL2DupontDTO1 = this.htyFctL2DupontDTOService.selectTb(userId,endTime);
            //3.主图下部
            EdwFctl1DupontDetailDTO edwFctl1DupontDetailDTO = this.edwFctl1DupontDetailDTOService.selectTb(userId,endTime);
            DupontDTO dupontDTO = getDupontDTO(htyFctL2DupontDTO1,edwFctl1DupontDetailDTO);

            dupontAllDTO.setDupontDTO(dupontDTO);
            dupontAllDTO.setDupontRadarDTO(dupontRadarDTO);
            result.setData(dupontAllDTO);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("杜邦分析" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 风险提示
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/finance/all")
    public RestResult financeAll(@RequestParam(value = "userId", required = true) String userId,
                                @RequestParam(value = "endTime", required = false) String endTime) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctZcfzController.financeAll)首页页头估值获得入参，userId=" + userId+"，endTime="+endTime);

        EdwFctZsdFinanceDTO edwFctZsdFinanceDTO = this.edwFctZsdFinanceDTOService.select(userId,endTime);
        EdwFctL2OkrKpiFinanceDTO edwFctL2OkrKpiFinanceDTO = this.edwFctL2OkrKpiFinanceDTOService.selectFinance(userId, endTime);
        FinanceDTO financeDTO = getFinanceDTO(edwFctZsdFinanceDTO, edwFctL2OkrKpiFinanceDTO);
        return null;
    }

    /**
     * 业务支持
     * @param userId
     * @param endTime
     * @return
     */
    @RequestMapping("/support/all")
    public RestResult supportAll(@RequestParam(value = "userId", required = true) String userId,
                                 @RequestParam(value = "endTime", required = false) String endTime) {
        RestResult result = new RestResult();
        logger.info("调用(HtyFctZcfzController.supportAll)首页页头估值获得入参，userId=" + userId+"，endTime="+endTime);

        EdwFctZsdFinanceDTO edwFctZsdFinanceDTO = this.edwFctZsdFinanceDTOService.selectSupport(userId, endTime);
        FinanceSupportDTO financeSupportDTO = getFinanceSupportDTO(edwFctZsdFinanceDTO);
        return null;
    }

    /**
     * 杜邦分析封装数据
     * @param htyFctL2DupontDTO
     * @param edwFctl1DupontDetailDTO
     * @return
     */
    private DupontDTO getDupontDTO(HtyFctL2DupontDTO htyFctL2DupontDTO, EdwFctl1DupontDetailDTO edwFctl1DupontDetailDTO){
        DupontDTO dupontDTO = new DupontDTO();
        if(htyFctL2DupontDTO != null){
            dupontDTO.setDqRoe(htyFctL2DupontDTO.getDqRoe());
            dupontDTO.setTbRoe(htyFctL2DupontDTO.getTbRoe());
            dupontDTO.setDqGrossProfitRatio(htyFctL2DupontDTO.getDqGrossProfitRatio());
            dupontDTO.setTbGrossProfitRatio(htyFctL2DupontDTO.getTbGrossProfitRatio());
            dupontDTO.setDqDebtAssetsRatio(htyFctL2DupontDTO.getDqDebtAssetsRatio());
            dupontDTO.setTbDebtAssetsRatio(htyFctL2DupontDTO.getTbDebtAssetsRatio());
            dupontDTO.setDqOperateCycle(htyFctL2DupontDTO.getDqOperateCycle());
            dupontDTO.setTbOperateCycle(htyFctL2DupontDTO.getTbOperateCycle());
            dupontDTO.setDqSaleGrowthRatio(htyFctL2DupontDTO.getDqSaleGrowthRatio());
            dupontDTO.setTbSaleGrowthRatio(htyFctL2DupontDTO.getTbSaleGrowthRatio());
            dupontDTO.setDqOperateProfitRatio(htyFctL2DupontDTO.getDqOperateProfitRatio());
            dupontDTO.setTbOperateProfitRatio(htyFctL2DupontDTO.getTbOperateProfitRatio());
            dupontDTO.setDqCurrentRatio(htyFctL2DupontDTO.getDqCurrentRatio());
            dupontDTO.setTbCurrentRatio(htyFctL2DupontDTO.getTbCurrentRatio());
            dupontDTO.setDqCashCycle(htyFctL2DupontDTO.getDqCashCycle());
            dupontDTO.setTbCashCycle(htyFctL2DupontDTO.getTbCashCycle());
            dupontDTO.setDqNetGrowthRatio(htyFctL2DupontDTO.getDqNetGrowthRatio());
            dupontDTO.setTbNetGrowthRatio(htyFctL2DupontDTO.getTbNetGrowthRatio());
            dupontDTO.setDqThirdRatio(htyFctL2DupontDTO.getDqThirdRatio());
            dupontDTO.setTbThirdRatio(htyFctL2DupontDTO.getTbThirdRatio());
            dupontDTO.setDqQuickRatio(htyFctL2DupontDTO.getDqQuickRatio());
            dupontDTO.setTbQuickRatio(htyFctL2DupontDTO.getTbQuickRatio());
            dupontDTO.setDqReceiveConvDays(htyFctL2DupontDTO.getDqReceiveConvDays());
            dupontDTO.setTbReceiveConvDays(htyFctL2DupontDTO.getTbReceiveConvDays());
            dupontDTO.setDqRota(htyFctL2DupontDTO.getDqRota());
            dupontDTO.setTbRota(htyFctL2DupontDTO.getTbRota());
            dupontDTO.setDqSaleNetRatio(htyFctL2DupontDTO.getDqSaleNetRatio());
            dupontDTO.setTbSaleNetRatio(htyFctL2DupontDTO.getTbSaleNetRatio());
            dupontDTO.setDqQycs(htyFctL2DupontDTO.getDqQycs());
            dupontDTO.setTbQycs(htyFctL2DupontDTO.getTbQycs());
        }
        if(edwFctl1DupontDetailDTO != null){
            dupontDTO.setDqAssetsConvRatio(edwFctl1DupontDetailDTO.getDqAssetsConvRatio());
            dupontDTO.setTbAssetsConvRatio(edwFctl1DupontDetailDTO.getTbAssetsConvRatio());
            dupontDTO.setDqAvgAssets(edwFctl1DupontDetailDTO.getDqAvgAssets());
            dupontDTO.setTbAvgAssets(edwFctl1DupontDetailDTO.getTbAvgAssets());
            dupontDTO.setDqTotalAssets(edwFctl1DupontDetailDTO.getDqTotalAssets());
            dupontDTO.setTbTotalAssets(edwFctl1DupontDetailDTO.getTbTotalAssets());
            dupontDTO.setDqLongAssets(edwFctl1DupontDetailDTO.getDqLongAssets());
            dupontDTO.setTbLongAssets(edwFctl1DupontDetailDTO.getTbLongAssets());
            dupontDTO.setDqCurrentAssets(edwFctl1DupontDetailDTO.getDqCurrentAssets());
            dupontDTO.setTbCurrentAssets(edwFctl1DupontDetailDTO.getTbCurrentAssets());
            dupontDTO.setDqMoneyFunds(edwFctl1DupontDetailDTO.getDqMoneyFunds());
            dupontDTO.setTbMoneyFunds(edwFctl1DupontDetailDTO.getTbMoneyFunds());
            dupontDTO.setDqDepositPayable(edwFctl1DupontDetailDTO.getDqDepositPayable());
            dupontDTO.setTbDepositPayable(edwFctl1DupontDetailDTO.getTbDepositPayable());
            dupontDTO.setDqLiabilities(edwFctl1DupontDetailDTO.getDqLiabilities());
            dupontDTO.setTbTotalLiabilities(edwFctl1DupontDetailDTO.getTbTotalLiabilities());
            dupontDTO.setDqLongLiabilities(edwFctl1DupontDetailDTO.getDqLongLiabilities());
            dupontDTO.setTbLongLiabilities(edwFctl1DupontDetailDTO.getTbLongLiabilities());
            dupontDTO.setDqCurrentLiabilities(edwFctl1DupontDetailDTO.getDqCurrentLiabilities());
            dupontDTO.setTbCurrentLiabilities(edwFctl1DupontDetailDTO.getTbCurrentLiabilities());
            dupontDTO.setDqInventory(edwFctl1DupontDetailDTO.getDqInventory());
            dupontDTO.setTbInventory(edwFctl1DupontDetailDTO.getTbInventory());
            dupontDTO.setDqReceivables(edwFctl1DupontDetailDTO.getDqReceivables());
            dupontDTO.setTbReceivables(edwFctl1DupontDetailDTO.getTbReceivables());
            dupontDTO.setDqPrtlossSale(edwFctl1DupontDetailDTO.getDqPrtlossSale());
            dupontDTO.setTbPprtlossSale(edwFctl1DupontDetailDTO.getTbPprtlossSale());
            dupontDTO.setDqPrtlossCost(edwFctl1DupontDetailDTO.getDqPrtlossCost());
            dupontDTO.setTbPrtlossCost(edwFctl1DupontDetailDTO.getTbPrtlossCost());
            dupontDTO.setDqPrtlossBefore(edwFctl1DupontDetailDTO.getDqPrtlossBefore());
            dupontDTO.setTbPrtlossBefore(edwFctl1DupontDetailDTO.getTbPrtlossBefore());
            dupontDTO.setDqPrtlossExpense(edwFctl1DupontDetailDTO.getDqPrtlossExpense());
            dupontDTO.setTbPrtlossExpense(edwFctl1DupontDetailDTO.getTbPrtlossExpense());
            dupontDTO.setDqPrtlossNet(edwFctl1DupontDetailDTO.getDqPrtlossNet());
            dupontDTO.setTbPrtlossNet(edwFctl1DupontDetailDTO.getTbPrtlossNet());
            dupontDTO.setDqPrtlossGross(edwFctl1DupontDetailDTO.getDqPrtlossGross());
            dupontDTO.setTbPrtlossGross(edwFctl1DupontDetailDTO.getTbPrtlossGross());
            dupontDTO.setDqPrtlossOperate(edwFctl1DupontDetailDTO.getDqPrtlossOperate());
            dupontDTO.setTbPrtlossOperate(edwFctl1DupontDetailDTO.getTbPrtlossOperate());
            dupontDTO.setDqOtherPrtloss(edwFctl1DupontDetailDTO.getDqOtherPrtloss());
            dupontDTO.setTbOtherPrtloss(edwFctl1DupontDetailDTO.getTbOtherPrtloss());
        }
        return dupontDTO;
    }

    /**
     * 业务支持封装数据
     * @param edwFctZsdFinanceDTO
     * @return
     */
    private FinanceSupportDTO getFinanceSupportDTO(EdwFctZsdFinanceDTO edwFctZsdFinanceDTO){
        FinanceSupportDTO financeSupportDTO = new FinanceSupportDTO();
        if(edwFctZsdFinanceDTO != null){
            financeSupportDTO.setWhiteRatio(edwFctZsdFinanceDTO.getWhiteRatio());
            financeSupportDTO.setActWhiteRatio(edwFctZsdFinanceDTO.getActWhiteRatio());
            financeSupportDTO.setWhiteLoanRatio(edwFctZsdFinanceDTO.getWhiteLoanRatio());
            financeSupportDTO.setMonNewTicketRatio(edwFctZsdFinanceDTO.getMonNewTicketRatio());
            financeSupportDTO.setFinancialexpensesRatio(edwFctZsdFinanceDTO.getFinancialexpensesRatio());
            financeSupportDTO.setTiecardmemberRatio(edwFctZsdFinanceDTO.getTiecardmemberRatio());
        }
        return financeSupportDTO;
    }

    /**
     * 风险提示封装数据
     * @param edwFctZsdFinanceDTO
     * @param edwFctL2OkrKpiFinanceDTO
     * @return
     */
    private FinanceDTO getFinanceDTO(EdwFctZsdFinanceDTO edwFctZsdFinanceDTO, EdwFctL2OkrKpiFinanceDTO edwFctL2OkrKpiFinanceDTO){
        FinanceDTO financeDTO = new FinanceDTO();
        BigDecimal zero = new BigDecimal(0);
        if(edwFctZsdFinanceDTO != null){
            if(edwFctZsdFinanceDTO.getOverdueAmtRatio() != null){
                financeDTO.setOverdueAmtRatio(edwFctZsdFinanceDTO.getOverdueAmtRatio());
            }else{
                financeDTO.setOverdueAmtRatio(zero);
            }
            if(edwFctZsdFinanceDTO.getOverdueCustnumRatio() != null){
                financeDTO.setOverdueCustnumRatio(edwFctZsdFinanceDTO.getOverdueCustnumRatio());
            }else{
                financeDTO.setOverdueCustnumRatio(zero);
            }
            if(edwFctZsdFinanceDTO.getOver30Ratio() != null){
                financeDTO.setOver30Ratio(edwFctZsdFinanceDTO.getOver30Ratio());
            }else{
                financeDTO.setOver30Ratio(zero);
            }
        }else{
            financeDTO.setOverdueAmtRatio(zero);
            financeDTO.setOverdueCustnumRatio(zero);
            financeDTO.setOver30Ratio(zero);
        }
        if(edwFctL2OkrKpiFinanceDTO != null){
            financeDTO.setXjYyRatio(edwFctL2OkrKpiFinanceDTO.getXjYyRatio());
            financeDTO.setYs90Ratio(edwFctL2OkrKpiFinanceDTO.getYs90Ratio());
            financeDTO.setHk15BgtRatio(edwFctL2OkrKpiFinanceDTO.getHk15BgtRatio());
            financeDTO.setYf90Ratio(edwFctL2OkrKpiFinanceDTO.getYf90Ratio());
            financeDTO.setSingleCustXsRatio(edwFctL2OkrKpiFinanceDTO.getSingleCustXsRatio());
            financeDTO.setPdDiffRatio(edwFctL2OkrKpiFinanceDTO.getPdDiffRatio());
            financeDTO.setBxPbRatio(edwFctL2OkrKpiFinanceDTO.getBxPbRatio());
            financeDTO.setPxDiffRatio(edwFctL2OkrKpiFinanceDTO.getPxDiffRatio());
        }
        return financeDTO;
    }

    /**
     * 雷达
     * @param htyFctL2DupontDTO
     * @return
     */
    private DupontRadarDTO getRadar(HtyFctL2DupontDTO htyFctL2DupontDTO){
        DupontRadarDTO dupontRadarDTO = new DupontRadarDTO();
        //整体
        BigDecimal whole = new BigDecimal(0);

        //1.获利
        BigDecimal profit = new BigDecimal(0);
        if(htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.2)) == 1){
            profit = ArithUtil.add(profit.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.175)) == 1 && (htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.2)) == -1 || htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.2)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.15)) ==1 && (htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.175)) == -1 || htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.175)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.125)) ==1 && (htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.15)) == -1 || htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.15)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.1)) ==1 && (htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.125)) == -1 || htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.125)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),1);
        }else if((htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.1)) == -1 || htyFctL2DupontDTO.getDqRoe().compareTo(new BigDecimal(0.1)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.05)) == 1){
            profit = ArithUtil.add(profit.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0425)) == 1 && (htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.05)) == -1 || htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.05)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.035)) == 1 && (htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0425)) == -1 || htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0425)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0275)) == 1 && (htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.035)) == -1 || htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.035)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.02)) == 1 && (htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0275)) == -1 || htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.0275)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.02)) == -1 || htyFctL2DupontDTO.getDqGrossProfitRatio().compareTo(new BigDecimal(0.02)) == 0){
            profit = ArithUtil.add(profit.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.015)) == 1){
            profit = ArithUtil.add(profit.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.01125)) == 1 && (htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.015)) == -1 || htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.015)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.0075)) == 1 && (htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.01125)) == -1 || htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.01125)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.00375)) == 1 && (htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.0075)) == -1 || htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.0075)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0)) == 1 && (htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.00375)) == -1 || htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0.00375)) == 0)){
            profit = ArithUtil.add(profit.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0)) == -1 || htyFctL2DupontDTO.getDqSaleNetRatio().compareTo(new BigDecimal(0)) == 0){
            profit = ArithUtil.add(profit.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.028)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.032)) == -1){
            profit = ArithUtil.add(profit.doubleValue(),5);
        }else if((htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0265)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.028)) != 1) || (htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.032)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0365)) != 1)){
            profit = ArithUtil.add(profit.doubleValue(),4);
        }else if((htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.021)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0265)) != 1) || (htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0365)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.041)) != 1)){
            profit = ArithUtil.add(profit.doubleValue(),3);
        }else if((htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0155)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.021)) != 1) || (htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.041)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0455)) != 1)){
            profit = ArithUtil.add(profit.doubleValue(),2);
        }else if((htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.01)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0155)) != 1) || (htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.0455)) == 1 && htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.05)) != 1)){
            profit = ArithUtil.add(profit.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.01)) != 1 || htyFctL2DupontDTO.getDqThirdRatio().compareTo(new BigDecimal(0.05)) == 1){
            profit = ArithUtil.add(profit.doubleValue(),0);
        }
        profit = ArithUtil.div(profit.doubleValue(),4,1);
        whole = ArithUtil.add(whole.doubleValue(),profit.doubleValue());

        //2.偿债
        BigDecimal sinking = new BigDecimal(0);
        if(htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.068)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.072)) == -1){
            sinking = ArithUtil.add(sinking.doubleValue(),5);
        }else if((htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.6)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.68)) != 1) || (htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.72)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.75)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),4);
        }else if((htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.55)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.6)) != 1) || (htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.75)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.79)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),3);
        }else if((htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.4)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.55)) != 1) || (htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.79)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.85)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),2);
        }else if((htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.4)) != 1) || (htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0.85)) == 1 && htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(1)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(0)) != 1 || htyFctL2DupontDTO.getDqDebtAssetsRatio().compareTo(new BigDecimal(1)) == 1){
            sinking = ArithUtil.add(sinking.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.9)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.1)) == -1){
            sinking = ArithUtil.add(sinking.doubleValue(),5);
        }else if((htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.875)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1)) != 1) || (htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.125)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),4);
        }else if((htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.75)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.875)) != 1) || (htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.125)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.25)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),3);
        }else if((htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.625)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.75)) != 1) || (htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.25)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.375)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),2);
        }else if((htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.5)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.625)) != 1) || (htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.375)) == 1 && htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.5)) != 1)){
            sinking = ArithUtil.add(sinking.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(0.5)) != 1 || htyFctL2DupontDTO.getDqQuickRatio().compareTo(new BigDecimal(1.5)) == 1){
            sinking = ArithUtil.add(sinking.doubleValue(),0);
        }
        sinking = ArithUtil.div(sinking.doubleValue(),2,1);
        whole = ArithUtil.add(whole.doubleValue(),sinking.doubleValue());

        //3.运营
        BigDecimal operate = new BigDecimal(0);
        if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(50)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(80)) == 1 && htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(60)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(60)) == 1 && htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(70)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(70)) == 1 && htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(80)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(80)) == 1 && htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(90)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqOperateCycle().compareTo(new BigDecimal(90)) == 1){
            operate = ArithUtil.add(operate.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(10)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(10)) == 1 && htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(15)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(15)) == 1 && htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(20)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(20)) == 1 && htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(25)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(25)) == 1 && htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(30)) != 1){
            operate = ArithUtil.add(operate.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqCashCycle().compareTo(new BigDecimal(30)) == 1){
            operate = ArithUtil.add(operate.doubleValue(),0);
        }
        operate = ArithUtil.div(operate.doubleValue(),2,1);
        whole = ArithUtil.add(whole.doubleValue(),operate.doubleValue());

        //4.运营
        BigDecimal grow = new BigDecimal(0);
        if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(30)) == 1){
            grow = ArithUtil.add(grow.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(22.5)) == 1 && htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(30)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(15)) == 1 && htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(22.5)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(7.5)) == 1 && htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(15)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(0)) == 1 && htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(7.5)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqSaleGrowthRatio().compareTo(new BigDecimal(0)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),0);
        }
        if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(50)) == 1){
            grow = ArithUtil.add(grow.doubleValue(),5);
        }else if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(37.5)) == 1 && htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(50)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),4);
        }else if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(25)) == 1 && htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(37.5)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),3);
        }else if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(12.5)) == 1 && htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(25)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),2);
        }else if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(0)) == 1 && htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(12.5)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),1);
        }else if(htyFctL2DupontDTO.getDqNetGrowthRatio().compareTo(new BigDecimal(0)) != 1){
            grow = ArithUtil.add(grow.doubleValue(),0);
        }
        grow = ArithUtil.div(grow.doubleValue(),2,1);
        whole = ArithUtil.add(whole.doubleValue(),grow.doubleValue());

        dupontRadarDTO.setWhole(ArithUtil.div(whole.doubleValue(),4,1));
        dupontRadarDTO.setGrow(grow);
        dupontRadarDTO.setOperate(operate);
        dupontRadarDTO.setProfit(profit);
        dupontRadarDTO.setSinking(sinking);
        return dupontRadarDTO;
    }
}
