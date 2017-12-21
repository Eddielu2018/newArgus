package cn.htd.argus.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.dto.HtyFctMemberStockOrg;
import cn.htd.common.Pager;

public interface HtyFctMemberStockOrgMapper {
	List<HtyFctMemberStockOrg> queryPagedHtyFctMemberStockByCompanyCode(@Param("companyCode") String companyCode,
			@Param("pager") Pager page);

    Long queryTotalHtyFctMemberStockByCompanyCode(@Param("companyCode") String companyCode);
}