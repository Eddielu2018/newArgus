package cn.htd.argus.controller;

import cn.htd.argus.dto.HtyFctMemberOrgDetail;
import cn.htd.argus.service.HtyFctMemberOrgDetailDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.DateTimeUtil;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.HtyFctCustUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.bean.HtyFctCustAllOutDTO;
import cn.htd.argus.bean.HtyFctCustAnalysisInOutDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.dto.HtyFctCustAllDto;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.DciDimOrgDTOService;
import cn.htd.argus.service.HtyFctCustAllDTOService;
import cn.htd.argus.util.RestResult;

import java.math.BigDecimal;
import java.util.*;

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
    private HtyFctMemberOrgDetailDTOService htyFctMemberOrgDetailDTOService;

	@RequestMapping("/cust/kind")
    public RestResult indexForCustKind(@RequestParam(value = "userId", required = true) String userId,//
    		@RequestParam(value ="type", required = true) String type,//
    		@RequestParam(value ="custTime", required = false) String custTime,
            @RequestParam(value ="isHy", required=false) String isHy,
            @RequestParam(value ="isVip", required=false)String isVip,
            @RequestParam(value ="analysisType ",required = false)Integer analysisType,//
            @RequestParam(value ="export",required = false)Integer export,
            @RequestParam(value = "custCode",required =false)String custCode
    		){
		RestResult result = new RestResult();
        logger.info("调用(HtyFctCustAllDTOService.indexForCustKind)用户分类页获取入参，userId="+userId);
        try {

        	HtyFctCustAllOutDTO allDto = new HtyFctCustAllOutDTO();
        	HtyFctCustAllDto htyFctCustAllDto = new HtyFctCustAllDto();
        	HtyFctCustInDto inDto = new HtyFctCustInDto();
            HtyFctMemberOrgDetail htyFctMemberOrgDetail=new HtyFctMemberOrgDetail();
        	inDto.setUserId(userId);
            if(isHy!=null){
                htyFctCustAllDto.setIsHy(isHy);
            }
            if(isVip!=null){
                htyFctCustAllDto.setIsVip(isVip);
            }
            if(custTime!=null){
                htyFctMemberOrgDetail.setDateKey(custTime);
            }
            if (custCode!=null){
                htyFctMemberOrgDetail.setCustCode(custCode);
            }
        	if(type.equals("0")){
        	//活跃会员店分析
                    List<HtyFctCustAllDto> htyFctCustAllDtoList = htyFctCustAllDTOService.queryActiveVipByCondition(htyFctCustAllDto);
                     allDto.setHtyFctCustAllDtoList(htyFctCustAllDtoList);
                //导出明细  活跃会员
                if (export==0){
                    List<HtyFctCustAllDto> custAllExportList=htyFctCustAllDTOService.queryExport(htyFctCustAllDto);
                    allDto.setCustAllExportList(custAllExportList);
                }
            }
            else if(type.equals("1")){
        	//vip会员分析
                 //vip店
                if(isVip.equals("是")){

                List<HtyFctCustAllDto> htyFctCustAllDtoList = htyFctCustAllDTOService.queryActiveVipByCondition(htyFctCustAllDto);
                allDto.setHtyFctCustAllDtoList(htyFctCustAllDtoList);
                    //导出明细  vip会员
                    if(export==1){
                        List<HtyFctCustAllDto> exportVipList=htyFctCustAllDTOService.queryExport(htyFctCustAllDto);
                        allDto.setExportVipList(exportVipList);
                    }
                }
                 //高潜vip
                if(isHy.equals("是")&&isVip.equals("否")){
                    List<HtyFctCustAllDto> htyFctCustAllDtoList = htyFctCustAllDTOService.queryActiveVipByCondition(htyFctCustAllDto);
                    allDto.setHtyFctCustAllDtoList(htyFctCustAllDtoList);
                    //导出明细  高潜vip会员
                    if(export==1){
                        List<HtyFctCustAllDto> exportVipList=htyFctCustAllDTOService.queryExport(htyFctCustAllDto);
                        allDto.setExportVipList(exportVipList);
                    }
                }
        	}
            else if(type.equals(2)){

        	//月度分析
                    //导出明细   月度分析
                if(export==2){
                    if (analysisType==0){
                        List<HtyFctMemberOrgDetail>saleNumEachShopAllList = htyFctMemberOrgDetailDTOService.querySaleNumEachShopAll(htyFctMemberOrgDetail);
                        allDto.setSaleNumEachShopAllList(saleNumEachShopAllList);
                    }
                    if (analysisType==1){

                    }
                    if (analysisType==2){

                    }
                }
                HtyFctMemberOrgDetail allXsAmtEachMonth =htyFctMemberOrgDetailDTOService.queryAllXsAmtEachMonth(htyFctMemberOrgDetail);
                htyFctMemberOrgDetail.setOrgCode(allXsAmtEachMonth.getOrgCode());
                List<HtyFctMemberOrgDetail>saleNumEachShop = htyFctMemberOrgDetailDTOService.querySaleNumEachShop(htyFctMemberOrgDetail);
                //销售额占比
                if (analysisType==0){
                        //月份  会员店的销售额在对应平台的占比
                        //会员店名称
                        List<String> hyNameList=new ArrayList<>();
                        if (saleNumEachShop!=null){
                            for (HtyFctMemberOrgDetail memberOrg:saleNumEachShop){
                                hyNameList.add(memberOrg.getCustName());
                            }
                            allDto.setHyNameList(hyNameList);
                        }
                        //销售额
                        List<BigDecimal>hyShopSaleNumList=new ArrayList<BigDecimal>();
                        if (saleNumEachShop!=null) {
                            for (HtyFctMemberOrgDetail memberOrg : saleNumEachShop) {
                                hyShopSaleNumList.add(memberOrg.getXsAmt());
                            }
                            allDto.setHyShopSaleNumList(hyShopSaleNumList);
                        }
                        //销售占比
                        List<BigDecimal>saleRatioList=new ArrayList<BigDecimal>();
                        if(saleNumEachShop!=null && allXsAmtEachMonth!=null){
                            //平台的销售额
                               if ((allXsAmtEachMonth.getXsAmt()).intValue()==0){
                                   saleRatioList.add(allXsAmtEachMonth.getXsAmt());
                               }else {
                                   //会员店的销售额
                                   for (HtyFctMemberOrgDetail MemberOrgDetail : saleNumEachShop) {
                                       BigDecimal bigDecimal = BigDecimal.valueOf(0);
                                       bigDecimal.add(MemberOrgDetail.getXsAmt());
                                       bigDecimal.divide(allXsAmtEachMonth.getXsAmt());
                                       saleRatioList.add(bigDecimal);
                                   }
                               }
                            allDto.setSaleRatioList(saleRatioList);
                        }
                        //最近一次购买日期
                        List<String>lastBuyDateList=new ArrayList<String>();
                        if(saleNumEachShop!=null) {
                            for (HtyFctMemberOrgDetail memberOrg : saleNumEachShop) {
                                lastBuyDateList.add(memberOrg.getLastDate());
                            }
                            allDto.setLastBuyDateList(lastBuyDateList);
                        }
                        //间隔天数
                        List<Integer>intervalDaysList=new ArrayList<Integer>();
                        if(saleNumEachShop!=null) {
                            for (HtyFctMemberOrgDetail memberOrg : saleNumEachShop) {
                               int lastDate= Integer.valueOf(memberOrg.getLastDate());
                               int nowDate= Integer.valueOf(DateTimeUtil.getTodayChar8());
                               int intervalDay= nowDate-lastDate;
                                intervalDaysList.add(intervalDay);
                            }
                            allDto.setIntervalDaysList(intervalDaysList);
                        }
                            //近6个月趋势
                        if(custCode!=null && custCode!="") {
                            List<String> dateListLastSixMonth = new ArrayList<String>();
                            List<BigDecimal> saleLastSixMonthList = new ArrayList<BigDecimal>();
                            for (int i = 1; i < 6; i++) {
                                if (custTime != null) {
                                    htyFctMemberOrgDetail.setDateKey(custTime);
                                    HtyFctMemberOrgDetail memberOrgDetail = htyFctMemberOrgDetailDTOService.queryByCustCode(htyFctMemberOrgDetail);
                                    if (memberOrgDetail != null) {
                                        saleLastSixMonthList.add(memberOrgDetail.getXsAmt());
                                    }
                                    dateListLastSixMonth.add(custTime);
                                }
                                custTime = DateUtil.dateFormat(custTime, 1);
                            }
                            allDto.setSaleLastSixMonthList(saleLastSixMonthList);
                            allDto.setDateListLastSixMonth(dateListLastSixMonth);
                        }
                    }else if(analysisType==1){
                        //根据购买频次排序  月份
                        List<BigDecimal>buyCountList=new ArrayList<BigDecimal>();
                        if(saleNumEachShop!=null){
                           for(HtyFctMemberOrgDetail memberOrg : saleNumEachShop){
                               buyCountList.add(memberOrg.getXsQty());
                           }
                            Collections.sort(buyCountList);
                            Collections.reverse(buyCountList);
                            allDto.setBuyCountList(buyCountList);
                        }
                    }else if(analysisType==2){
                        //购买市场间隔 排序 月份
                        List<Integer>intervalDaysSortList=new ArrayList<Integer>();
                    if(saleNumEachShop!=null) {
                        for (HtyFctMemberOrgDetail memberOrg : saleNumEachShop) {
                            int lastDate= Integer.valueOf(memberOrg.getLastDate());
                            int nowDate= Integer.valueOf(DateTimeUtil.getTodayChar8());
                            int intervalDay= nowDate-lastDate;
                            intervalDaysSortList.add(intervalDay);
                        }
                        Collections.sort(intervalDaysSortList);
                        Collections.reverse(intervalDaysSortList);
                        allDto.setIntervalDaysSortList(intervalDaysSortList);
                    }
                    }
        	}
        		result.setData(allDto);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("目标用户管理页面" + e);
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
        	HtyFctCustAllDto custUpDto = htyFctCustAllDTOService.selectForAnalysis(userId, startTime, endTime, type);
        	if(custUpDto != null){
        		custAllDto.setAmtAll(custUpDto.getAmtAll());
        		custAllDto.setAmtOnline(custUpDto.getAmtOnline());
        		custAllDto.setQtyB2b(custUpDto.getQtyB2b());
        		custAllDto.setQtyBoss(custUpDto.getQtyBoss());
        		custAllDto.setQtyHzg(custUpDto.getQtyHzg());
        		custAllDto.setAmtDk(custUpDto.getAmtDk());
        		custAllDto.setAmtAllNum(htyFctCustAllDTOService.selectForAmtAll(userId, startTime, endTime, type, regionOrg));
        		custAllDto.setAmtOnlineNum(htyFctCustAllDTOService.selectForAmtOnline(userId, startTime, endTime, type, regionOrg));
        		custAllDto.setQtyB2bNum(htyFctCustAllDTOService.selectForQtyB2b(userId, startTime, endTime, type, regionOrg));
        		custAllDto.setQtyBossNum(htyFctCustAllDTOService.selectForQtyBoss(userId, startTime, endTime, type, regionOrg));
        		custAllDto.setQtyHzgNum(htyFctCustAllDTOService.selectForQtyHzg(userId, startTime, endTime, type, regionOrg));
        		custAllDto.setAmtDkNum(htyFctCustAllDTOService.selectForAmtDk(userId, startTime, endTime, type, regionOrg));
        	}
        	//左下图表
        	int level = 1;
    		if(startTime != null && endTime != null){
    			level = DateTimeUtil.getMonthSpace(startTime,endTime);
    		}
        	List<String> listName = new ArrayList<String>();
        	if(bossType == 0){
        		listName.add("无");
        		listName.add(HtyFctCustUtil.S1_2*level+"~"+HtyFctCustUtil.S1_3*level);
        		listName.add(HtyFctCustUtil.S1_3*level+"~"+HtyFctCustUtil.S1_4*level);
        		listName.add(HtyFctCustUtil.S1_4*level+"~"+HtyFctCustUtil.S1_5*level);
        		listName.add(HtyFctCustUtil.S1_5*level+"以上");
        	}else if(bossType == 1){
        		listName.add("无");
        		listName.add(HtyFctCustUtil.S2_2*level+"~"+HtyFctCustUtil.S2_3*level);
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
            				}else if(time > HtyFctCustUtil.S1_2*level && time <= HtyFctCustUtil.S1_3*level){
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
            				}else if(time > HtyFctCustUtil.S2_2*level && time <= HtyFctCustUtil.S2_3*level){
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
        			//分部平均值
        			other1 = other1/level;
        			other2 = other2/level;
        			other3 = other3/level;
        			other4 = other4/level;
        			other5 = other5/level;
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
        	//右下圈
        	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        	if(custUpDto != null){
        		Map<String,String> map1 = new HashMap<String,String>();
            	Map<String,String> map2 = new HashMap<String,String>();
            	Map<String,String> map3 = new HashMap<String,String>();
            	Map<String,String> map4 = new HashMap<String,String>();
	        	map1.put("name", "超级老板采购");
	        	map1.put("value", custUpDto.getAmtOnlineBoss()!=null?custUpDto.getAmtOnlineBoss().toString():"0");
	        	map2.put("name", "商城采购");
	        	map2.put("value", custUpDto.getAmtOnlineB2b()!=null?custUpDto.getAmtOnlineB2b().toString():"0");
	        	map4.put("name", "VMS采购");
	        	map4.put("value", custUpDto.getAmtOnlineVms()!=null?custUpDto.getAmtOnlineVms().toString():"0");
	        	map3.put("name", "线下采购");
	        	if(custUpDto.getAmtAll() != null && custUpDto.getAmtOnline() !=null){
	        		map3.put("value", String.valueOf(custUpDto.getAmtAll().doubleValue()-custUpDto.getAmtOnline().doubleValue()));
	        	}else{
	        		map3.put("value", "0");
	        	}
	        	list.add(map1);
	        	list.add(map2);
	        	list.add(map3);
	        	list.add(map4);
        	}
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
}
