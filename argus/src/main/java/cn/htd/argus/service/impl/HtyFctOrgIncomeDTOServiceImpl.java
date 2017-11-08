package cn.htd.argus.service.impl;

import cn.htd.argus.bean.CompanySortDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dao.HtyFctOrgCustIncomeSaleDTOMapper;
import cn.htd.argus.dao.HtyFctOrgIncomeDTOMapper;
import cn.htd.argus.dto.HtyFctOrgIncomeDTO;
import cn.htd.argus.service.HtyFctOrgIncomeDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/9/26.
 */
public class HtyFctOrgIncomeDTOServiceImpl implements HtyFctOrgIncomeDTOService{
    private Logger logger = LoggerFactory.getLogger(HtyFctOrgIncomeDTOServiceImpl.class);

    @Autowired
    private HtyFctOrgIncomeDTOMapper dao;

    @Override
    public HtyFctOrgIncomeDTO selectByPrimaryKey(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public HtyFctOrgIncomeDTO select(HtyFctOrgIncomeDTO dto) {
        List<HtyFctOrgIncomeDTO> result = dao.select(dto);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public HtyFctOrgIncomeDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

	@Override
	public List<HtyFctOrgIncomeDTO> selectYear(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
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
		HtyFctOrgIncomeDTO fdto = new HtyFctOrgIncomeDTO();
		fdto.setOrgCode(userId);
		fdto.setYearMon(yearMon);
		HtyFctOrgSortDTO dto = new HtyFctOrgSortDTO();
		List<Integer> headList = dao.selectSortNumForHead(fdto);
		List<Integer> branchList = dao.selectSortNumForBranch(fdto);
		if(headList != null && headList.size()>0){
			dto.setIncomeHead(headList.get(0));
		}
		if(branchList != null && branchList.size()>0){
			dto.setIncomeBrach(branchList.get(0));
		}
		return dto;
	}

	@Override
	public BigDecimal selectAvgHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
		dto.setYearMon(yearMon);
		return dao.selectAvgHead(dto);
	}

	@Override
	public BigDecimal selectAvgBrach(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
		return dao.selectAvgBrach(dto);
	}

	@Override
	public List<CompanySortDTO> selectCompanySortHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
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
		HtyFctOrgIncomeDTO dto = new HtyFctOrgIncomeDTO();
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
