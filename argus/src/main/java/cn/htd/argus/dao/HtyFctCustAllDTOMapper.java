package cn.htd.argus.dao;

import java.util.List;

import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.dto.HtyFctCustAllDto;

public interface HtyFctCustAllDTOMapper {

	HtyFctCustAllDto selectByPrimaryKey(Long id);
    List<HtyFctCustAllDto> select(HtyFctCustAllDto model);
    List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto);
    List<HtyFctCustAllDto> selectByTimePair(HtyFctCustInDto inDto);
    //活跃会员店满足所有的条件
    List<HtyFctCustAllDto> queryActiveVipByCondition(HtyFctCustAllDto htyFctCustAllDto);

    List<HtyFctCustAllDto> selectByTimeDimension(HtyFctCustInDto inDto);
    //导出明细
    List<HtyFctCustAllDto>queryExport(HtyFctCustAllDto htyFctCustAllDto);
}