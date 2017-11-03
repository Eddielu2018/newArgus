package cn.htd.argus.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.dao.HtyFctCustAllDTOMapper;
import cn.htd.argus.dto.HtyFctCustAllDto;
import cn.htd.argus.service.HtyFctCustAllDTOService;

/**
 * Created by qj on 2017/10/25.
 */
public class HtyFctCustAllDTOServiceImpl implements HtyFctCustAllDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctCustAllDTOServiceImpl.class);

    @Autowired
    private HtyFctCustAllDTOMapper dao;

    @Override
    public HtyFctCustAllDto selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctCustAllDto select(HtyFctCustAllDto dto) {
        List<HtyFctCustAllDto> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

	@Override
	public List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto) {
		return  dao.selectByNoPair(inDto);
	}

    @Override
    public List<HtyFctCustAllDto> queryActiveVipByCondition(HtyFctCustAllDto htyFctCustAllDto) {
        return dao.queryActiveVipByCondition(htyFctCustAllDto);
    }

    @Override
    public List<HtyFctCustAllDto> queryExport(HtyFctCustAllDto htyFctCustAllDto) {
        return dao.queryExport(htyFctCustAllDto);
    }
}
