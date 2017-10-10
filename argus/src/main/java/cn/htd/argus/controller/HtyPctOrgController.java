package cn.htd.argus.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.bean.HtyFctOrgAvgDTO;
import cn.htd.argus.bean.HtyFctOrgBusinessAvgDTO;
import cn.htd.argus.bean.HtyFctOrgMemberAvgDTO;
import cn.htd.argus.bean.HtyFctOrgSaleAvgDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dto.HtyFctOrgCustDTO;
import cn.htd.argus.dto.HtyFctOrgCustIncomeSaleDTO;
import cn.htd.argus.dto.HtyFctOrgIncomeDTO;
import cn.htd.argus.dto.HtyFctOrgSaleDTO;
import cn.htd.argus.dto.HtyFctOrgValueDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.DciDimOrgDTOService;
import cn.htd.argus.service.HtyFctOrgCustDTOService;
import cn.htd.argus.service.HtyFctOrgCustIncomeSaleDTOService;
import cn.htd.argus.service.HtyFctOrgIncomeDTOService;
import cn.htd.argus.service.HtyFctOrgSaleDTOService;
import cn.htd.argus.service.HtyFctOrgValueDTOService;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.RestResult;

/**
 * Created by wangtp on 2017/9/27.
 */
@RestController
@RequestMapping("/htypctorg")
public class HtyPctOrgController {
    Logger logger = LoggerFactory.getLogger(HtyPctOrgController.class);

    @Autowired
    private HtyFctOrgValueDTOService htyFctOrgValueDTOService;
    @Autowired
    private HtyFctOrgIncomeDTOService htyFctOrgIncomeDTOService;
    @Autowired
    private HtyFctOrgSaleDTOService htyFctOrgSaleDTOService;
    @Autowired
    private HtyFctOrgCustDTOService htyFctOrgCustDTOService;
    @Autowired
    private HtyFctOrgCustIncomeSaleDTOService htyFctOrgCustIncomeSaleDTOService;
    @Autowired
    private DciDimOrgDTOService dciDimOrgDTOService;
    /**
     * 首页页头估值
     * @param userId
     * @return
     */
    @RequestMapping("/index/handle")
    public RestResult indexForHandle(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForHandle)首页页头估值获得入参，userId="+userId);
        try {
            HtyFctOrgValueDTO htyFctOrgValueDTO = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
            if(htyFctOrgValueDTO != null){
            	DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
            	//可以设置精确几位小数  
                df.setMaximumFractionDigits(2);  
                //模式 例如四舍五入  
                df.setRoundingMode(RoundingMode.HALF_UP);  
            	int allNum = dciDimOrgDTOService.selectAllNum();
            	double sort = Double.valueOf(df.format(htyFctOrgValueDTO.getZtpm()/allNum*100));
            	if(htyFctOrgValueDTO.getZtpm() >= 1 && htyFctOrgValueDTO.getZtpm() <=10){
            		htyFctOrgValueDTO.setStarNum(new BigDecimal(4.5));
            	}else if(htyFctOrgValueDTO.getZtpm() >=11){
            		if(10 >= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(4));
            		}else if(10 < sort && 25 >= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(3.5));
            		}else if(25 < sort && 40 >= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(3));
            		}else if(40 < sort && 50>= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(2.5));
            		}else if(50 < sort && 75 >= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(2));
            		}else if(75 < sort && 90 >= sort){
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(1.5));
            		}else{
            			htyFctOrgValueDTO.setStarNum(new BigDecimal(1));
            		}
            	}else{
            		result.setCode(ResultCodeEnum.FAIL.getCode());
                    result.setMsg(ResultCodeEnum.FAIL.getMsg());
                    return result;
            	}
                result.setData(htyFctOrgValueDTO);
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
     * 首页当月/年总营业
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeBusiness")
    public RestResult indexForWholebBusiness(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeBusiness)首页当月/年总营业获取入参，userId="+userId);
        try {
            HtyFctOrgIncomeDTO htyFctOrgIncomeDTO= this.htyFctOrgIncomeDTOService.selectByOrgCode(userId);
            if(htyFctOrgIncomeDTO != null){
                result.setData(htyFctOrgIncomeDTO);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("获取当月/年总营业错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页当月/年总金额
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeMoney")
    public RestResult indexForWholebMoney(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeMoney)首页当月/年总金额获取入参，userId="+userId);
        try {
        	HtyFctOrgSaleDTO htyFctOrgSaleDTO = this.htyFctOrgSaleDTOService.selectByOrgCode(userId);
            if(htyFctOrgSaleDTO != null){
                result.setData(htyFctOrgSaleDTO);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页首页当月/年总金额错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页当月/年总会员
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeMember")
    public RestResult indexForWholebMember(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeMember)首页当月/年总会员获取入参，userId="+userId);
        try {
        	HtyFctOrgCustDTO htyFctOrgCustDTO = this.htyFctOrgCustDTOService.selectByOrgCode(userId);
            if(htyFctOrgCustDTO != null){
                result.setData(htyFctOrgCustDTO);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页首页当月/年总会员错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页当月折线图
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeMonth")
    public RestResult indexForWholeMonth(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeMonth)首页当月折线图获取入参，userId="+userId);
        try {
        	String yearWithDate = DateUtil.getCurDateStr1("yyyyMMdd");
        	String yearDate = DateUtil.getCurDateStr1("yyyyMM");
        	if("01".equals(yearWithDate.substring(yearWithDate.length()-2, yearWithDate.length()))){
        		yearDate = DateUtil.getAfterDate(new Date(),-1,"yyyyMM");
        	}
        	List<HtyFctOrgCustIncomeSaleDTO> list = this.htyFctOrgCustIncomeSaleDTOService.selectMonth(yearDate, userId);
            if(list != null){
                result.setData(list);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页当月折线图错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
   
    /**
     * 首页当年总营业竖图
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeYearBusiness")
    public RestResult indexForWholeYearBusiness(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeYearBusiness)首页当年总营业竖图获取入参，userId="+userId);
        try {
        	String yearWithDate = DateUtil.getCurDateStr1("yyyyMM");
        	String yearDate = DateUtil.getCurDateStr1("yyyy");
        	if("01".equals(yearWithDate.substring(yearWithDate.length()-2, yearWithDate.length()))){
        		yearDate = String.valueOf((Integer.valueOf(yearDate)-1));
        	}
        	List<HtyFctOrgIncomeDTO> list = this.htyFctOrgIncomeDTOService.selectYear(userId,yearDate);
            if(list != null){
                result.setData(list);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页当年总营业竖图错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页当年总金额竖图
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeYearSale")
    public RestResult indexForWholeYearSale(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeYearSale)首页当年总金额竖图获取入参，userId="+userId);
        try {
        	String yearWithDate = DateUtil.getCurDateStr1("yyyyMM");
        	String yearDate = DateUtil.getCurDateStr1("yyyy");
        	if("01".equals(yearWithDate.substring(yearWithDate.length()-2, yearWithDate.length()))){
        		yearDate = String.valueOf((Integer.valueOf(yearDate)-1));
        	}
        	List<HtyFctOrgSaleDTO> list = this.htyFctOrgSaleDTOService.selectYear(userId,yearDate);
            if(list != null){
                result.setData(list);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页当年总金额竖图错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页当年总会员竖图
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeYearMemeber")
    public RestResult indexForWholeYearMemeber(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeYearMemeber)首页当年总会员竖图获取入参，userId="+userId);
        try {
        	String yearWithDate = DateUtil.getCurDateStr1("yyyyMM");
        	String yearDate = DateUtil.getCurDateStr1("yyyy");
        	if("01".equals(yearWithDate.substring(yearWithDate.length()-2, yearWithDate.length()))){
        		yearDate = String.valueOf((Integer.valueOf(yearDate)-1));
        	}
        	List<HtyFctOrgCustDTO> list = this.htyFctOrgCustDTOService.selectYear(userId,yearDate);
            if(list != null){
                result.setData(list);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页当年总会员竖图错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页最新排序
     * @param userId
     * @return
     */
    @RequestMapping("/index/wholeSort")
    public RestResult indexForWholeWholeSort(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWholeWholeSort)首页最新排序获取入参，userId="+userId);
        try {
        	HtyFctOrgSortDTO allDto = new HtyFctOrgSortDTO();
        	HtyFctOrgValueDTO dto = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
        	String yearDate = dto.getYearmon();
        	allDto.setValueHead(dto.getZtpm());
        	allDto.setValueBranch(dto.getFbpm());
        	HtyFctOrgSortDTO idto = this.htyFctOrgIncomeDTOService.selectSort(userId, yearDate);
        	allDto.setIncomeHead(idto.getIncomeHead());
        	allDto.setIncomeBrach(idto.getIncomeBrach());
        	HtyFctOrgSortDTO sdto = this.htyFctOrgSaleDTOService.selectSort(userId, yearDate);
        	allDto.setSaleHead(sdto.getSaleHead());
        	allDto.setSaleBrach(sdto.getSaleBrach());
        	HtyFctOrgSortDTO mdto = this.htyFctOrgCustDTOService.selectSort(userId, yearDate);
        	allDto.setMemeberHead(mdto.getMemeberHead());
        	allDto.setMemeberBrach(mdto.getMemeberBrach());
            result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("首页最新排序错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页弹框
     * @param userId
     * @return
     */
    @RequestMapping("/index/box")
    public RestResult indexForBox(@RequestParam(value = "userId", required = true) String userId,@RequestParam(value = "type", required = true) int type) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForBox)首页弹框获取入参，userId="+userId);
        try {
        	HtyFctOrgAvgDTO allDto = new HtyFctOrgAvgDTO();
        	HtyFctOrgValueDTO dto = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
        	String yearDate = dto.getYearmon();
        	if(1 == type || 2 == type){
        		HtyFctOrgIncomeDTO htyFctOrgIncomeDTO = this.htyFctOrgIncomeDTOService.selectByOrgCode(userId);
            	allDto.setCompanyNow(htyFctOrgIncomeDTO.getYearBusincomeAmt());
            	HtyFctOrgSortDTO sdto = this.htyFctOrgIncomeDTOService.selectSort(userId, yearDate);
            	allDto.setHeadAvg(this.htyFctOrgIncomeDTOService.selectAvgHead(yearDate));
            	allDto.setBrachAvg(this.htyFctOrgIncomeDTOService.selectAvgBrach(userId, yearDate));
            	if(1 == type){
            		allDto.setSortNum(sdto.getSaleBrach());
            		allDto.setCompanyList(this.htyFctOrgIncomeDTOService.selectCompanySortBrach(userId, yearDate));
            	}else{
            		allDto.setSortNum(sdto.getSaleHead());
            		allDto.setCompanyList(this.htyFctOrgIncomeDTOService.selectCompanySortHead(yearDate));
            	}
        	}else if(3 == type || 4 == type){
        		HtyFctOrgSaleDTO htyFctOrgSaleDTO = this.htyFctOrgSaleDTOService.selectByOrgCode(userId);
            	allDto.setCompanyNow(htyFctOrgSaleDTO.getYearAmt());
            	HtyFctOrgSortDTO sdto = this.htyFctOrgSaleDTOService.selectSort(userId, yearDate);
            	allDto.setHeadAvg(this.htyFctOrgSaleDTOService.selectAvgHead(yearDate));
            	allDto.setBrachAvg(this.htyFctOrgSaleDTOService.selectAvgBrach(userId, yearDate));
            	if(3 == type){
            		allDto.setSortNum(sdto.getSaleBrach());
            		allDto.setCompanyList(this.htyFctOrgSaleDTOService.selectCompanySortBrach(userId, yearDate));
            	}else{
            		allDto.setSortNum(sdto.getSaleHead());
            		allDto.setCompanyList(this.htyFctOrgSaleDTOService.selectCompanySortHead(yearDate));
            	}
        	}else if(5 == type || 6 == type){
        		HtyFctOrgCustDTO htyFctOrgIncomeDTO = this.htyFctOrgCustDTOService.selectByOrgCode(userId);
            	allDto.setCompanyNow(new BigDecimal(htyFctOrgIncomeDTO.getYearNewcustnum()));
            	HtyFctOrgSortDTO sdto = this.htyFctOrgCustDTOService.selectSort(userId, yearDate);
            	allDto.setHeadAvg(new BigDecimal(this.htyFctOrgCustDTOService.selectAvgHead(yearDate)));
            	allDto.setBrachAvg(new BigDecimal(this.htyFctOrgCustDTOService.selectAvgBrach(userId, yearDate)));
            	if(5 == type){
            		allDto.setSortNum(sdto.getSaleBrach());
            		allDto.setCompanyList(this.htyFctOrgCustDTOService.selectCompanySortBrach(userId, yearDate));
            	}else{
            		allDto.setSortNum(sdto.getSaleHead());
            		allDto.setCompanyList(this.htyFctOrgCustDTOService.selectCompanySortHead(yearDate));
            	}
        	}
            result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("首页弹框错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页金额弹框
     * @param userId
     * @return
     */
    @RequestMapping("/index/boxSale")
    public RestResult indexForBoxSale(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForBoxSale)首页金额弹框获取入参，userId="+userId);
        try {
        	HtyFctOrgSaleAvgDTO allDto = new HtyFctOrgSaleAvgDTO();
        	HtyFctOrgValueDTO dto = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
        	String yearDate = dto.getYearmon();
        	HtyFctOrgSaleDTO htyFctOrgSaleDTO = this.htyFctOrgSaleDTOService.selectByOrgCode(userId);
        	allDto.setSalePrice(htyFctOrgSaleDTO.getYearAmt());
        	HtyFctOrgSortDTO sdto = this.htyFctOrgSaleDTOService.selectSort(userId, yearDate);
        	allDto.setHeadSort(sdto.getSaleHead());
        	allDto.setBrachSort(sdto.getSaleBrach());
        	allDto.setHeadAvgPrice(this.htyFctOrgSaleDTOService.selectAvgHead(yearDate));
        	allDto.setBrachAvgPrice(this.htyFctOrgSaleDTOService.selectAvgBrach(userId, yearDate));
        	allDto.setHeadCompany(this.htyFctOrgSaleDTOService.selectCompanySortHead(yearDate));
        	allDto.setBrachCompany(this.htyFctOrgSaleDTOService.selectCompanySortBrach(userId, yearDate));
            result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("首页金额弹框错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页经营弹框
     * @param userId
     * @return
     */
    @RequestMapping("/index/boxBusiness")
    public RestResult indexForBoxBusiness(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForBoxBusiness)首页经营弹框获取入参，userId="+userId);
        try {
        	HtyFctOrgBusinessAvgDTO allDto = new HtyFctOrgBusinessAvgDTO();
        	HtyFctOrgValueDTO dto = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
        	String yearDate = dto.getYearmon();
        	HtyFctOrgIncomeDTO htyFctOrgIncomeDTO = this.htyFctOrgIncomeDTOService.selectByOrgCode(userId);
        	allDto.setBusinessIncome(htyFctOrgIncomeDTO.getYearBusincomeAmt());
        	HtyFctOrgSortDTO sdto = this.htyFctOrgIncomeDTOService.selectSort(userId, yearDate);
        	allDto.setHeadSort(sdto.getSaleHead());
        	allDto.setBrachSort(sdto.getSaleBrach());
        	allDto.setHeadAvgIncome(this.htyFctOrgIncomeDTOService.selectAvgHead(yearDate));
        	allDto.setBrachAvgIncome(this.htyFctOrgIncomeDTOService.selectAvgBrach(userId, yearDate));
        	allDto.setHeadCompany(this.htyFctOrgIncomeDTOService.selectCompanySortHead(yearDate));
        	allDto.setBrachCompany(this.htyFctOrgIncomeDTOService.selectCompanySortBrach(userId, yearDate));
            result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("首页经营弹框错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
    
    /**
     * 首页会员弹框
     * @param userId
     * @return
     */
    @RequestMapping("/index/boxMember")
    public RestResult indexForBoxMember(@RequestParam(value = "userId", required = true) String userId) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForBoxMember)首页会员弹框获取入参，userId="+userId);
        try {
        	HtyFctOrgMemberAvgDTO allDto = new HtyFctOrgMemberAvgDTO();
        	HtyFctOrgValueDTO dto = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
        	String yearDate = dto.getYearmon();
        	HtyFctOrgCustDTO htyFctOrgIncomeDTO = this.htyFctOrgCustDTOService.selectByOrgCode(userId);
        	allDto.setMemberNum(htyFctOrgIncomeDTO.getYearNewcustnum());
        	HtyFctOrgSortDTO sdto = this.htyFctOrgCustDTOService.selectSort(userId, yearDate);
        	allDto.setHeadSort(sdto.getSaleHead());
        	allDto.setBrachSort(sdto.getSaleBrach());
        	allDto.setHeadAvgNum(this.htyFctOrgCustDTOService.selectAvgHead(yearDate));
        	allDto.setBrachAvgNum(this.htyFctOrgCustDTOService.selectAvgBrach(userId, yearDate));
        	allDto.setHeadCompany(this.htyFctOrgCustDTOService.selectCompanySortHead(yearDate));
        	allDto.setBrachCompany(this.htyFctOrgCustDTOService.selectCompanySortBrach(userId, yearDate));
            result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("首页会员弹框错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
}
