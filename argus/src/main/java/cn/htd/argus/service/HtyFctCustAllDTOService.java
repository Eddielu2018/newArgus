package cn.htd.argus.service;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.dto.HtyFctCustAllDto;

/**
 * Created by qj on 2017/10/25.
 */
public interface HtyFctCustAllDTOService {

	HtyFctCustAllDto selectByPrimaryKey(Long id);

    HtyFctCustAllDto select(HtyFctCustAllDto dto);

    List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto);
    
    Integer selectForAmtAll(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    HtyFctCustAllDto selectForAnalysis(String userId,String startTime,String endTime,int type);
    
    Integer selectForAmtOnline(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    Integer selectForQtyB2b(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    Integer selectForQtyBoss(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    Integer selectForQtyHzg(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    Integer selectForAmtDk(String userId,String startTime,String endTime,int type,Integer regionOrg);
    
    List<HtyFctCustAllDto> selectForPair(String userId,String startTime,String endTime,int type);

    List<HtyFctCustAllDto> selectForManager(String userId,String dateTime,int aliveType,int vipType,String outType);

    BigDecimal selectSumAmt(String userId,String dateTime);
}
