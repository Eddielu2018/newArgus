package cn.htd.argus.controller;

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
	
	@RequestMapping("/cust/kind")
    public RestResult indexForCustKind(@RequestParam(value = "userId", required = true) String userId,
    		@RequestParam(value = "type", required = true) Integer type,
    		@RequestParam(value = "custStartTime", required = false) String custStartTime,
    		@RequestParam(value = "custEndTime", required = false) String custEndTime,
    		@RequestParam(value = "pairFirstTime", required = false) String pairFirstTime,
    		@RequestParam(value = "pairSecondTime", required = false) String pairSecondTime,
    		@RequestParam(value = "dimension", required = false) Integer dimension,
    		@RequestParam(value = "pairFirstDimension", required = false) String pairFirstDimension,
    		@RequestParam(value = "pairSecondDimension", required = false) String pairSecondDimension
    		){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForCustKind)用户分类页获取入参，userId="+userId);
        try {
        	HtyFctCustAllOutDTO allDto = new HtyFctCustAllOutDTO();
        	HtyFctCustAllDto htyFctCustAllDto = new HtyFctCustAllDto();
        	HtyFctCustInDto inDto = new HtyFctCustInDto();
        	inDto.setUserId(userId);
        	if(custStartTime != null){
        		inDto.setCustStartTime(custStartTime+"01");
        	}
        	if(custEndTime != null){
        		inDto.setCustEndTime(custEndTime+"31");
        	}
        	if(pairFirstTime != null){
        		inDto.setPairFirstTime(pairFirstTime);
        	}
        	if(pairSecondTime != null){
        		inDto.setPairSecondTime(pairSecondTime);
        	}
        	if(dimension != null){
        		inDto.setDimension(dimension);
        	}
        	if(pairFirstDimension != null){
        		String temp[] = pairFirstDimension.split(",");
        		inDto.setPairFirstStart(Integer.valueOf(temp[0]));
        		inDto.setPairFirstEnd(Integer.valueOf(temp[1]));
        	}
        	if(pairSecondDimension != null){
        		String temp[] = pairSecondDimension.split(",");
        		inDto.setPairSecondStart(Integer.valueOf(temp[0]));
        		inDto.setPairSecondEnd(Integer.valueOf(temp[1]));
        	}
        	if(type == 0){
        		//无对比
        		htyFctCustAllDto = htyFctCustAllDTOService.selectByNoPair(inDto).get(0);
        	}else if(type == 1){
        		//按时间对比
        		
        	}else if(type == 2){
        		//按维度对比
        		
        		
        	}
        	
        	
//        	HtyFctCustAllDto htyFctCustAllDto = new HtyFctCustAllDto();
//        	htyFctCustAllDto.setOrgCode("8028");
//        	htyFctCustAllDto = htyFctCustAllDTOService.select(htyFctCustAllDto);
//        	if(htyFctCustAllDto != null){
        		result.setData(htyFctCustAllDto);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
//        	}else{
//                result.setCode(ResultCodeEnum.FAIL.getCode());
//                result.setMsg(ResultCodeEnum.FAIL.getMsg());
//            }
        } catch (Exception e) {
            logger.error("用户分类页" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
	}
    		
    		
    		
}
