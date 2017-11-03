package cn.htd.argus.service;

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


    List<HtyFctCustAllDto> queryActiveVipByCondition(HtyFctCustAllDto htyFctCustAllDto);
    //导出明细
    List<HtyFctCustAllDto>queryExport(HtyFctCustAllDto htyFctCustAllDto);

}
