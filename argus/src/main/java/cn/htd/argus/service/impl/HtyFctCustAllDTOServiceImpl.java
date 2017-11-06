package cn.htd.argus.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
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
	public Integer selectForAmtAll(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForAmtAll(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public HtyFctCustAllDto selectForAnalysis(String userId, String startTime, String endTime, int type) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		return dao.selectForAnalysis(inDto);
	}

	@Override
	public Integer selectForAmtOnline(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForAmtOnline(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public Integer selectForQtyB2b(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForQtyB2b(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public Integer selectForQtyBoss(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForQtyBoss(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public Integer selectForQtyHzg(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForQtyHzg(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public Integer selectForAmtDk(String userId, String startTime, String endTime, int type,Integer regionOrg) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		Integer temp = dao.selectForAmtDk(inDto);
		if(temp != null && regionOrg != null && regionOrg != 0){
			int sort = temp>=1?100-Integer.valueOf((temp-1)*100/regionOrg):0;
			return sort;
		}
		return 0;
	}

	@Override
	public List<HtyFctCustAllDto> selectForPair(String userId, String startTime, String endTime, int type) {
		if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
		if (startTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
		if (endTime == null) {
            throw new IllegalArgumentException("endTime is null");
        }
		HtyFctCustAnalysisInDTO inDto = new HtyFctCustAnalysisInDTO();
		inDto.setUserId(userId);
		inDto.setStartTime(startTime);
		inDto.setEndTime(endTime);
		inDto.setType(type);
		return dao.selectForPair(inDto);
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
