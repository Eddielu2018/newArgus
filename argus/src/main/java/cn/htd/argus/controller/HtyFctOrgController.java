package cn.htd.argus.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.bean.BaseNumDTO;
import cn.htd.argus.bean.HtyFctOrgAvgDTO;
import cn.htd.argus.bean.HtyFctOrgBusinessAvgDTO;
import cn.htd.argus.bean.HtyFctOrgMemberAvgDTO;
import cn.htd.argus.bean.HtyFctOrgSaleAvgDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.bean.HtyFctOrgWholeDTO;
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
import cn.htd.argus.util.MathUtil;
import cn.htd.argus.util.RestResult;

/**
 * 业务效率
 * Created by wangtp on 2017/9/27.
 */
@RestController
@RequestMapping("/htypctorg")
public class HtyFctOrgController {
    Logger logger = LoggerFactory.getLogger(HtyFctOrgController.class);

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
            	Double sort = MathUtil.getPairToDouble(new BigDecimal(htyFctOrgValueDTO.getZtpm()), new BigDecimal(dciDimOrgDTOService.selectAllNum()));
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
     * 首页左下
     * @param userId
     * @param date
     * @param type
     * @param kind
     * @return
     */
    @RequestMapping("/index/whole")
    public RestResult indexForWhole(@RequestParam(value = "userId", required = true) String userId,
    		@RequestParam(value = "date", required = true) int date,
    		@RequestParam(value = "type", required = true) int type,
    		@RequestParam(value = "kind", required = true) int kind) {
        RestResult result = new RestResult();
        logger.info("调用(HtyPctOrgController.indexForWhole)首页左下获取入参，userId="+userId);
        try {
        	HtyFctOrgWholeDTO allDto = new HtyFctOrgWholeDTO();
        	HtyFctOrgIncomeDTO htyFctOrgIncomeDTO= this.htyFctOrgIncomeDTOService.selectByOrgCode(userId);
        	HtyFctOrgSaleDTO htyFctOrgSaleDTO = this.htyFctOrgSaleDTOService.selectByOrgCode(userId);
        	HtyFctOrgCustDTO htyFctOrgCustDTO = this.htyFctOrgCustDTOService.selectByOrgCode(userId);
        	//左侧公共
        	allDto.setWholeLeft(getLeft(htyFctOrgIncomeDTO,htyFctOrgSaleDTO,htyFctOrgCustDTO,date));
        	//顶部
        	allDto.setWholeTop(getTop(htyFctOrgIncomeDTO,htyFctOrgSaleDTO,htyFctOrgCustDTO,date,type));
        	List<Map<String,String>> wholeNameList = new ArrayList<Map<String,String>>();
        	List<Map<String,String>> wholePiclist = new ArrayList<Map<String,String>>();
        	Map<String,String> map1 = new HashMap<String,String>();
    		Map<String,String> map2 = new HashMap<String,String>();
    		Map<String,String> map3 = new HashMap<String,String>();
    		Map<String,String> map4 = new HashMap<String,String>();
    		Map<String,String> nameMap1 = new HashMap<String,String>();
    		Map<String,String> nameMap2 = new HashMap<String,String>();
    		Map<String,String> nameMap3 = new HashMap<String,String>();
    		Map<String,String> nameMap4 = new HashMap<String,String>();
    		nameMap1.put("value", "0");
    		nameMap2.put("value", "1");
    		nameMap3.put("value", "2");
    		nameMap4.put("value", "3");
        	if(type == 0){
        		//营业
        		nameMap1.put("label", "总营业收入");
        		nameMap2.put("label", "进销存营业收入");
        		nameMap3.put("label", "服务营业收入");
        		nameMap4.put("label", "金融营业收入");
        		//顶部展示
        		map1.put("name", "进销存营业收入");
        		map2.put("name", "服务营业收入");
        		map3.put("name", "金融营业收入");
        		map1.put("value", allDto.getWholeTop().get(0).getNum().toString());
        		map2.put("value", allDto.getWholeTop().get(1).getNum().toString());
        		map3.put("value", allDto.getWholeTop().get(2).getNum().toString());
        		wholePiclist.add(map1);
        		wholePiclist.add(map2);
        		wholePiclist.add(map3);
        	}else if(type == 1){
        		//金额
        		nameMap1.put("label", "总销售金额");
        		nameMap2.put("label", "线上交易金额");
        		nameMap3.put("label", "未支付金额");
        		nameMap4.put("label", "商品+销售金额");
        		//顶部展示
        		map1.put("name", "线上交易金额");
        		map2.put("name", "非线上交易金额");
        		map1.put("value", allDto.getWholeTop().get(0).getNum().toString());
        		map2.put("value", ""+(allDto.getWholeTop().get(1).getNum().doubleValue()+allDto.getWholeTop().get(2).getNum().doubleValue()));
        		wholePiclist.add(map1);
        		wholePiclist.add(map2);
        	}else if(type == 2){
        		//会员
        		nameMap1.put("label", "新增会员店总数");
        		nameMap2.put("label", "交易会员店数");
        		nameMap3.put("label", "活跃会员店数");
        		nameMap4.put("label", "VIP会员店数");
        		//顶部展示
        		map1.put("name", "会员店总数");
        		map2.put("name", "交易会员店数");
        		map3.put("name", "活跃会员店数");
        		map4.put("name", "VIP会员店数");
        		map1.put("value", allDto.getWholeLeft().get(2).getNum().toString());
        		map2.put("value", allDto.getWholeTop().get(0).getNum().toString());
        		map3.put("value", allDto.getWholeTop().get(1).getNum().toString());
        		map4.put("value", allDto.getWholeTop().get(2).getNum().toString());
        		wholePiclist.add(map1);
        		wholePiclist.add(map2);
        		wholePiclist.add(map3);
        		wholePiclist.add(map4);
        	}
        	wholeNameList.add(nameMap1);
    		wholeNameList.add(nameMap2);
    		wholeNameList.add(nameMap3);
    		wholeNameList.add(nameMap4);
        	allDto.setWholeName(wholeNameList);
        	allDto.setWholePic(wholePiclist);
        	//底部列表
        	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
        	List<String> wholeBottomDate = new ArrayList<String>();
        	List<String> wholeBottom = new ArrayList<String>();
        	List<String> wholeBottomPair = new ArrayList<String>();
        	String yearWithDate = DateUtil.getCurDateStr1("yyyyMM");
        	String yearDate = DateUtil.getCurDateStr1("yyyy");
        	if("01".equals(yearWithDate.substring(yearWithDate.length()-2, yearWithDate.length()))){
        		yearDate = String.valueOf((Integer.valueOf(yearDate)-1));
        	}
        	logger.info("==================================================yearDate="+yearDate);
        	List<HtyFctOrgCustIncomeSaleDTO> list = this.htyFctOrgCustIncomeSaleDTOService.selectMonth(yearWithDate, userId);
        	if(type == 0){
        		//营业
        		List<HtyFctOrgIncomeDTO> incomeList = this.htyFctOrgIncomeDTOService.selectYear(userId,yearDate);
        		if(date == 0){
        			wholeBottomList = getMothIncome(list,kind);
        		}else if(date == 1){
        			wholeBottomList = getYearIncome(incomeList, kind);
        		}
        	}else if(type == 1){
        		//金额
        		List<HtyFctOrgSaleDTO> saleList = this.htyFctOrgSaleDTOService.selectYear(userId,yearDate);
        		if(date == 0){
        			wholeBottomList = getMothSale(list, kind);
        		}else if(date == 1){
        			wholeBottomList = getYearSale(saleList, kind);
        		}
        	}else if(type == 2){
        		//会员
        		List<HtyFctOrgCustDTO> custList = this.htyFctOrgCustDTOService.selectYear(userId,yearDate);
        		if(date == 0){
        			wholeBottomList = getMothCust(list, kind);
        		}else if(date == 1){
        			wholeBottomList = getYearCust(custList, kind);
        		}
        	}
        	for(Map<String,String> btMap : wholeBottomList){
        		wholeBottomDate.add(btMap.get("date"));
        		wholeBottom.add(btMap.get("value"));
        		if(btMap.containsKey("pair")){
        			wholeBottomPair.add(btMap.get("pair"));
        		}
        	}
        	logger.info("==================================================000000000000003");
        	allDto.setWholeBottom(wholeBottom);
        	allDto.setWholeBottomDate(wholeBottomDate);
        	allDto.setWholeBottomPair(wholeBottomPair);
        	result.setData(allDto);
            result.setCode(ResultCodeEnum.SUCCESS.getCode());
            result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("获取首页左下错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    private List<Map<String,String>> getMothIncome(List<HtyFctOrgCustIncomeSaleDTO> list,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgCustIncomeSaleDTO incomeList : list){
			Map<String,String> map = new HashMap<String,String>();
			map.put("date", incomeList.getYearDate().substring(4));
			if(kind == 0){
				if(incomeList.getBusincomeAmt()!=null){
					map.put("value", incomeList.getBusincomeAmt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 1){
				if(incomeList.getInvoicingAmt()!=null){
					map.put("value", incomeList.getInvoicingAmt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 2){
				if(incomeList.getServiceAmt()!=null){
					map.put("value", incomeList.getServiceAmt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 3){
				if(incomeList.getFinanceAmt()!=null){
					map.put("value", incomeList.getFinanceAmt().toString());
				}else{
					map.put("value", null);
				}
			}
			wholeBottomList.add(map);
		}
    	return wholeBottomList;
    }
    
    private List<Map<String,String>> getMothSale(List<HtyFctOrgCustIncomeSaleDTO> list,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgCustIncomeSaleDTO incomeList : list){
			Map<String,String> map = new HashMap<String,String>();
			map.put("date", incomeList.getYearDate().substring(4));
			if(kind == 0){
				if(incomeList.getSaleAmt()!=null){
					map.put("value", incomeList.getSaleAmt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 1){
				if(incomeList.getOnlineSaleamt()!=null){
					map.put("value", incomeList.getOnlineSaleamt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 2){
				if(incomeList.getProdSaleamt()!=null){
					map.put("value", incomeList.getProdSaleamt().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 3){
				if(incomeList.getNonprodSaleamt()!=null){
					map.put("value", incomeList.getNonprodSaleamt().toString());
				}else{
					map.put("value", null);
				}
			}
			wholeBottomList.add(map);
		}
    	return wholeBottomList;
    }
    
    private List<Map<String,String>> getMothCust(List<HtyFctOrgCustIncomeSaleDTO> list,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgCustIncomeSaleDTO incomeList : list){
			Map<String,String> map = new HashMap<String,String>();
			map.put("date", incomeList.getYearDate().substring(4));
			if(kind == 0){
				if(incomeList.getCustnum()!=null){
					map.put("value", incomeList.getCustnum().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 1){
				if(incomeList.getTranscustnum()!=null){
					map.put("value", incomeList.getTranscustnum().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 2){
				if(incomeList.getActCustnum()!=null){
					map.put("value", incomeList.getActCustnum().toString());
				}else{
					map.put("value", null);
				}
			}else if(kind == 3){
				if(incomeList.getVipNum()!=null){
					map.put("value", incomeList.getVipNum().toString());
				}else{
					map.put("value", null);
				}
			}
			wholeBottomList.add(map);
		}
    	return wholeBottomList;
    }
    
    private List<Map<String,String>> getYearIncome(List<HtyFctOrgIncomeDTO> incomeList,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgIncomeDTO income : incomeList){
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("date", income.getYearMon());
    		if(kind == 0){
    			if(income.getMonBusincomeAmt()!=null){
    				map.put("value", income.getMonBusincomeAmt().toString());
    			}else{
					map.put("value", null);
				}
    			if(income.getLastMonBusincomeAmt()!=null){
    				map.put("pair", income.getLastMonBusincomeAmt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 1){
    			if(income.getMonInvoicingAmt()!=null){
    				map.put("value", income.getMonInvoicingAmt().toString());
    			}else{
					map.put("value", null);
				}
    			if(income.getLastMonInvoicingAmt()!=null){
    				map.put("pair", income.getLastMonInvoicingAmt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 2){
    			if(income.getMonServiceAmt()!=null){
    				map.put("value", income.getMonServiceAmt().toString());
    			}else{
					map.put("value", null);
				}
    			if(income.getLastMonServiceAmt()!=null){
    				map.put("pair", income.getLastMonServiceAmt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 3){
    			if(income.getMonFinanceAmt()!=null){
    				map.put("value", income.getMonFinanceAmt().toString());
    			}else{
					map.put("value", null);
				}
    			if(income.getLastMonFinanceAmt()!=null){
    				map.put("pair", income.getLastMonFinanceAmt().toString());
    			}else{
					map.put("pair", null);
				}
    		}
    		wholeBottomList.add(map);
    	}
    	return wholeBottomList;
    }
    
    private List<Map<String,String>> getYearSale(List<HtyFctOrgSaleDTO> saleList,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgSaleDTO sale : saleList){
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("date", sale.getYearMon());
    		if(kind == 0){
    			if(sale.getMonAmt()!=null){
    				map.put("value", sale.getMonAmt().toString());
    			}else{
					map.put("value", null);
				}
    			if(sale.getLastmonAmt()!=null){
    				map.put("pair", sale.getLastmonAmt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 1){
    			if(sale.getMonOnlineSaleamt()!=null){
    				map.put("value", sale.getMonOnlineSaleamt().toString());
    			}else{
					map.put("value", null);
				}
    			if(sale.getLastmonOnlineSaleamt()!=null){
    				map.put("pair", sale.getLastmonOnlineSaleamt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 2){
    			if(sale.getMonWaitSaleamt()!=null){
    				map.put("value", sale.getMonWaitSaleamt().toString());
    			}else{
					map.put("value", null);
				}
    			if(sale.getLastmonWaitSaleamt()!=null){
    				map.put("pair", sale.getLastmonWaitSaleamt().toString());
    			}else{
					map.put("pair", null);
				}
    		}else if(kind == 3){
    			if(sale.getMonSpSaleamt()!=null){
    				map.put("value", sale.getMonSpSaleamt().toString());
    			}else{
					map.put("value", null);
				}
    			if(sale.getLastmonSpSaleamt()!=null){
    				map.put("pair", sale.getLastmonSpSaleamt().toString());
    			}else{
					map.put("pair", null);
				}
    		}
    		wholeBottomList.add(map);
    	}
    	return wholeBottomList;
    }
    
    private List<Map<String,String>> getYearCust(List<HtyFctOrgCustDTO> custList,int kind){
    	List<Map<String,String>> wholeBottomList = new ArrayList<Map<String,String>>();
    	for(HtyFctOrgCustDTO cust : custList){
    		Map<String,String> map = new HashMap<String,String>();
    		map.put("date", cust.getYearMon());
        	if(kind == 0){
        		if(cust.getMonNewcustnum()!=null){
        			map.put("value", cust.getMonNewcustnum().toString());
        		}else{
					map.put("value", null);
				}
        		if(cust.getLastmonNewcustnum()!=null){
        			map.put("pair", cust.getLastmonNewcustnum().toString());
        		}else{
					map.put("pair", null);
				}
    		}else if(kind == 1){
    			if(cust.getMonTranscustnum()!=null){
    				map.put("value", cust.getMonTranscustnum().toString());
    			}else{
					map.put("value", null);
				}
    		}else if(kind == 2){
    			if(cust.getActCustnum()!=null){
    				map.put("value", cust.getActCustnum().toString());
    			}else{
					map.put("value", null);
				}
    		}else if(kind == 3){
    			if(cust.getVipNum()!=null){
    				map.put("value", cust.getVipNum().toString());
    			}else{
					map.put("value", null);
				}
    		}
        	wholeBottomList.add(map);
    	}
    	return wholeBottomList;
    }
    
    private List<BaseNumDTO> getLeft(HtyFctOrgIncomeDTO htyFctOrgIncomeDTO,HtyFctOrgSaleDTO htyFctOrgSaleDTO,HtyFctOrgCustDTO htyFctOrgCustDTO,int date){
    	List<BaseNumDTO> allBase = new ArrayList<BaseNumDTO>();
    	//营业
    	BaseNumDTO baseIncome = new BaseNumDTO();
    	baseIncome.setName("总营业收入");
    	if(date == 0){
    		//按月
    		baseIncome = getBaseNum(baseIncome,htyFctOrgIncomeDTO.getMonBusincomeAmt(),htyFctOrgIncomeDTO.getLastMonBusincomeAmt());
    	}else{
    		//按年
    		baseIncome = getBaseNum(baseIncome,htyFctOrgIncomeDTO.getYearBusincomeAmt(),htyFctOrgIncomeDTO.getLastyearBusincomeAmt());
    	}
    	allBase.add(baseIncome);
    	//金额
    	BaseNumDTO basePrice = new BaseNumDTO();
    	basePrice.setName("总销售金额");
    	if(date == 0){
    		//按月
    		basePrice = getBaseNum(basePrice,htyFctOrgSaleDTO.getMonAmt(),htyFctOrgSaleDTO.getLastmonAmt());
    	}else{
    		//按年
    		basePrice = getBaseNum(basePrice,htyFctOrgSaleDTO.getYearAmt(),htyFctOrgSaleDTO.getLastyearAmt());
    	}
    	allBase.add(basePrice);
    	//会员
    	BaseNumDTO baseMember = new BaseNumDTO();
    	baseMember.setName("新增会员店总数");
    	if(date == 0){
    		//按月
    		baseMember = getBaseNum(baseMember,new BigDecimal(htyFctOrgCustDTO.getMonNewcustnum()),new BigDecimal(htyFctOrgCustDTO.getLastmonNewcustnum()));
    	}else{
    		//按年
    		baseMember = getBaseNum(baseMember,new BigDecimal(htyFctOrgCustDTO.getYearNewcustnum()),new BigDecimal(htyFctOrgCustDTO.getLastyearNewcustnum()));
    	}
    	allBase.add(baseMember);
    	return allBase;
    }
    
    private List<BaseNumDTO> getTop(HtyFctOrgIncomeDTO htyFctOrgIncomeDTO,HtyFctOrgSaleDTO htyFctOrgSaleDTO,HtyFctOrgCustDTO htyFctOrgCustDTO,int date,int type){
    	List<BaseNumDTO> allBase = new ArrayList<BaseNumDTO>();
    	BaseNumDTO baseFirst = new BaseNumDTO();
		BaseNumDTO baseSencond = new BaseNumDTO();
		BaseNumDTO baseThird = new BaseNumDTO();
    	if(type == 0){
    		//营业
    		if(date == 0){
    			//按月
	    		baseFirst.setName("月进销存营业收入");
	    		baseSencond.setName("月服务营业收入");
	    		baseThird.setName("月金融营业收入");
	    		baseFirst = getBaseNum(baseFirst, htyFctOrgIncomeDTO.getMonInvoicingAmt(), htyFctOrgIncomeDTO.getLastMonInvoicingAmt());
	    		baseSencond = getBaseNum(baseSencond, htyFctOrgIncomeDTO.getMonServiceAmt(), htyFctOrgIncomeDTO.getLastMonServiceAmt());
	    		baseThird = getBaseNum(baseThird, htyFctOrgIncomeDTO.getMonFinanceAmt(), htyFctOrgIncomeDTO.getLastMonFinanceAmt());
    		}else{
    			//按年
    			baseFirst.setName("年进销存营业收入");
	    		baseSencond.setName("年服务营业收入");
	    		baseThird.setName("年金融营业收入");
	    		baseFirst = getBaseNum(baseFirst, htyFctOrgIncomeDTO.getYearInvoicingAmt(), htyFctOrgIncomeDTO.getLastYearInvoicingAmt());
	    		baseSencond = getBaseNum(baseSencond, htyFctOrgIncomeDTO.getYearServiceAmt(), htyFctOrgIncomeDTO.getLastYearServiceAmt());
	    		baseThird = getBaseNum(baseThird, htyFctOrgIncomeDTO.getYearFinanceAmt(), htyFctOrgIncomeDTO.getLastYearFinanceAmt());
    		}
    	}else if(type == 1){
    		//金额
    		if(date == 0){
    			//按月
    			baseFirst.setName("月线上交易金额");
	    		baseSencond.setName("月未支付金额");
	    		baseThird.setName("月商品+销售金额");
	    		baseFirst = getBaseNum(baseFirst, htyFctOrgSaleDTO.getMonOnlineSaleamt(), htyFctOrgSaleDTO.getLastmonOnlineSaleamt());
	    		baseSencond = getBaseNum(baseSencond, htyFctOrgSaleDTO.getMonWaitSaleamt(), htyFctOrgSaleDTO.getLastmonWaitSaleamt());
	    		baseThird = getBaseNum(baseThird, htyFctOrgSaleDTO.getMonSpSaleamt(), htyFctOrgSaleDTO.getLastmonSpSaleamt());
    		}else{
    			//按年
    			baseFirst.setName("年线上交易金额");
	    		baseSencond.setName("年未支付金额");
	    		baseThird.setName("年商品+销售金额");
	    		baseFirst = getBaseNum(baseFirst, htyFctOrgSaleDTO.getYearOnlineSaleamt(), htyFctOrgSaleDTO.getLastyearOnlineSaleamt());
	    		baseSencond = getBaseNum(baseSencond, htyFctOrgSaleDTO.getYearWaitSaleamt(), htyFctOrgSaleDTO.getLastyearWaitSaleamt());
	    		baseThird = getBaseNum(baseThird, htyFctOrgSaleDTO.getYearSpSaleamt(), htyFctOrgSaleDTO.getLastyearSpSaleamt());
    		}
    	}else if(type == 2){
    		//会员
    		if(date == 0){
    			//按月
    			baseFirst.setName("月交易会员店数");
    			baseFirst.setNum(new BigDecimal(htyFctOrgCustDTO.getMonTranscustnum()));
    		}else{
    			//按年
    			baseFirst.setName("年交易会员店数");
    			baseFirst.setNum(new BigDecimal(htyFctOrgCustDTO.getYearTranscustnum()));
    		}
    		baseSencond.setName("活跃会员店数");
			baseSencond.setNum(new BigDecimal(htyFctOrgCustDTO.getActCustnum()));
			baseSencond.setPair("次日失活:"+htyFctOrgCustDTO.getMorrunactCustnum());
			baseThird.setName("VIP会员店数");
			baseThird.setNum(new BigDecimal(htyFctOrgCustDTO.getVipNum()));
			baseThird.setPair("30天内过期数:"+htyFctOrgCustDTO.getExpire30VipNum());
    	}
    	allBase.add(baseFirst);
    	allBase.add(baseSencond);
    	allBase.add(baseThird);
    	return allBase;
    }
    
    private BaseNumDTO getBaseNum(BaseNumDTO base,BigDecimal nowNum,BigDecimal lastNum){
    	base.setNum(nowNum);
    	double difference = 0;
    	if(nowNum != null && lastNum != null && lastNum.doubleValue() != 0){
	    	if(nowNum.compareTo(lastNum) == 1){
	    		base.setIndex(1);
	    		difference = (nowNum.doubleValue()-lastNum.doubleValue());
	    		base.setPair(String.valueOf(MathUtil.getPairToDouble(new BigDecimal(difference),lastNum)));
	    	}else if(nowNum.compareTo(lastNum) == 0){
	    		base.setIndex(1);
	    		base.setPair(new BigDecimal(0).toString());
	    	}else{
	    		base.setIndex(0);
	    		difference = Math.abs(nowNum.doubleValue()-lastNum.doubleValue());
	    		base.setPair(String.valueOf((MathUtil.getPairToDouble(new BigDecimal(difference),lastNum))));
	    	}
    	}else{
    		base.setIndex(1);
    		base.setPair(new BigDecimal(0).toString());
    	}
    	return base;
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
            		allDto.setSortNum(sdto.getIncomeBrach());
            		allDto.setCompanyList(this.htyFctOrgIncomeDTOService.selectCompanySortBrach(userId, yearDate));
            	}else{
            		allDto.setSortNum(sdto.getIncomeHead());
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
            		allDto.setSortNum(sdto.getMemeberBrach());
            		allDto.setCompanyList(this.htyFctOrgCustDTOService.selectCompanySortBrach(userId, yearDate));
            	}else{
            		allDto.setSortNum(sdto.getMemeberHead());
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
