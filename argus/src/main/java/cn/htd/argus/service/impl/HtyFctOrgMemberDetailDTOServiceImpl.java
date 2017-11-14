package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctOrgMemberSixMonthDTO;
import cn.htd.argus.dao.HtyFctOrgMemberDetailMapper;
import cn.htd.argus.dto.HtyFctOrgMemberDetailDTO;
import cn.htd.argus.service.HtyFctOrgMemberDetailDTOService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public class HtyFctOrgMemberDetailDTOServiceImpl implements HtyFctOrgMemberDetailDTOService {
    @Autowired
    private HtyFctOrgMemberDetailMapper dao;
    @Override
    public HtyFctOrgMemberDetailDTO selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }
	@Override
	public List<HtyFctOrgMemberDetailDTO> select(HtyFctOrgMemberDetailDTO model) {
		return dao.select(model);
	}
	@Override
	public List<HtyFctOrgMemberDetailDTO> selectWithName(String userId, String dateTime,int sortType,int outType) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (dateTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		HtyFctOrgMemberDetailDTO dto = new HtyFctOrgMemberDetailDTO();
		dto.setOrgCode(userId);
		dto.setDateKey(dateTime);
		dto.setSortType(sortType);
		dto.setOutType(outType);
		return dao.selectWithName(dto);
	}
	@Override
	public List<HtyFctOrgMemberDetailDTO> selectSixMonth(String custCode, String startTime, String endTime) {
		if (custCode == null) {
            throw new IllegalArgumentException("custCode is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctOrgMemberSixMonthDTO dto = new HtyFctOrgMemberSixMonthDTO();
		dto.setCustCode(custCode);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		return dao.selectSixMonth(dto);
	}
	@Override
	public BigDecimal selectSumAmt(String userId, String dateTime) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (dateTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		HtyFctOrgMemberDetailDTO dto = new HtyFctOrgMemberDetailDTO();
		dto.setOrgCode(userId);
		dto.setDateKey(dateTime);
		return dao.selectSumAmt(dto);
	}
	@Override
	public List<HtyFctOrgMemberDetailDTO> selectSixMonthsAll(String userId, String startTime, String endTime) {
		if (userId == null) {
            throw new IllegalArgumentException("custCode is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctOrgMemberSixMonthDTO dto = new HtyFctOrgMemberSixMonthDTO();
		dto.setCustCode(userId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		return dao.selectSixMonthsAll(dto);
	}
	@Override
	public BigDecimal selectSumAmtSixMonth(String userId, String startTime, String endTime) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctOrgMemberSixMonthDTO dto = new HtyFctOrgMemberSixMonthDTO();
		dto.setCustCode(userId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		return dao.selectSumAmtSixMonth(dto);
	}
	@Override
	public List<HtyFctOrgMemberDetailDTO> selectSixMonthsFrequency(String userId, String startTime, String endTime) {
		if (userId == null) {
            throw new IllegalArgumentException("custCode is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctOrgMemberSixMonthDTO dto = new HtyFctOrgMemberSixMonthDTO();
		dto.setCustCode(userId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		return dao.selectSixMonthsFrequency(dto);
	}
	@Override
	public List<HtyFctOrgMemberDetailDTO> selectSixMonthsInterval(String userId, String startTime, String endTime) {
		if (userId == null) {
            throw new IllegalArgumentException("custCode is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctOrgMemberSixMonthDTO dto = new HtyFctOrgMemberSixMonthDTO();
		dto.setCustCode(userId);
		dto.setStartTime(startTime);
		dto.setEndTime(endTime);
		return dao.selectSixMonthsInterval(dto);
	}
    
}
