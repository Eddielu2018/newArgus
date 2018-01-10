package cn.htd.argus.mappers;


import org.apache.ibatis.annotations.Param;

import cn.htd.argus.dto.HtyFctHomePageOrg;

public interface HtyFctHomePageOrgMapper {
	
	HtyFctHomePageOrg selectHtyFctHomePageByComCode(@Param("companyCode") String companyCode);
}