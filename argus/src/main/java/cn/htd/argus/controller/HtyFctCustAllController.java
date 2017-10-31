package cn.htd.argus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.bean.HtyFctCustAllOutDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.dto.HtyFctCustAllDto;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.HtyFctCustAllDTOService;
import cn.htd.argus.util.DateTimeUtil;
import cn.htd.argus.util.HtyFctCustUtil;
import cn.htd.argus.util.RestResult;

/**
 * 用户分类
 * Created by qj on 2017/10/25.
 */
@RestController
@RequestMapping("/htycustall")
public class HtyFctCustAllController {
	Logger logger = LoggerFactory.getLogger(HtyFctCustAllController.class);
	
	@Autowired
    private HtyFctCustAllDTOService htyFctCustAllDTOService;
	
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
        		inPairDto.setKind(pairFirstDimension);
        		Integer[] temp1 = setSqlStep(dimension,pairFirstDimension);
        		inDto.setStart(Integer.valueOf(temp1[0]));
        		inDto.setEnd(Integer.valueOf(temp1[1]));
        		Integer[] temp2 = setSqlStep(dimension,pairSecondDimension);
        		inPairDto.setStart(Integer.valueOf(temp2[0]));
        		inPairDto.setEnd(Integer.valueOf(temp2[1]));
        	}
        	List<HtyFctCustAllDto> firstList = htyFctCustAllDTOService.selectByNoPair(inDto);
        	allDto = setNum(allDto,firstList);
        	List<HtyFctCustAllDto> secondList = null;
        	if(type != 0){
        		//有对比
	        	secondList = htyFctCustAllDTOService.selectByNoPair(inPairDto);
	        	HtyFctCustAllOutDTO pairDto = new HtyFctCustAllOutDTO();
	        	pairDto = setNum(pairDto,secondList);
	        	allDto.setChartPair1(pairDto.getChartDate1());
	        	allDto.setChartPair2(pairDto.getChartDate2());
	        	allDto.setChartPair3(pairDto.getChartDate3());
	        	allDto.setChartPair4(pairDto.getChartDate4());
	        	allDto.setChartPair5(pairDto.getChartDate5());
	        	allDto.setChartPair6(pairDto.getChartDate6());
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
	
	private HtyFctCustAllOutDTO setNum(HtyFctCustAllOutDTO allDto,List<HtyFctCustAllDto> list){
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
	    		Double t1 = dto.getAmtAll().doubleValue();
	    		if(t1 <= HtyFctCustUtil.T1_1){
	    			T1_1++;
	    		}else if(t1 > HtyFctCustUtil.T1_1 && t1 <= HtyFctCustUtil.T1_2){
	    			T1_2++;
	    		}else if(t1 > HtyFctCustUtil.T1_2 && t1 <= HtyFctCustUtil.T1_3){
	    			T1_3++;
	    		}else if(t1 > HtyFctCustUtil.T1_3 && t1 <= HtyFctCustUtil.T1_4){
	    			T1_4++;
	    		}else if(t1 > HtyFctCustUtil.T1_4 && t1 <= HtyFctCustUtil.T1_5){
	    			T1_5++;
	    		}else if(t1 > HtyFctCustUtil.T1_5){
	    			T1_6++;
	    		}
    		}else{
    			T1_1++;
    		}
    		//线上采购
    		if(dto.getAmtOnline() != null){
	    		Double t2 = dto.getAmtOnline().doubleValue();
	    		if(t2 <= HtyFctCustUtil.T2_1){
	    			T2_1++;
	    		}else if(t2 > HtyFctCustUtil.T2_1 && t2 <= HtyFctCustUtil.T2_2){
	    			T2_2++;
	    		}else if(t2 > HtyFctCustUtil.T2_2 && t2 <= HtyFctCustUtil.T2_3){
	    			T2_3++;
	    		}else if(t2 > HtyFctCustUtil.T2_3 && t2 <= HtyFctCustUtil.T2_4){
	    			T2_4++;
	    		}else if(t2 > HtyFctCustUtil.T2_4 && t2 <= HtyFctCustUtil.T2_5){
	    			T2_5++;
	    		}else if(t2 > HtyFctCustUtil.T2_5){
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
	    		}else if(t3 > HtyFctCustUtil.T3_1 && t3 <= HtyFctCustUtil.T3_2){
	    			T3_2++;
	    		}else if(t3 > HtyFctCustUtil.T3_2 && t3 <= HtyFctCustUtil.T3_3){
	    			T3_3++;
	    		}else if(t3 > HtyFctCustUtil.T3_3 && t3 <= HtyFctCustUtil.T3_4){
	    			T3_4++;
	    		}else if(t3 > HtyFctCustUtil.T3_4 && t3 <= HtyFctCustUtil.T3_5){
	    			T3_5++;
	    		}else if(t3 > HtyFctCustUtil.T3_5){
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
	    		}else if(t4 > HtyFctCustUtil.T4_1 && t4 <= HtyFctCustUtil.T4_2){
	    			T4_2++;
	    		}else if(t4 > HtyFctCustUtil.T4_2 && t4 <= HtyFctCustUtil.T4_3){
	    			T4_3++;
	    		}else if(t4 > HtyFctCustUtil.T4_3 && t4 <= HtyFctCustUtil.T4_4){
	    			T4_4++;
	    		}else if(t4 > HtyFctCustUtil.T4_4 && t4 <= HtyFctCustUtil.T4_5){
	    			T4_5++;
	    		}else if(t4 > HtyFctCustUtil.T4_5){
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
	    		}else if(t5 > HtyFctCustUtil.T5_1 && t5 <= HtyFctCustUtil.T5_2){
	    			T5_2++;
	    		}else if(t5 > HtyFctCustUtil.T5_2 && t5 <= HtyFctCustUtil.T5_3){
	    			T5_3++;
	    		}else if(t5 > HtyFctCustUtil.T5_3 && t5 <= HtyFctCustUtil.T5_4){
	    			T5_4++;
	    		}else if(t5 > HtyFctCustUtil.T5_4 && t5 <= HtyFctCustUtil.T5_5){
	    			T5_5++;
	    		}else if(t5 > HtyFctCustUtil.T5_5){
	    			T5_6++;
	    		}
    		}else{
    			T5_1++;
    		}
    		//贷款金额
    		if(dto.getAmtDk() != null){
	    		Double t6 = dto.getAmtDk().doubleValue();
	    		if(t6 <= HtyFctCustUtil.T6_1){
	    			T6_1++;
	    		}else if(t6 > HtyFctCustUtil.T6_1 && t6 <= HtyFctCustUtil.T6_2){
	    			T6_2++;
	    		}else if(t6 > HtyFctCustUtil.T6_2 && t6 <= HtyFctCustUtil.T6_3){
	    			T6_3++;
	    		}else if(t6 > HtyFctCustUtil.T6_3 && t6 <= HtyFctCustUtil.T6_4){
	    			T6_4++;
	    		}else if(t6 > HtyFctCustUtil.T6_4 && t6 <= HtyFctCustUtil.T6_5){
	    			T6_5++;
	    		}else if(t6 > HtyFctCustUtil.T6_5){
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
}
