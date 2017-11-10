package cn.htd.argus.service.impl;

import cn.htd.argus.dto.ZeusConfigDTO;
import cn.htd.argus.mappers.ZeusConfigDTOMapper;
import cn.htd.argus.service.ZeusConfigDTOService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/11/10.
 */
public class ZeusConfigDTOServiceImpl implements ZeusConfigDTOService {

    @Autowired
    private ZeusConfigDTOMapper dao;

    @Override
    public List<ZeusConfigDTO> selectFinance() {
        return dao.selectFinance();
    }

    @Override
    public List<ZeusConfigDTO> selectFinanceSupport() {
        return dao.selectFinanceSupport();
    }
}
