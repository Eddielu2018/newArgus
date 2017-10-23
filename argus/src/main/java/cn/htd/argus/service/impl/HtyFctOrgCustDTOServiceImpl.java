package cn.htd.argus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.CompanySortDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dao.HtyFctOrgCustDTOMapper;
import cn.htd.argus.dto.HtyFctOrgCustDTO;
import cn.htd.argus.service.HtyFctOrgCustDTOService;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgCustDTOServiceImpl implements HtyFctOrgCustDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgCustDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgCustDTOMapper dao;

    @Override
    public HtyFctOrgCustDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctOrgCustDTO select(HtyFctOrgCustDTO dto) {
        List<HtyFctOrgCustDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

	@Override
	public HtyFctOrgCustDTO selectByOrgCode(String userId) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
	}

	@Override
	public List<HtyFctOrgCustDTO> selectYear(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
		return dao.selectYear(dto);
	}

	@Override
	public HtyFctOrgSortDTO selectSort(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO fdto = new HtyFctOrgCustDTO();
		fdto.setOrgCode(userId);
		fdto.setYearMon(yearMon);
		HtyFctOrgSortDTO dto = new HtyFctOrgSortDTO();
		dto.setMemeberHead(dao.selectSortNumForHead(fdto));
		dto.setMemeberBrach(dao.selectSortNumForBranch(fdto));
		return dto;
	}

	@Override
	public Integer selectAvgHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setYearMon(yearMon);
		return dao.selectAvgHead(dto);
	}

	@Override
	public Integer selectAvgBrach(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
		return dao.selectAvgBrach(dto);
	}

	@Override
	public List<CompanySortDTO> selectCompanySortHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setYearMon(yearMon);
		List<String> list = dao.selectCompanySortHead(dto);
		List<CompanySortDTO> companyList = new ArrayList<CompanySortDTO>();
		for(int i = 0;i < list.size();i++){
			CompanySortDTO sortDto = new CompanySortDTO();
			String companyName = list.get(i);
			sortDto.setSortNum(i+1);
			sortDto.setCompanyName(companyName);
			companyList.add(sortDto);
		}
		return companyList;
	}

	@Override
	public List<CompanySortDTO> selectCompanySortBrach(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgCustDTO dto = new HtyFctOrgCustDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
		List<String> list = dao.selectCompanySortBrach(dto);
		List<CompanySortDTO> companyList = new ArrayList<CompanySortDTO>();
		for(int i = 0;i < list.size();i++){
			CompanySortDTO sortDto = new CompanySortDTO();
			String companyName = list.get(i);
			sortDto.setSortNum(i+1);
			sortDto.setCompanyName(companyName);
			companyList.add(sortDto);
		}
		return companyList;
	}
}
