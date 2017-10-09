package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.dto.HtyFctOrgCustIncomeSaleDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgCustIncomeSaleDTOService {

    HtyFctOrgCustIncomeSaleDTO selectByPrimaryKey(Long id);

    HtyFctOrgCustIncomeSaleDTO select(HtyFctOrgCustIncomeSaleDTO dto);
    
    List<HtyFctOrgCustIncomeSaleDTO> selectMonth(String yearDate,String userId);
}
