package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSalePlAnalysisOrgDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSalePlAnalysisOrgDTOMapper {
    int insert(HtyFctSalePlAnalysisOrgDTO record);

    int insertSelective(HtyFctSalePlAnalysisOrgDTO record);

    List<HtyFctSalePlAnalysisOrgDTO> querySalePlAnalysisOrg(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}