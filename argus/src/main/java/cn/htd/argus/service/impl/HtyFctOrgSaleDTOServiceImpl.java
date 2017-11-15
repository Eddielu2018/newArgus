package cn.htd.argus.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.CompanySortDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dao.HtyFctOrgSaleDTOMapper;
import cn.htd.argus.dto.HtyFctOrgSaleDTO;
import cn.htd.argus.service.HtyFctOrgSaleDTOService;

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
	public HtyFctOrgSaleDTO selectByOrgCode(String userId,String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
        return dao.selectByOrgCode(dto);
	}

	@Override
	public List<HtyFctOrgSaleDTO> selectYear(String userId, String yearMon) {
		if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
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
		HtyFctOrgSaleDTO fdto = new HtyFctOrgSaleDTO();
		fdto.setOrgCode(userId);
		fdto.setYearMon(yearMon);
		HtyFctOrgSortDTO dto = new HtyFctOrgSortDTO();
		List<Integer> headList = dao.selectSortNumForHead(fdto);
		List<Integer> branchList = dao.selectSortNumForBranch(fdto);
		if(headList != null && headList.size()>0){
			dto.setSaleHead(headList.get(0));
		}
		if(branchList != null && branchList.size()>0){
			dto.setSaleBrach(branchList.get(0));
		}
		return dto;
	}

	@Override
	public BigDecimal selectAvgHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
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
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
		dto.setOrgCode(userId);
		dto.setYearMon(yearMon);
		return dao.selectAvgBrach(dto);
	}

	@Override
	public List<CompanySortDTO> selectCompanySortHead(String yearMon) {
		if (yearMon == null) {
            throw new IllegalArgumentException("yearMon id is null");
        }
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
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
		HtyFctOrgSaleDTO dto = new HtyFctOrgSaleDTO();
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
