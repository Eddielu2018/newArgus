package cn.htd.argus.dao;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctOrgMemberSixMonthDTO;
import cn.htd.argus.dto.HtyFctOrgMemberDetailDTO;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface HtyFctOrgMemberDetailMapper {
	HtyFctOrgMemberDetailDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgMemberDetailDTO> select(HtyFctOrgMemberDetailDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectWithName(HtyFctOrgMemberDetailDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonth(HtyFctOrgMemberSixMonthDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonthsAll(HtyFctOrgMemberSixMonthDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonthsFrequency(HtyFctOrgMemberSixMonthDTO model);
    
    List<HtyFctOrgMemberDetailDTO> selectSixMonthsInterval(HtyFctOrgMemberSixMonthDTO model);
    
    BigDecimal selectSumAmtSixMonth(HtyFctOrgMemberSixMonthDTO model);
    
    BigDecimal selectSumAmt(HtyFctOrgMemberDetailDTO model);
}
