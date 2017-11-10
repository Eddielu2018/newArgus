package cn.htd.argus.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dao.HtyFctOrgValueDTOMapper;
import cn.htd.argus.dto.HtyFctOrgValueDTO;
import cn.htd.argus.service.HtyFctOrgValueDTOService;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgValueDTOServiceImpl implements HtyFctOrgValueDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustIncomeSaleDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgValueDTOMapper dao;
    @Override
    public HtyFctOrgValueDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctOrgValueDTO select(HtyFctOrgValueDTO dto) {
        List<HtyFctOrgValueDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public HtyFctOrgValueDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctOrgValueDTO dto = new HtyFctOrgValueDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

	@Override
	public HtyFctOrgSortDTO selectSort(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgValueDTO fdto = new HtyFctOrgValueDTO();
		fdto.setOrgCode(userId);
		fdto.setYearmon(yearMon);
		HtyFctOrgSortDTO dto = new HtyFctOrgSortDTO();
		dto.setValueHead(dao.selectSortNumForHead(fdto));
		dto.setValueBranch(dao.selectSortNumForBranch(fdto));
		return dto;
	}

	@Override
	public HtyFctOrgValueDTO selectOrgMax(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		 HtyFctOrgValueDTO dto = new HtyFctOrgValueDTO();
		 dto.setYearmon(yearMon);
		return dao.selectOrgMax(dto);
	}
}
