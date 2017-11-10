package cn.htd.argus.mappers;

import cn.htd.argus.dto.ZeusConfigDTO;

import java.util.List;

public interface ZeusConfigDTOMapper {
    int insert(ZeusConfigDTO record);

    int insertSelective(ZeusConfigDTO record);

    List<ZeusConfigDTO> selectFinance();

    List<ZeusConfigDTO> selectFinanceSupport();
}