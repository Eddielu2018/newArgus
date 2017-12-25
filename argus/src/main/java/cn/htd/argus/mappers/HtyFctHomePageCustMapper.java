package cn.htd.argus.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.dto.HtyFctHomePageCust;

public interface HtyFctHomePageCustMapper {
    
    List<HtyFctHomePageCust> selectHtyFctHomePageCustByTownPK(@Param("pkKeyTownList") List<String> pkKeyTownList);
}