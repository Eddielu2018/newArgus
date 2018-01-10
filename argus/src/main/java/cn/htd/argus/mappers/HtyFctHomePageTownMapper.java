package cn.htd.argus.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.dto.HtyFctHomePageTown;

public interface HtyFctHomePageTownMapper {

	List<HtyFctHomePageTown> selectHtyHomepageTownInfo(@Param("companyCode") String companyCode,@Param("cityCode") String cityCode);
}