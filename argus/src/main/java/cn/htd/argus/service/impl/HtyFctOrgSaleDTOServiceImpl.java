package cn.htd.argus.service.impl;

import cn.htd.argus.dao.HtyFctOrgSaleDTOMapper;
import cn.htd.argus.dto.HtyFctOrgSaleDTO;
import cn.htd.argus.service.HtyFctOrgSaleDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgSaleDTOServiceImpl implements HtyFctOrgSaleDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustIncomeSaleDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgSaleDTOMapper dao;

    @Override
    public HtyFctOrgSaleDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctOrgSaleDTO select(HtyFctOrgSaleDTO dto) {
        List<HtyFctOrgSaleDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

	@Override
	public HtyFctOrgSaleDTO selectByOrgCode(Long userId) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByOrgCode(userId);
	}
}
