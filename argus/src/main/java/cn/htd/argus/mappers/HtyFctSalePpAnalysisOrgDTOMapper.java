package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSalePpAnalysisOrgDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSalePpAnalysisOrgDTOMapper {
    int insert(HtyFctSalePpAnalysisOrgDTO record);

    int insertSelective(HtyFctSalePpAnalysisOrgDTO record);

    List<HtyFctSalePpAnalysisOrgDTO> querySalePpAnalysisOrg(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);
}