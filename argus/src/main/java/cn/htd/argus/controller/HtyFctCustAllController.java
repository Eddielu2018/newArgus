package cn.htd.argus.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.bean.HtyFctCustAllOutDTO;
import cn.htd.argus.bean.HtyFctCustAnalysisInOutDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.bean.HtyFctOrgMemberBannerDTO;
import cn.htd.argus.bean.HtyFctOrgMemberMothOutDTO;
import cn.htd.argus.dto.HtyFctCustAllDto;
import cn.htd.argus.dto.HtyFctOrgMemberDetailDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.DciDimOrgDTOService;
import cn.htd.argus.service.HtyFctCustAllDTOService;
import cn.htd.argus.service.HtyFctOrgMemberDetailDTOService;
import cn.htd.argus.util.DateTimeUtil;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.HtyFctCustUtil;
import cn.htd.argus.util.MathUtil;
import cn.htd.argus.util.RestResult;

/**
 * Created by qj on 2017/10/25.
 */
@RestController
@RequestMapping("/htycustall")
public class HtyFctCustAllController {
	Logger logger = LoggerFactory.getLogger(HtyFctCustAllController.class);
	
	@Autowired
    private HtyFctCustAllDTOService htyFctCustAllDTOService;
	@Autowired
	private DciDimOrgDTOService dciDimOrgDTOService;
	@Autowired
	private HtyFctOrgMemberDetailDTOService htyFctOrgMemberDetailDTOService;
	
	@RequestMapping("/cust/kind")
    public RestResult indexForCustKind(@RequestParam(value = "userId", required = true) String userId,
    		@RequestParam(value = "type", required = true) Integer type,
    		@RequestParam(value = "custStartTime", required = false) String custStartTime,
    		@RequestParam(value = "custEndTime", required = false) String custEndTime,
    		@RequestParam(value = "pairFirstTime", required = false) String pairFirstTime,
    		@RequestParam(value = "pairSecondTime", required = false) String pairSecondTime,
    		@RequestParam(value = "dimension", required = false) Integer dimension,
    		@RequestParam(value = "searchStartTime", required = false) String searchStartTime,
    		@RequestParam(value = "searchEndTime", required = false) String searchEndTime,
    		@RequestParam(value = "pairFirstDimension", required = false) Integer pairFirstDimension,
    		@RequestParam(value = "pairSecondDimension", required = false) Integer pairSecondDimension
    		){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForCustKind)用户分类页获取入参，userId="+userId);
        try {
        	HtyFctCustAllOutDTO allDto = new HtyFctCustAllOutDTO();
        	int step = 1;
        	if(type == 0){
        		searchStartTime = custStartTime;
        		searchEndTime = custEndTime;
        		custStartTime = null;
        		custEndTime = null;
        	}
        	if((searchStartTime != null && !"".equals(searchStartTime)) && (searchEndTime != null && !"".equals(searchEndTime))){
        		step = DateTimeUtil.getMonthSpace(searchStartTime,searchEndTime);
        	}
        	allDto = setString(allDto,step);
        	HtyFctCustInDto inDto = new HtyFctCustInDto();
        	HtyFctCustInDto inPairDto = new HtyFctCustInDto();
        	inDto.setUserId(userId);
        	inPairDto.setUserId(userId);
        	if(custStartTime != null && !"".equals(custStartTime)){
        		inDto.setCustStartTime(custStartTime);
        		inPairDto.setCustStartTime(custStartTime);
        	}
        	if(type == 0){
        		String today = DateTimeUtil.getTodayChar6();
        		if(searchStartTime != null && !"".equals(searchStartTime) && searchEndTime != null && !"".equals(searchEndTime)){
        			inDto.setSearchStartTime(searchStartTime);
        			inDto.setSearchEndTime(searchEndTime);
        		}else{
        			inDto.setSearchStartTime(today);
        			inDto.setSearchEndTime(today);
        		}
        	}
        	if(custEndTime != null && !"".equals(custEndTime)){
        		inDto.setCustEndTime(custEndTime);
        		inPairDto.setCustEndTime(custEndTime);
        	}
        	if(pairFirstTime != null && !"".equals(pairFirstTime)){
        		inDto.setFirstTime(pairFirstTime);
        	}
        	if(pairSecondTime != null && !"".equals(pairSecondTime)){
        		inPairDto.setFirstTime(pairSecondTime);
        	}
        	if((dimension != null && !"".equals(dimension)) && (pairFirstDimension != null && 
        			!"".equals(pairFirstDimension)) && (pairSecondDimension != null && !"".equals(pairSecondDimension))){
        		inDto.setDimension(dimension);
        		inPairDto.setDimension(dimension);
        		inDto.setKind(pairFirstDimension);
        		inPairDto.setKind(pairSecondDimension);
        		Integer[] temp1 = setSqlStep(dimension,pairFirstDimension);
        		inDto.setStart(Integer.valueOf(temp1[0]));
        		inDto.setEnd(Integer.valueOf(temp1[1]));
        		Integer[] temp2 = setSqlStep(dimension,pairSecondDimension);
        		inPairDto.setStart(Integer.valueOf(temp2[0]));
        		inPairDto.setEnd(Integer.valueOf(temp2[1]));
        		inDto.setSearchStartTime(searchStartTime);
        		inDto.setSearchEndTime(searchEndTime);
        		inPairDto.setSearchStartTime(searchStartTime);
        		inPairDto.setSearchEndTime(searchEndTime);
        	}
        	List<HtyFctCustAllDto> firstList = null;
        	if(type == 2){
        		Integer temp = htyFctCustAllDTOService.selectByForDimensionNum(inDto);
        		if(temp != null && temp >0){
        			firstList = htyFctCustAllDTOService.selectByForDimension(inDto);
        		}
        	}else{
        		firstList = htyFctCustAllDTOService.selectByNoPair(inDto);
        	}
        	if(firstList != null && firstList.size()>0){
        		allDto = setNum(allDto,firstList,step);
        	}
        	List<HtyFctCustAllDto> secondList = null;
        	if(type != 0){
        		//有对比
        		if(type == 2){
        			Integer temp = htyFctCustAllDTOService.selectByForDimensionNum(inPairDto);
            		if(temp != null && temp >0){
            			secondList = htyFctCustAllDTOService.selectByForDimension(inPairDto);
            		}
        		}else{
        			secondList = htyFctCustAllDTOService.selectByNoPair(inPairDto);
            	}
	        	HtyFctCustAllOutDTO pairDto = new HtyFctCustAllOutDTO();
	        	if(secondList != null && secondList.size() >0){
		        	pairDto = setNum(pairDto,secondList,step);
		        	allDto.setChartPair1(pairDto.getChartDate1());
		        	allDto.setChartPair2(pairDto.getChartDate2());
		        	allDto.setChartPair3(pairDto.getChartDate3());
		        	allDto.setChartPair4(pairDto.getChartDate4());
		        	allDto.setChartPair5(pairDto.getChartDate5());
		        	allDto.setChartPair6(pairDto.getChartDate6());
	        	}
        	}
        	result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("用户分类页" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
	}
    		
	private HtyFctCustAllOutDTO setString(HtyFctCustAllOutDTO allDto,int step){
		List<String> chartBottom1 = new ArrayList<String>();
		List<String> chartBottom2 = new ArrayList<String>();
		List<String> chartBottom3 = new ArrayList<String>();
		List<String> chartBottom4 = new ArrayList<String>();
		List<String> chartBottom5 = new ArrayList<String>();
		List<String> chartBottom6 = new ArrayList<String>();
		chartBottom1.add("无");
		chartBottom1.add(HtyFctCustUtil.T1_2*step+"以下");
		chartBottom1.add(HtyFctCustUtil.T1_2*step+"~"+HtyFctCustUtil.T1_3*step);
		chartBottom1.add(HtyFctCustUtil.T1_3*step+"~"+HtyFctCustUtil.T1_4*step);
		chartBottom1.add(HtyFctCustUtil.T1_4*step+"~"+HtyFctCustUtil.T1_5*step);
		chartBottom1.add(HtyFctCustUtil.T1_5*step+"以上");
		chartBottom2.add("无");
		chartBottom2.add(HtyFctCustUtil.T2_2*step+"以下");
		chartBottom2.add(HtyFctCustUtil.T2_2*step+"~"+HtyFctCustUtil.T2_3*step);
		chartBottom2.add(HtyFctCustUtil.T2_3*step+"~"+HtyFctCustUtil.T2_4*step);
		chartBottom2.add(HtyFctCustUtil.T2_4*step+"~"+HtyFctCustUtil.T2_5*step);
		chartBottom2.add(HtyFctCustUtil.T2_5*step+"以上");
		chartBottom3.add("无");
		chartBottom3.add(HtyFctCustUtil.T3_2*step+"以下");
		chartBottom3.add(HtyFctCustUtil.T3_2*step+"~"+HtyFctCustUtil.T3_3*step);
		chartBottom3.add(HtyFctCustUtil.T3_3*step+"~"+HtyFctCustUtil.T3_4*step);
		chartBottom3.add(HtyFctCustUtil.T3_4*step+"~"+HtyFctCustUtil.T3_5*step);
		chartBottom3.add(HtyFctCustUtil.T3_5*step+"以上");
		chartBottom4.add("无");
		chartBottom4.add(HtyFctCustUtil.T4_2*step+"以下");
		chartBottom4.add(HtyFctCustUtil.T4_2*step+"~"+HtyFctCustUtil.T4_3*step);
		chartBottom4.add(HtyFctCustUtil.T4_3*step+"~"+HtyFctCustUtil.T4_4*step);
		chartBottom4.add(HtyFctCustUtil.T4_4*step+"~"+HtyFctCustUtil.T4_5*step);
		chartBottom4.add(HtyFctCustUtil.T4_5*step+"以上");
		chartBottom5.add("无");
		chartBottom5.add(HtyFctCustUtil.T5_2*step+"以下");
		chartBottom5.add(HtyFctCustUtil.T5_2*step+"~"+HtyFctCustUtil.T5_3*step);
		chartBottom5.add(HtyFctCustUtil.T5_3*step+"~"+HtyFctCustUtil.T5_4*step);
		chartBottom5.add(HtyFctCustUtil.T5_4*step+"~"+HtyFctCustUtil.T5_5*step);
		chartBottom5.add(HtyFctCustUtil.T5_5*step+"以上");
		chartBottom6.add("无");
		chartBottom6.add(HtyFctCustUtil.T6_2*step+"以下");
		chartBottom6.add(HtyFctCustUtil.T6_2*step+"~"+HtyFctCustUtil.T6_3*step);
		chartBottom6.add(HtyFctCustUtil.T6_3*step+"~"+HtyFctCustUtil.T6_4*step);
		chartBottom6.add(HtyFctCustUtil.T6_4*step+"~"+HtyFctCustUtil.T6_5*step);
		chartBottom6.add(HtyFctCustUtil.T6_5*step+"以上");
		allDto.setChartBottom1(chartBottom1);
		allDto.setChartBottom2(chartBottom2);
		allDto.setChartBottom3(chartBottom3);
		allDto.setChartBottom4(chartBottom4);
		allDto.setChartBottom5(chartBottom5);
		allDto.setChartBottom6(chartBottom6);
		return allDto;
	}
	
	private HtyFctCustAllOutDTO setNum(HtyFctCustAllOutDTO allDto,List<HtyFctCustAllDto> list,int step){
		int T1_1 = 0;
    	int T1_2 = 0;
    	int T1_3 = 0;
    	int T1_4 = 0;
    	int T1_5 = 0;
    	int T1_6 = 0;
    	int T2_1 = 0;
    	int T2_2 = 0;
    	int T2_3 = 0;
    	int T2_4 = 0;
    	int T2_5 = 0;
    	int T2_6 = 0;
    	int T3_1 = 0;
    	int T3_2 = 0;
    	int T3_3 = 0;
    	int T3_4 = 0;
    	int T3_5 = 0;
    	int T3_6 = 0;
    	int T4_1 = 0;
    	int T4_2 = 0;
    	int T4_3 = 0;
    	int T4_4 = 0;
    	int T4_5 = 0;
    	int T4_6 = 0;
    	int T5_1 = 0;
    	int T5_2 = 0;
    	int T5_3 = 0;
    	int T5_4 = 0;
    	int T5_5 = 0;
    	int T5_6 = 0;
    	int T6_1 = 0;
    	int T6_2 = 0;
    	int T6_3 = 0;
    	int T6_4 = 0;
    	int T6_5 = 0;
    	int T6_6 = 0;
    	List<String> chartDate1 = new ArrayList<String>();
    	List<String> chartDate2 = new ArrayList<String>();
    	List<String> chartDate3 = new ArrayList<String>();
    	List<String> chartDate4 = new ArrayList<String>();
    	List<String> chartDate5 = new ArrayList<String>();
    	List<String> chartDate6 = new ArrayList<String>();
    	for(HtyFctCustAllDto dto : list){
    		//整体采购
    		if(dto.getAmtAll() != null){
	    		Double t1 = dto.getAmtAll().doubleValue()/(10000);
	    		if(t1 <= HtyFctCustUtil.T1_1){
	    			T1_1++;
	    		}else if(t1 > HtyFctCustUtil.T1_1 && t1 <= HtyFctCustUtil.T1_2*step){
	    			T1_2++;
	    		}else if(t1 > HtyFctCustUtil.T1_2*step && t1 <= HtyFctCustUtil.T1_3*step){
	    			T1_3++;
	    		}else if(t1 > HtyFctCustUtil.T1_3*step && t1 <= HtyFctCustUtil.T1_4*step){
	    			T1_4++;
	    		}else if(t1 > HtyFctCustUtil.T1_4*step && t1 <= HtyFctCustUtil.T1_5*step){
	    			T1_5++;
	    		}else if(t1 > HtyFctCustUtil.T1_5*step){
	    			T1_6++;
	    		}
    		}else{
    			T1_1++;
    		}
    		//线上采购
    		if(dto.getAmtOnline() != null){
	    		Double t2 = dto.getAmtOnline().doubleValue()/(10000);
	    		if(t2 <= HtyFctCustUtil.T2_1){
	    			T2_1++;
	    		}else if(t2 > HtyFctCustUtil.T2_1 && t2 <= HtyFctCustUtil.T2_2*step){
	    			T2_2++;
	    		}else if(t2 > HtyFctCustUtil.T2_2*step && t2 <= HtyFctCustUtil.T2_3*step){
	    			T2_3++;
	    		}else if(t2 > HtyFctCustUtil.T2_3*step && t2 <= HtyFctCustUtil.T2_4*step){
	    			T2_4++;
	    		}else if(t2 > HtyFctCustUtil.T2_4*step && t2 <= HtyFctCustUtil.T2_5*step){
	    			T2_5++;
	    		}else if(t2 > HtyFctCustUtil.T2_5*step){
	    			T2_6++;
	    		}
    		}else{
    			T2_1++;
    		}
    		//商城登录次数
    		if(dto.getQtyB2b() != null){
	    		Integer t3 = dto.getQtyB2b().intValue();
	    		if(t3 <= HtyFctCustUtil.T3_1){
	    			T3_1++;
	    		}else if(t3 > HtyFctCustUtil.T3_1 && t3 <= HtyFctCustUtil.T3_2*step){
	    			T3_2++;
	    		}else if(t3 > HtyFctCustUtil.T3_2*step && t3 <= HtyFctCustUtil.T3_3*step){
	    			T3_3++;
	    		}else if(t3 > HtyFctCustUtil.T3_3*step && t3 <= HtyFctCustUtil.T3_4*step){
	    			T3_4++;
	    		}else if(t3 > HtyFctCustUtil.T3_4*step && t3 <= HtyFctCustUtil.T3_5*step){
	    			T3_5++;
	    		}else if(t3 > HtyFctCustUtil.T3_5*step){
	    			T3_6++;
	    		}
    		}else{
    			T3_1++;
    		}
    		//超级老板登录次数
    		if(dto.getQtyBoss() != null){
	    		Integer t4 = dto.getQtyBoss().intValue();
	    		if(t4 <= HtyFctCustUtil.T4_1){
	    			T4_1++;
	    		}else if(t4 > HtyFctCustUtil.T4_1 && t4 <= HtyFctCustUtil.T4_2*step){
	    			T4_2++;
	    		}else if(t4 > HtyFctCustUtil.T4_2*step && t4 <= HtyFctCustUtil.T4_3*step){
	    			T4_3++;
	    		}else if(t4 > HtyFctCustUtil.T4_3*step && t4 <= HtyFctCustUtil.T4_4*step){
	    			T4_4++;
	    		}else if(t4 > HtyFctCustUtil.T4_4*step && t4 <= HtyFctCustUtil.T4_5*step){
	    			T4_5++;
	    		}else if(t4 > HtyFctCustUtil.T4_5*step){
	    			T4_6++;
	    		}
    		}else{
    			T4_1++;
    		}
    		//上架商品数
    		if(dto.getQtyHzg() != null){
	    		Integer t5 = dto.getQtyHzg().intValue();
	    		if(t5 <= HtyFctCustUtil.T5_1){
	    			T5_1++;
	    		}else if(t5 > HtyFctCustUtil.T5_1 && t5 <= HtyFctCustUtil.T5_2*step){
	    			T5_2++;
	    		}else if(t5 > HtyFctCustUtil.T5_2*step && t5 <= HtyFctCustUtil.T5_3*step){
	    			T5_3++;
	    		}else if(t5 > HtyFctCustUtil.T5_3*step && t5 <= HtyFctCustUtil.T5_4*step){
	    			T5_4++;
	    		}else if(t5 > HtyFctCustUtil.T5_4*step && t5 <= HtyFctCustUtil.T5_5*step){
	    			T5_5++;
	    		}else if(t5 > HtyFctCustUtil.T5_5*step){
	    			T5_6++;
	    		}
    		}else{
    			T5_1++;
    		}
    		//贷款金额
    		if(dto.getAmtDk() != null){
	    		Double t6 = dto.getAmtDk().doubleValue()/(10000);
	    		if(t6 <= HtyFctCustUtil.T6_1){
	    			T6_1++;
	    		}else if(t6 > HtyFctCustUtil.T6_1 && t6 <= HtyFctCustUtil.T6_2*step){
	    			T6_2++;
	    		}else if(t6 > HtyFctCustUtil.T6_2*step && t6 <= HtyFctCustUtil.T6_3*step){
	    			T6_3++;
	    		}else if(t6 > HtyFctCustUtil.T6_3*step && t6 <= HtyFctCustUtil.T6_4*step){
	    			T6_4++;
	    		}else if(t6 > HtyFctCustUtil.T6_4*step && t6 <= HtyFctCustUtil.T6_5*step){
	    			T6_5++;
	    		}else if(t6 > HtyFctCustUtil.T6_5*step){
	    			T6_6++;
	    		}
    		}else{
    			T6_1++;
    		}
    	}
    	chartDate1.add(String.valueOf(T1_1));
    	chartDate1.add(String.valueOf(T1_2));
    	chartDate1.add(String.valueOf(T1_3));
    	chartDate1.add(String.valueOf(T1_4));
    	chartDate1.add(String.valueOf(T1_5));
    	chartDate1.add(String.valueOf(T1_6));
    	chartDate2.add(String.valueOf(T2_1));
    	chartDate2.add(String.valueOf(T2_2));
    	chartDate2.add(String.valueOf(T2_3));
    	chartDate2.add(String.valueOf(T2_4));
    	chartDate2.add(String.valueOf(T2_5));
    	chartDate2.add(String.valueOf(T2_6));
    	chartDate3.add(String.valueOf(T3_1));
    	chartDate3.add(String.valueOf(T3_2));
    	chartDate3.add(String.valueOf(T3_3));
    	chartDate3.add(String.valueOf(T3_4));
    	chartDate3.add(String.valueOf(T3_5));
    	chartDate3.add(String.valueOf(T3_6));
    	chartDate4.add(String.valueOf(T4_1));
    	chartDate4.add(String.valueOf(T4_2));
    	chartDate4.add(String.valueOf(T4_3));
    	chartDate4.add(String.valueOf(T4_4));
    	chartDate4.add(String.valueOf(T4_5));
    	chartDate4.add(String.valueOf(T4_6));
    	chartDate5.add(String.valueOf(T5_1));
    	chartDate5.add(String.valueOf(T5_2));
    	chartDate5.add(String.valueOf(T5_3));
    	chartDate5.add(String.valueOf(T5_4));
    	chartDate5.add(String.valueOf(T5_5));
    	chartDate5.add(String.valueOf(T5_6));
    	chartDate6.add(String.valueOf(T6_1));
    	chartDate6.add(String.valueOf(T6_2));
    	chartDate6.add(String.valueOf(T6_3));
    	chartDate6.add(String.valueOf(T6_4));
    	chartDate6.add(String.valueOf(T6_5));
    	chartDate6.add(String.valueOf(T6_6));
    	allDto.setChartDate1(chartDate1);
    	allDto.setChartDate2(chartDate2);
    	allDto.setChartDate3(chartDate3);
    	allDto.setChartDate4(chartDate4);
    	allDto.setChartDate5(chartDate5);
    	allDto.setChartDate6(chartDate6);
		return allDto;
	}
	
	private Integer[] setSqlStep(Integer dimension,Integer pair){
		Integer[] intNum = {0,0};
		if(0 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T1_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T1_1;
				intNum[1] = HtyFctCustUtil.T1_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T1_2;
				intNum[1] = HtyFctCustUtil.T1_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T1_3;
				intNum[1] = HtyFctCustUtil.T1_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T1_4;
				intNum[1] = HtyFctCustUtil.T1_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T1_5;
			}
		}else if(1 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T2_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T2_1;
				intNum[1] = HtyFctCustUtil.T2_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T2_2;
				intNum[1] = HtyFctCustUtil.T2_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T2_3;
				intNum[1] = HtyFctCustUtil.T2_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T2_4;
				intNum[1] = HtyFctCustUtil.T2_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T2_5;
			}
		}else if(2 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T3_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T3_1;
				intNum[1] = HtyFctCustUtil.T3_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T3_2;
				intNum[1] = HtyFctCustUtil.T3_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T3_3;
				intNum[1] = HtyFctCustUtil.T3_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T3_4;
				intNum[1] = HtyFctCustUtil.T3_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T3_5;
			}
		}else if(3 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T4_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T4_1;
				intNum[1] = HtyFctCustUtil.T4_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T4_2;
				intNum[1] = HtyFctCustUtil.T4_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T4_3;
				intNum[1] = HtyFctCustUtil.T4_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T4_4;
				intNum[1] = HtyFctCustUtil.T4_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T4_5;
			}
		}else if(4 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T5_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T5_1;
				intNum[1] = HtyFctCustUtil.T5_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T5_2;
				intNum[1] = HtyFctCustUtil.T5_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T5_3;
				intNum[1] = HtyFctCustUtil.T5_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T5_4;
				intNum[1] = HtyFctCustUtil.T5_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T5_5;
			}
		}else if(5 == dimension){
			if(pair == 0){
				intNum[0] = HtyFctCustUtil.T6_1;
			}else if(pair == 1){
				intNum[0] = HtyFctCustUtil.T6_1;
				intNum[1] = HtyFctCustUtil.T6_2;
			}else if(pair == 2){
				intNum[0] = HtyFctCustUtil.T6_2;
				intNum[1] = HtyFctCustUtil.T6_3;
			}else if(pair == 3){
				intNum[0] = HtyFctCustUtil.T6_3;
				intNum[1] = HtyFctCustUtil.T6_4;
			}else if(pair == 4){
				intNum[0] = HtyFctCustUtil.T6_4;
				intNum[1] = HtyFctCustUtil.T6_5;
			}else if(pair == 5){
				intNum[1] = HtyFctCustUtil.T6_5;
			}
		}
		return intNum;
	}
	
	@RequestMapping("/cust/step")
    public RestResult indexForCustStep(@RequestParam(value = "dimension", required = false) Integer dimension,
    		@RequestParam(value = "searchStartTime", required = false) String searchStartTime,
    		@RequestParam(value = "searchEndTime", required = false) String searchEndTime){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForCustStep)用户维度");
        try {
        	int step = 1;
        	if(searchStartTime != null && searchEndTime != null){
        		step = DateTimeUtil.getMonthSpace(searchStartTime,searchEndTime);
        	}
        	List<String> list = new ArrayList<String>();
        	HtyFctCustAllOutDTO allDto = new HtyFctCustAllOutDTO();
        	allDto = setString(allDto,step);
        	if(0 == dimension){
        		list.add(allDto.getChartBottom1().get(0));
        		list.add(allDto.getChartBottom1().get(1));
        		list.add(allDto.getChartBottom1().get(2));
        		list.add(allDto.getChartBottom1().get(3));
        		list.add(allDto.getChartBottom1().get(4));
        		list.add(allDto.getChartBottom1().get(5));
        	}else if(1 == dimension){
        		list.add(allDto.getChartBottom2().get(0));
        		list.add(allDto.getChartBottom2().get(1));
        		list.add(allDto.getChartBottom2().get(2));
        		list.add(allDto.getChartBottom2().get(3));
        		list.add(allDto.getChartBottom2().get(4));
        		list.add(allDto.getChartBottom2().get(5));
        	}else if(2 == dimension){
        		list.add(allDto.getChartBottom3().get(0));
        		list.add(allDto.getChartBottom3().get(1));
        		list.add(allDto.getChartBottom3().get(2));
        		list.add(allDto.getChartBottom3().get(3));
        		list.add(allDto.getChartBottom3().get(4));
        		list.add(allDto.getChartBottom3().get(5));
        	}else if(3 == dimension){
        		list.add(allDto.getChartBottom4().get(0));
        		list.add(allDto.getChartBottom4().get(1));
        		list.add(allDto.getChartBottom4().get(2));
        		list.add(allDto.getChartBottom4().get(3));
        		list.add(allDto.getChartBottom4().get(4));
        		list.add(allDto.getChartBottom4().get(5));
        	}else if(4 == dimension){
        		list.add(allDto.getChartBottom5().get(0));
        		list.add(allDto.getChartBottom5().get(1));
        		list.add(allDto.getChartBottom5().get(2));
        		list.add(allDto.getChartBottom5().get(3));
        		list.add(allDto.getChartBottom5().get(4));
        		list.add(allDto.getChartBottom5().get(5));
        	}else if(5 == dimension){
        		list.add(allDto.getChartBottom6().get(0));
        		list.add(allDto.getChartBottom6().get(1));
        		list.add(allDto.getChartBottom6().get(2));
        		list.add(allDto.getChartBottom6().get(3));
        		list.add(allDto.getChartBottom6().get(4));
        		list.add(allDto.getChartBottom6().get(5));
        	}
        	result.setData(list);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("用户维度" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
	}
	
	@RequestMapping("/cust/Analysis")
    public RestResult indexForAnalysis(@RequestParam(value = "userId", required = true) String userId,
    		@RequestParam(value = "startTime", required = false) String startTime,
    		@RequestParam(value = "endTime", required = false) String endTime,
    		@RequestParam(value = "type", required = true) int type,
    		@RequestParam(value = "bossType", required = true) int bossType){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForAnalysis)用户分析");
        try {
        	HtyFctCustAnalysisInOutDTO custAllDto = new HtyFctCustAnalysisInOutDTO();
        	Integer regionOrg = dciDimOrgDTOService.selectRegionNum(userId);
        	//上部数据
        	SimpleDateFormat newDf = new SimpleDateFormat("yyyyMM");
        	String newTime = newDf.format(new Date()); 
        	if(startTime == null || endTime == null){
        		startTime = newTime;
        		endTime = newTime;
        	}
        	HtyFctCustAllDto custUpDto = htyFctCustAllDTOService.selectForAnalysis(userId, startTime, endTime, type,newTime);
        	if(custUpDto != null){
        		if(custUpDto.getAmtAll() != null){
        			custAllDto.setAmtAll(new BigDecimal(MathUtil.getWanDouble(custUpDto.getAmtAll())));
        		}
        		if(custUpDto.getAmtOnline() != null){
        			custAllDto.setAmtOnline(new BigDecimal(MathUtil.getWanDouble(custUpDto.getAmtOnline())));
        		}
        		custAllDto.setQtyB2b(custUpDto.getQtyB2b());
        		custAllDto.setQtyBoss(custUpDto.getQtyBoss());
        		custAllDto.setQtyHzg(custUpDto.getQtyHzg());
        		custAllDto.setAmtDk(custUpDto.getAmtDk());
        		Integer temp1 = htyFctCustAllDTOService.selectForAmtAll(userId, startTime, endTime, type, regionOrg);
        		Integer temp2 = htyFctCustAllDTOService.selectForAmtOnline(userId, startTime, endTime, type, regionOrg);
        		Integer temp3 = htyFctCustAllDTOService.selectForQtyB2b(userId, startTime, endTime, type, regionOrg);
        		Integer temp4 = htyFctCustAllDTOService.selectForQtyBoss(userId, startTime, endTime, type, regionOrg);
        		Integer temp5 = htyFctCustAllDTOService.selectForQtyHzg(userId, startTime, endTime, type, regionOrg);
        		Integer temp6 = htyFctCustAllDTOService.selectForAmtDk(userId, startTime, endTime, type, regionOrg);
        		custAllDto.setAmtAllNum(temp1>99?99:temp1);
        		custAllDto.setAmtOnlineNum(temp2>99?99:temp2);
        		custAllDto.setQtyB2bNum(temp3>99?99:temp3);
        		custAllDto.setQtyBossNum(temp4>99?99:temp4);
        		custAllDto.setQtyHzgNum(temp5>99?99:temp5);
        		custAllDto.setAmtDkNum(temp6>99?99:temp6);
        	}
        	//右下圈
        	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        	Map<String,String> map1 = new HashMap<String,String>();
            Map<String,String> map2 = new HashMap<String,String>();
            Map<String,String> map3 = new HashMap<String,String>();
            Map<String,String> map4 = new HashMap<String,String>();
	        map1.put("name", "超级老板采购");
	        map2.put("name", "商城采购");
	        map4.put("name", "VMS采购");
	        map3.put("name", "线下采购");
	        if(custUpDto != null){
	        	map1.put("value", custUpDto.getAmtOnlineBoss()!=null?custUpDto.getAmtOnlineBoss().toString():"0");
	        	 map2.put("value", custUpDto.getAmtOnlineB2b()!=null?custUpDto.getAmtOnlineB2b().toString():"0");
	        	 map4.put("value", custUpDto.getAmtOnlineVms()!=null?custUpDto.getAmtOnlineVms().toString():"0");
	        	
	        	if(custUpDto.getAmtAll() != null && custUpDto.getAmtOnline() !=null){
	        		map3.put("value", MathUtil.getDouble(custUpDto.getAmtAll().doubleValue()-custUpDto.getAmtOnline().doubleValue()));
	        	}else{
	        		map3.put("value", null);
	        	}
	        }
	        list.add(map1);
	        list.add(map2);
	        list.add(map3);
	        list.add(map4);
        	custAllDto.setMap(list);
        	result.setData(custAllDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
        	logger.error("用户分析" + e);
        	result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
        	result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
     return result;
	}
	
	@RequestMapping("/cust/AnalysisVertical")
    public RestResult indexForAnalysisVertical(@RequestParam(value = "userId", required = true) String userId,
    		@RequestParam(value = "startTime", required = false) String startTime,
    		@RequestParam(value = "endTime", required = false) String endTime,
    		@RequestParam(value = "type", required = true) int type,
    		@RequestParam(value = "bossType", required = true) int bossType){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForAnalysisVertical)用户分析竖图");
        try {
        	HtyFctCustAnalysisInOutDTO custAllDto = new HtyFctCustAnalysisInOutDTO();
        	Integer regionNoOrg = dciDimOrgDTOService.selectRegionNumWithOutCust(userId);
        	SimpleDateFormat newDf = new SimpleDateFormat("yyyyMM");
        	String newTime = newDf.format(new Date()); 
        	if(startTime == null || endTime == null){
        		startTime = newTime;
        		endTime = newTime;
        	}
        	//左下图表
        	int level = 1;
    		if(startTime != null && endTime != null){
    			level = DateTimeUtil.getMonthSpace(startTime,endTime);
    		}
    		int pairTime = DateTimeUtil.getMonthSpace("201704",newTime);
    		if(level > pairTime){
    			level = pairTime;
    		}
        	List<String> listName = new ArrayList<String>();
        	if(bossType == 0){
        		listName.add("无");
        		listName.add(HtyFctCustUtil.S1_1*level+"~"+HtyFctCustUtil.S1_3*level);
        		listName.add(HtyFctCustUtil.S1_3*level+"~"+HtyFctCustUtil.S1_4*level);
        		listName.add(HtyFctCustUtil.S1_4*level+"~"+HtyFctCustUtil.S1_5*level);
        		listName.add(HtyFctCustUtil.S1_5*level+"以上");
        	}else if(bossType == 1){
        		listName.add("无");
        		listName.add(HtyFctCustUtil.S2_1*level+"~"+HtyFctCustUtil.S2_3*level);
        		listName.add(HtyFctCustUtil.S2_3*level+"~"+HtyFctCustUtil.S2_4*level);
        		listName.add(HtyFctCustUtil.S2_4*level+"~"+HtyFctCustUtil.S2_5*level);
        		listName.add(HtyFctCustUtil.S2_5*level+"以上");
        	}
        	List<String> listDate = new ArrayList<String>();
        	List<String> listPair = new ArrayList<String>();
        	List<HtyFctCustAllDto> custList = htyFctCustAllDTOService.selectForPair(userId, startTime, endTime, type);
        	if(custList != null && custList.size()>0){
        		//计算月份差距
        		int my1 = 0;
        		int my2 = 0;
        		int my3 = 0;
        		int my4 = 0;
        		int my5 = 0;
        		int other1 = 0;
        		int other2 = 0;
        		int other3 = 0;
        		int other4 = 0;
        		int other5 = 0;
        		for(HtyFctCustAllDto custDto : custList){
        			String user = custDto.getOrgCode();
        			Integer time = 0;
        			if(bossType == 0){
        				time = custDto.getQtyBoss().intValue();
        				if(custDto.getQtyBoss() != null){
            				if(time <= HtyFctCustUtil.S1_1*level){
            					if(userId.equals(user)){
            						my1++;
            					}else{
            						other1++;
            					}
            				}else if(time > HtyFctCustUtil.S1_1*level && time <= HtyFctCustUtil.S1_3*level){
            					if(userId.equals(user)){
            						my2++;
            					}else{
            						other2++;
            					}
            				}else if(time > HtyFctCustUtil.S1_3*level && time <= HtyFctCustUtil.S1_4*level){
            					if(userId.equals(user)){
            						my3++;
            					}else{
            						other3++;
            					}
            				}else if(time > HtyFctCustUtil.S1_4*level && time <= HtyFctCustUtil.S1_5*level){
            					if(userId.equals(user)){
            						my4++;
            					}else{
            						other4++;
            					}
            				}else if(time > HtyFctCustUtil.S1_5*level){
            					if(userId.equals(user)){
            						my5++;
            					}else{
            						other5++;
            					}
            				}
        				}else{
        					if(userId.equals(user)){
        						my1++;
        					}else{
        						other1++;
        					}
        				}
        			}else if(bossType == 1){
        				time = custDto.getQtyB2b().intValue();
        				if(custDto.getQtyBoss() != null){
            				if(time <= HtyFctCustUtil.S2_1*level){
            					if(userId.equals(user)){
            						my1++;
            					}else{
            						other1++;
            					}
            				}else if(time > HtyFctCustUtil.S2_1*level && time <= HtyFctCustUtil.S2_3*level){
            					if(userId.equals(user)){
            						my2++;
            					}else{
            						other2++;
            					}
            				}else if(time > HtyFctCustUtil.S2_3*level && time <= HtyFctCustUtil.S2_4*level){
            					if(userId.equals(user)){
            						my3++;
            					}else{
            						other3++;
            					}
            				}else if(time > HtyFctCustUtil.S2_4*level && time <= HtyFctCustUtil.S2_5*level){
            					if(userId.equals(user)){
            						my4++;
            					}else{
            						other4++;
            					}
            				}else if(time > HtyFctCustUtil.S2_5*level){
            					if(userId.equals(user)){
            						my5++;
            					}else{
            						other5++;
            					}
            				}
        				}else{
        					if(userId.equals(user)){
        						my1++;
        					}else{
        						other1++;
        					}
        				}
        			}
        		}
        		//分部平均值
        		if(regionNoOrg != null && regionNoOrg != 0){
	    			other1 = other1/regionNoOrg;
	    			other2 = other2/regionNoOrg;
	    			other3 = other3/regionNoOrg;
	    			other4 = other4/regionNoOrg;
	    			other5 = other5/regionNoOrg;
        		}
        		listDate.add(String.valueOf(my1));
        		listDate.add(String.valueOf(my2));
        		listDate.add(String.valueOf(my3));
        		listDate.add(String.valueOf(my4));
        		listDate.add(String.valueOf(my5));
        		listPair.add(String.valueOf(other1));
        		listPair.add(String.valueOf(other2));
        		listPair.add(String.valueOf(other3));
        		listPair.add(String.valueOf(other4));
        		listPair.add(String.valueOf(other5));
        		custAllDto.setListName(listName);
        		custAllDto.setListDate(listDate);
        		custAllDto.setListPair(listPair);
        	}
        	result.setData(custAllDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
        	logger.error("用户分析竖图" + e);
        	result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
        	result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
     return result;
	}
	
	@RequestMapping("/cust/manager")
	public RestResult indexForManager(@RequestParam(value = "userId", required = true) String userId,
		@RequestParam(value = "aliveType", required = true) int aliveType,
		@RequestParam(value = "pageType", required = true) int pageType,
		@RequestParam(value = "time", required = false) String time){
		RestResult result = new RestResult();
	    logger.info("调用(HtyFctCustAllDTOService.indexForManager)用户管理");
	    try {
	        SimpleDateFormat newDf = new SimpleDateFormat("yyyyMM");
	        String newTime = newDf.format(new Date()); 
	        String newYear = DateUtil.dateFormat(newTime, 12);
	        if(time == null ){
	        	time = newTime;
	        }
	        Integer isVip = null;
	        Integer isHy = null;
	        if(pageType == 0){
	        	if(aliveType == 0){
	        		isVip = 0;
	        		isHy = 0;
	        	}else if(aliveType == 1){
	        		isHy = 1;
	        	}
	        }else if(pageType == 1){
	        	if(aliveType == 0){
	        		isVip = 0;
	        		isHy = 1;
	        	}else if(aliveType == 1){
	        		isVip = 1;
	        	}
	        }
	        List<HtyFctCustAllDto> list = null;
	        if(pageType == 0){
	        	//取年
	        	list = htyFctCustAllDTOService.selectForManagerYear(userId, newYear, isHy, isVip,"1",newTime);
	        	List<HtyFctCustAllDto> tempAll = htyFctCustAllDTOService.selectForManagerAll(userId, newTime, isHy, isVip,"1");
	        	if(list != null && tempAll != null && list.size()>0 && tempAll.size()>0){
	        		for(HtyFctCustAllDto dto : list){
	        			for(HtyFctCustAllDto temp : tempAll){
	        				if(dto.getCustCode().equals(temp.getCustCode())){
	        					dto.setQtyB2b(temp.getQtyB2b());
	        					dto.setQtyBoss(temp.getQtyBoss());
	        					dto.setQtyHzg(temp.getQtyHzg());
	        					dto.setQtyFs(temp.getQtyFs());
	        					dto.setAmtDk(temp.getAmtDk());
	        				}
	        			}
	        		}
	        	}
	        }else{
	        	list = htyFctCustAllDTOService.selectForManager(userId, time, isHy, isVip,"1");
	        }
	        if(list != null && list.size()>0){
		        for(HtyFctCustAllDto dto : list){
		        	if(dto.getAmtAll() == null){
		        		dto.setAmtAll(new BigDecimal(0));
		        	}
		        	if(dto.getAmtOnline() == null){
		        		dto.setAmtOnline(new BigDecimal(0));
		        	}
		        }
	        }
	        result.setData(list);
	        result.setCode(ResultCodeEnum.SUCCESS.getCode());
	        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
	    } catch (Exception e) {
	        logger.error("用户管理" + e);
	        result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
	        result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
	    }
	 return result;
	}
	
	@RequestMapping("/cust/month")
	public RestResult indexForMonth(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "sortType", required = true) int sortType,
			@RequestParam(value = "dateTime", required = true) String dateTime){
		RestResult result = new RestResult();
	    logger.info("调用(HtyFctCustAllDTOService.indexForMonth)用户管理月分析");
	    try {
	    	String today = DateTimeUtil.getTodayChar6();
	    	if(dateTime == null){
	    		dateTime = today;
	    	}
	    	//取当月销售量
	    	BigDecimal allAmt = htyFctOrgMemberDetailDTOService.selectSumAmt(userId, dateTime);
	    	//取列表
	    	List<HtyFctOrgMemberDetailDTO> memberList = htyFctOrgMemberDetailDTOService.selectWithName(userId, dateTime, sortType,1);
	    	//解析列表
	    	result.setData(getMothList(memberList,allAmt));
	        result.setCode(ResultCodeEnum.SUCCESS.getCode());
	        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
	    } catch (Exception e) {
	        logger.error("用户管理月分析" + e);
	        result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
	        result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
	    }
	 return result;
	}
	
	@RequestMapping("/cust/banner")
	public RestResult indexForMonthBanner(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "custCode", required = true) String custCode,
			@RequestParam(value = "sortType", required = true) int sortType){
		RestResult result = new RestResult();
	    logger.info("调用(HtyFctCustAllDTOService.indexForMonth)用户管理月分析");
	    try {
	    	HtyFctOrgMemberBannerDTO dto = new HtyFctOrgMemberBannerDTO();
	    	//按当日算6个月前
	    	String today = DateTimeUtil.getTodayChar6();
	    	String sixMonth = DateTimeUtil.getLastMonthChar6ByMonth(-5);
	    	//取当月销售量
	    	BigDecimal allAmt = htyFctOrgMemberDetailDTOService.selectSumAmtSixMonth(userId, sixMonth, today);
	    	//取列表
	    	List<HtyFctOrgMemberDetailDTO> memberList = null;
	    	if(sortType == 0){
	    		memberList = htyFctOrgMemberDetailDTOService.selectSixMonthsAll(userId, sixMonth, today);
	    	}else if(sortType == 1){
	    		memberList = htyFctOrgMemberDetailDTOService.selectSixMonthsFrequency(userId, sixMonth, today);
	    	}else if(sortType == 2){
	    		memberList = htyFctOrgMemberDetailDTOService.selectSixMonthsInterval(userId, sixMonth, today);
	    	}
	    	//单店六月
	    	List<HtyFctOrgMemberDetailDTO> custList = htyFctOrgMemberDetailDTOService.selectSixMonth(custCode, sixMonth, today);
	    	//解析列表
	    	dto.setSortList(getMothListForBanner(memberList,allAmt,sortType));
	    	List<String> listName = new ArrayList<String>();
	    	List<String> listDate = new ArrayList<String>();
	    	if(custList != null && custList.size()>0){
	    		for(HtyFctOrgMemberDetailDTO member: custList){
	    			listName.add(member.getDateKey());
	    			if(sortType == 0){
	    				if(member.getXsAmt() != null){
		    				listDate.add(MathUtil.getWanDouble(member.getXsAmt()));
		    			}
	    			}else if(sortType == 1){
	    				if(member.getXsQty() != null){
	    					listDate.add(String.valueOf(member.getXsQty()));
	    				}
	    			}else if(sortType == 2){
	    				if(member.getXsAmt() != null){
		    				listDate.add(MathUtil.getWanDouble(member.getXsAmt()));
		    			}
	    			}
	    		}
	    	}
	    	dto.setListName(listName);
	    	dto.setListDate(listDate);
	    	result.setData(dto);
	        result.setCode(ResultCodeEnum.SUCCESS.getCode());
	        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
	    } catch (Exception e) {
	        logger.error("用户管理月分析" + e);
	        result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
	        result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
	    }
	 return result;
	}
	
	private List<HtyFctOrgMemberMothOutDTO> getMothList(List<HtyFctOrgMemberDetailDTO> memberList,BigDecimal allAmt) throws ParseException{
		List<HtyFctOrgMemberMothOutDTO> list = new ArrayList<HtyFctOrgMemberMothOutDTO>();
		if(allAmt != null && memberList != null && memberList.size()>0){
    		for(HtyFctOrgMemberDetailDTO member : memberList){
    			HtyFctOrgMemberMothOutDTO dto = new HtyFctOrgMemberMothOutDTO();
    			dto.setCustCode(member.getCustCode());
    			dto.setCustName(member.getCustName());
    			dto.setXsAmt(member.getXsAmt());
    			dto.setXsQty(member.getXsQty().intValue());
    			if(member.getXsAmt() != null && member.getXsAmt().doubleValue()>=0){
    				dto.setSellPoint(String.valueOf(MathUtil.getPairToDouble(member.getXsAmt(), allAmt)));
    			}else{
    				dto.setSellPoint("0");
    			}
	    		dto.setLastDate(member.getLastDate());
	    		if(member.getLastDate() != null){
		    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					Date start = sdf.parse(member.getLastDate());
					dto.setLastTime(DateUtil.daysBetween(start, new Date()));
	    		}else{
	    			dto.setLastTime(null);
	    		}
    			list.add(dto);
    		}
    	}
		return list;
	}
	
	private List<HtyFctOrgMemberMothOutDTO> getMothListForBanner(List<HtyFctOrgMemberDetailDTO> memberList,BigDecimal allAmt,int type) throws ParseException{
		List<HtyFctOrgMemberMothOutDTO> list = new ArrayList<HtyFctOrgMemberMothOutDTO>();
		if(allAmt != null && memberList != null && memberList.size()>0){
    		for(HtyFctOrgMemberDetailDTO member : memberList){
    			HtyFctOrgMemberMothOutDTO dto = new HtyFctOrgMemberMothOutDTO();
    			dto.setCustCode(member.getCustCode());
    			dto.setCustName(member.getCustName());
    			if(type == 0){
    				if(member.getXsAmt() != null){
    					dto.setXsAmt(new BigDecimal(MathUtil.getWanDouble(member.getXsAmt())));
    				}
    				if(member.getXsAmt() != null && member.getXsAmt().doubleValue()>=0){
        				dto.setSellPoint(String.valueOf(MathUtil.getPairToDouble(member.getXsAmt(), allAmt)));
        			}else{
        				dto.setSellPoint("0");
        			}
    			}else if(type == 1){
    				dto.setXsQty(member.getXsQty().intValue());
    			}else if(type == 2){
    				dto.setLastDate(member.getLastDate());
    				if(member.getLastDate() != null){
		    			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
						Date start = sdf.parse(member.getLastDate());
						dto.setLastTime(DateUtil.daysBetween(start, new Date()));
	    			}else{
	    				dto.setLastTime(null);
	    			}
    			}
    			list.add(dto);
    		}
    	}
		return list;
	}
	
	private byte[] indexForMonthExcle(String userId,int sortType,String dateTime){
		logger.info("调用(HtyFctCustAllDTOService.indexForMonthExcle)月度会员导出");
		byte[] content = null;
		//取当月销售量
		BigDecimal allAmt = htyFctOrgMemberDetailDTOService.selectSumAmt(userId, dateTime);
    	//取列表
    	List<HtyFctOrgMemberDetailDTO> memberList = htyFctOrgMemberDetailDTOService.selectWithName(userId, dateTime, sortType,0);
    	try {
			List<HtyFctOrgMemberMothOutDTO> list = getMothList(memberList,allAmt);
			XSSFWorkbook  book = new XSSFWorkbook();
		    XSSFSheet sheet = book.createSheet("sheet1");
		    XSSFRow firstRow = sheet.createRow(0);
		    XSSFCell[] firstCell = null;
		    firstCell = new XSSFCell[6];
		    for(int i = 0 ;i < firstCell.length;i++){
	       		firstCell[i] = firstRow.createCell(i);
	       	}
		    firstCell[0].setCellValue(new XSSFRichTextString("序号"));
		    firstCell[1].setCellValue(new XSSFRichTextString("会员店名称"));
	       	firstCell[2].setCellValue(new XSSFRichTextString("销售额"));
	       	firstCell[3].setCellValue(new XSSFRichTextString("销售额占比"));
	       	firstCell[4].setCellValue(new XSSFRichTextString("最近一次购买日期"));
	       	firstCell[5].setCellValue(new XSSFRichTextString("间隔天数"));
	       	if(list != null && list.size() > 0){
	       		for(int i = 0;i<list.size();i++){
	       			HtyFctOrgMemberMothOutDTO dto = list.get(i);
	       			XSSFRow row = sheet.createRow(i+1);
	        		XSSFCell[] cell = null;
	        		cell = new XSSFCell[9];
        			for(int b = 0 ;b < cell.length;b++){
    	        		cell[b] = row.createCell(b);
    	        	}
        			cell[0].setCellValue(i+1);
        			if(dto.getCustName() == null){
        				cell[1].setCellValue("");
        			}else{
        				cell[1].setCellValue(dto.getCustName());
        			}
        			if(dto.getXsAmt() == null){
        				cell[2].setCellValue("");
        			}else{
        				cell[2].setCellValue(dto.getXsAmt().doubleValue());
        			}
        			if(dto.getSellPoint() == null){
        				cell[3].setCellValue("");
        			}else{
        				cell[3].setCellValue(dto.getSellPoint()+"%");
        			}
        			if(dto.getLastDate() == null){
        				cell[4].setCellValue("");
        			}else{
        				cell[4].setCellValue(dto.getLastDate());
        			}
        			if(dto.getLastTime() == null){
        				cell[5].setCellValue("");
        			}else{
        				cell[5].setCellValue(dto.getLastTime().intValue());
        			}
	       		}
	       	}
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        book.write(os);
	        content = os.toByteArray();
		} catch (Exception e) {
			 logger.error("用户管理" + e);
		}
		return content;
	}
	
	private byte[] indexForManagerExcle(String userId,int aliveType,int pageType,String time,String newTime){
		logger.info("调用(HtyFctCustAllDTOService.indexForManagerExcle)用户管理导出");
		byte[] content = null;
		try {
			List<HtyFctCustAllDto> list = null;
			if(pageType == 0){
	        	//取年
	        	list = htyFctCustAllDTOService.selectForManagerYear(userId, time, aliveType, pageType,"0",newTime);
	        	List<HtyFctCustAllDto> tempAll = htyFctCustAllDTOService.selectForManagerAll(userId, newTime, aliveType, pageType,"0");
	        	if(list != null && tempAll != null && list.size()>0 && tempAll.size()>0){
	        		for(HtyFctCustAllDto dto : list){
	        			for(HtyFctCustAllDto temp : tempAll){
	        				if(dto.getCustCode().equals(temp.getCustCode())){
	        					dto.setQtyB2b(temp.getQtyB2b());
	        					dto.setQtyBoss(temp.getQtyBoss());
	        					dto.setQtyHzg(temp.getQtyHzg());
	        					dto.setQtyFs(temp.getQtyFs());
	        					dto.setAmtDk(temp.getAmtDk());
	        					break;
	        				}
	        			}
	        		}
	        	}
	        }else{
	        	list = htyFctCustAllDTOService.selectForManager(userId, time, aliveType, pageType,"0");
	        }
	        if(list != null && list.size()>0){
		        for(HtyFctCustAllDto dto : list){
		        	if(dto.getAmtAll() == null){
		        		dto.setAmtAll(new BigDecimal(0));
		        	}
		        	if(dto.getAmtOnline() == null){
		        		dto.setAmtOnline(new BigDecimal(0));
		        	}
		        }
	        }
	        XSSFWorkbook  book = new XSSFWorkbook();
	        XSSFSheet sheet = book.createSheet("sheet1");
	        XSSFRow firstRow = sheet.createRow(0);
	        XSSFCell[] firstCell = null;
	        if(pageType == 0){
	        	 firstCell = new XSSFCell[9];
	        	 for(int i = 0 ;i < firstCell.length;i++){
	        		 firstCell[i] = firstRow.createCell(i);
	        	 }
	        	 firstCell[0].setCellValue(new XSSFRichTextString("序号"));
	        	 firstCell[1].setCellValue(new XSSFRichTextString("会员店名称"));
	        	 firstCell[2].setCellValue(new XSSFRichTextString("整体采购（元）"));
	        	 firstCell[3].setCellValue(new XSSFRichTextString("线上采购（元）"));
	        	 firstCell[4].setCellValue(new XSSFRichTextString("商城登录（次）"));
	        	 firstCell[5].setCellValue(new XSSFRichTextString("超级老板登录（次）"));
	        	 firstCell[6].setCellValue(new XSSFRichTextString("商品上架（个）"));
	        	 firstCell[7].setCellValue(new XSSFRichTextString("贷款金额（元）"));
	        	 firstCell[8].setCellValue(new XSSFRichTextString("有效粉丝（个）"));
	        }else {
	        	 firstCell = new XSSFCell[8];
	        	 for(int i = 0 ;i < firstCell.length;i++){
	        		 firstCell[i] = firstRow.createCell(i);
	        	 }
	        	 firstCell[0].setCellValue(new XSSFRichTextString("序号"));
	        	 firstCell[1].setCellValue(new XSSFRichTextString("会员店名称"));
	        	 firstCell[2].setCellValue(new XSSFRichTextString("VIP结束日期"));
	        	 firstCell[3].setCellValue(new XSSFRichTextString("省"));
	        	 firstCell[4].setCellValue(new XSSFRichTextString("市"));
	        	 firstCell[5].setCellValue(new XSSFRichTextString("县"));
	        	 firstCell[6].setCellValue(new XSSFRichTextString("镇"));
	        	 firstCell[7].setCellValue(new XSSFRichTextString("客户经理"));
	        }
	        if(list != null && list.size() > 0){
	        	for(int i = 0;i<list.size();i++){
	        		HtyFctCustAllDto cust = list.get(i);
	        		XSSFRow row = sheet.createRow(i+1);
	        		XSSFCell[] cell = null;
	        		if(pageType == 0){
	        			cell = new XSSFCell[9];
	        			for(int b = 0 ;b < cell.length;b++){
	    	        		cell[b] = row.createCell(b);
	    	        	}
	        			cell[0].setCellValue(i+1);
	        			if(cust.getCustName() == null){
	        				cell[1].setCellValue("");
	        			}else{
	        				cell[1].setCellValue(cust.getCustName());
	        			}
	        			if(cust.getAmtAll() == null){
	        				cell[2].setCellValue("");
	        			}else{
	        				cell[2].setCellValue(cust.getAmtAll().doubleValue());
	        			}
	        			if(cust.getAmtOnline() == null){
	        				cell[3].setCellValue("");
	        			}else{
	        				cell[3].setCellValue(cust.getAmtOnline().doubleValue());
	        			}
	        			if(cust.getQtyB2b() == null){
	        				cell[4].setCellValue("");
	        			}else{
	        				cell[4].setCellValue(cust.getQtyB2b().doubleValue());
	        			}
	        			if(cust.getQtyBoss() == null){
	        				cell[5].setCellValue("");
	        			}else{
	        				cell[5].setCellValue(cust.getQtyBoss().doubleValue());
	        			}
	        			if(cust.getQtyHzg() == null){
	        				cell[6].setCellValue("");
	        			}else{
	        				cell[6].setCellValue(cust.getQtyHzg().doubleValue());
	        			}
	        			if(cust.getAmtDk() == null){
	        				cell[7].setCellValue("");
	        			}else{
	        				cell[7].setCellValue(cust.getAmtDk().doubleValue());
	        			}
	        			if(cust.getQtyFs() == null){
	        				cell[8].setCellValue("");
	        			}else{
	        				cell[8].setCellValue(cust.getQtyFs().doubleValue());
	        			}
	        		}else{
	        			cell = new XSSFCell[8];
	        			for(int b = 0 ;b < cell.length;b++){
	    	        		cell[b] = row.createCell(b);
	    	        	}
	        			cell[0].setCellValue(i+1);
	        			if(cust.getCustName() == null){
	        				cell[1].setCellValue("");
	        			}else{
	        				cell[1].setCellValue(cust.getCustName());
	        			}
	        			if(cust.getExpireTime() == null){
	        				cell[2].setCellValue("");
	        			}else{
	        				cell[2].setCellValue(cust.getExpireTime());
	        			}
	        			if(cust.getAreaProName() == null){
	        				cell[3].setCellValue("");
	        			}else{
	        				cell[3].setCellValue(cust.getAreaProName());
	        			}
	        			if(cust.getAreaCityName() == null){
	        				cell[4].setCellValue("");
	        			}else{
	        				cell[4].setCellValue(cust.getAreaCityName());
	        			}
	        			if(cust.getAreaCountyName() == null){
	        				cell[5].setCellValue("");
	        			}else{
	        				cell[5].setCellValue(cust.getAreaCountyName());
	        			}
	        			if(cust.getAreaTownName() == null){
	        				cell[6].setCellValue("");
	        			}else{
	        				cell[6].setCellValue(cust.getAreaTownName());
	        			}
	        			if(cust.getCustManagerName() == null){
	        				cell[7].setCellValue("");
	        			}else{
	        				cell[7].setCellValue(cust.getCustManagerName());
	        			}
	        		}
	        	}
	        }
	        //把workbook放入inputsteam里
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        book.write(os);
	        content = os.toByteArray();
	    } catch (Exception e) {
	        logger.error("用户管理" + e);
	    }
		return content;
	}

	@RequestMapping("/cust/manager/downLoad")
	public void downLoadManager(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		int aliveType = Integer.valueOf(request.getParameter("aliveType"));
		int pageType = Integer.valueOf(request.getParameter("pageType"));
		SimpleDateFormat newDf = new SimpleDateFormat("yyyyMM");
		String time = request.getParameter("time");
        String newTime = newDf.format(new Date()); 
        String newYear = DateUtil.dateFormat(newTime, 12);
        if(time == null ){
        	time = newTime;
        }
		String filename = "";
		if(pageType == 0){
			filename = "custAlive.xlsx";
		}else{
			filename = "VIPAlive.xlsx";
		}
		Integer isVip = null;
        Integer isHy = null;
        if(pageType == 0){
        	if(aliveType == 0){
        		isVip = 0;
        		isHy = 0;
        	}else if(aliveType == 1){
        		isHy = 1;
        	}
        }else if(pageType == 1){
        	if(aliveType == 0){
        		isVip = 0;
        		isHy = 1;
        	}else if(aliveType == 1){
        		isVip = 1;
        	}
        }
		byte[] buffer = null;
		if(pageType == 0){
			buffer = indexForManagerExcle(userId,isHy,isVip,newYear,newTime);
		}else{
			buffer = indexForManagerExcle(userId,isHy,isVip,time,newTime);
		}
		response.reset();  
		response.addHeader("Content-Disposition", "attachment;filename="  
                + new String(filename.getBytes()));  
		response.addHeader("Content-Length", "" + buffer.length);  
		try {
			OutputStream toClient = new BufferedOutputStream(  
			        response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=uft-8");
			toClient.write(buffer);  
            toClient.flush();  
            toClient.close();  
		} catch (IOException e) {
			logger.error("月度下载" + e);
		} 
	}
	
	@RequestMapping("/cust/month/downLoad")
	public void downLoadMonth(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		int sortType = Integer.valueOf(request.getParameter("sortType"));
		String dateTime = request.getParameter("dateTime");
		String today = DateTimeUtil.getTodayChar6();
    	if(dateTime == null){
    		dateTime = today;
    	}
    	String filename = "custMonth.xlsx";
    	byte[] buffer = indexForMonthExcle(userId,sortType,dateTime);
    	response.reset();  
		response.addHeader("Content-Disposition", "attachment;filename="  
                + new String(filename.getBytes()));  
		response.addHeader("Content-Length", "" + buffer.length);  
		try {
			OutputStream toClient = new BufferedOutputStream(  
			        response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=uft-8");
			toClient.write(buffer);  
            toClient.flush();  
            toClient.close();  
		} catch (IOException e) {
			logger.error("用户管理下载" + e);
		} 
	}
}
