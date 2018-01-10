package cn.htd.argus.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.dto.HtyFctHomePageLvl;

public interface HtyFctHomePageLvlMapper {
	
	List<HtyFctHomePageLvl> selectHtyFctHomePageLvlByComCode(@Param("companyCode") String companyCode,@Param("staticType") Integer staticType,@Param("orderType") Integer orderType);

}