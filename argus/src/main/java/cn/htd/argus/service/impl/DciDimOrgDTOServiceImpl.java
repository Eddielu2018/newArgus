package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.dao.DciDimOrgDTOMapper;
import cn.htd.argus.dto.DciDimOrgDTO;
import cn.htd.argus.service.DciDimOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/9/26.
 */
public class DciDimOrgDTOServiceImpl implements DciDimOrgDTOService{
    private Logger logger = LoggerFactory.getLogger(DciDimOrgDTOServiceImpl.class);

    @Autowired
    private DciDimOrgDTOMapper dao;

    @Override
    public DciDimOrgDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public DciDimOrgDTO select(DciDimOrgDTO dto) {
        List<DciDimOrgDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

	@Override
	public int selectAllNum() {
		return dao.selectAllNum();
	}

	@Override
	public Integer selectRegionNum(String userId) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		HtyFctCustAnalysisInDTO dto = new HtyFctCustAnalysisInDTO();
		dto.setUserId(userId);
		return dao.selectRegionNum(dto);
	}

	@Override
	public Integer selectRegionNumWithOutCust(String userId) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		HtyFctCustAnalysisInDTO dto = new HtyFctCustAnalysisInDTO();
		dto.setUserId(userId);
		return dao.selectRegionNumWithOutCust(dto);
	}
}
