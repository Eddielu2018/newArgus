package cn.htd.argus.service;

import cn.htd.argus.dto.ZeusConfigDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/11/10.
 */
public interface ZeusConfigDTOService {

    List<ZeusConfigDTO> selectFinance();

    List<ZeusConfigDTO> selectFinanceSupport();
}
