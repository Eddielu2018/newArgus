package cn.htd.argus.service;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctCustAllDto;

/**
 * Created by qj on 2017/10/25.
 */
public interface HtyFctCustAllDTOService {

    List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto);

    List<HtyFctCustAllDto> selectByForDimension(HtyFctCustInDto inDto);
    
    Integer selectByForDimensionNum(HtyFctCustInDto inDto);
    
    Integer selectForAmtAll(String userId,String startTime,String endTime,int type,Integer regionOrg);

    HtyFctCustAllDto selectForAnalysis(String userId,String startTime,String endTime,int type,String nowTime);

    Integer selectForAmtOnline(String userId,String startTime,String endTime,int type,Integer regionOrg);

    Integer selectForQtyB2b(String userId,String startTime,String endTime,int type,Integer regionOrg);

    Integer selectForQtyBoss(String userId,String startTime,String endTime,int type,Integer regionOrg);

    Integer selectForQtyHzg(String userId,String startTime,String endTime,int type,Integer regionOrg);

    Integer selectForAmtDk(String userId,String startTime,String endTime,int type,Integer regionOrg);

    List<HtyFctCustAllDto> selectForManager(String userId,String dateTime,Integer aliveType,Integer vipType,String outType);

    List<HtyFctCustAllDto> selectForManagerYear(String userId,String dateTime,Integer aliveType,Integer vipType,String outType,String newTime);
    
    List<HtyFctCustAllDto> selectForManagerAll(String userId,String dateTime,Integer aliveType,Integer vipType,String outType);
    
    BigDecimal selectSumAmt(String userId,String dateTime);

    List<HtyFctCustAllDto> selectForPair(String userId,String startTime,String endTime,int type);

    HtyFctCustAllDto  queryCityAndProByUserId(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);

}
