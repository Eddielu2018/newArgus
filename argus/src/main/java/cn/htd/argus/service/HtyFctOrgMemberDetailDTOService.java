package cn.htd.argus.service;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctOrgMemberSixMonthDTO;
import cn.htd.argus.dto.HtyFctOrgMemberDetailDTO;

/**
 * Created by suntao on 2017/10/31.
 */
public interface HtyFctOrgMemberDetailDTOService {
    HtyFctOrgMemberDetailDTO selectByPrimaryKey(Long id);
    
    List<HtyFctOrgMemberDetailDTO> select(HtyFctOrgMemberDetailDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectWithName(String userId,String dateTime,int sortType,int outType);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonth(String custCode,String startTime,String endTime);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonthsAll(String userId,String startTime,String endTime);
    
    BigDecimal selectSumAmtSixMonth(String userId,String startTime,String endTime);
    
    BigDecimal selectSumAmt(String userId,String dateTime);
}
