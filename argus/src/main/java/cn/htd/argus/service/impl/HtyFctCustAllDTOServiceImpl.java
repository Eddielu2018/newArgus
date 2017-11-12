package cn.htd.argus.service.impl;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.mappers.HtyFctCustAllDTOMapper;
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
    public List<HtyFctCustAllDto> selectForManager(String userId, String dateTime, Integer aliveType, Integer vipType,String outType) {
        if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
        if (dateTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
        HtyFctCustAllDto dto = new HtyFctCustAllDto();
        dto.setOrgCode(userId);
        dto.setDateKey(dateTime);
        dto.setOutType(outType);
        if(aliveType != null){
	        if(aliveType == 1){
	            dto.setIsHy("是");
	        }else if(aliveType == 0){
	            dto.setIsHy("否");
	        }
        }
        if(vipType != null){
	        if(vipType == 1){
	            dto.setIsVip("1");
	        }else if(vipType == 0){
	            dto.setIsVip("0");
	        }
        }
        return dao.selectForManager(dto);
    }

    @Override
    public BigDecimal selectSumAmt(String userId, String dateTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId is null");
        }
        if (dateTime == null) {
            throw new IllegalArgumentException("startTime is null");
        }
        HtyFctCustAllDto dto = new HtyFctCustAllDto();
        dto.setOrgCode(userId);
        dto.setDateKey(dateTime);
        return dao.selectSumAmt(dto);
    }


    @Override
    public HtyFctCustAllDto queryCityAndProByUserId(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
        return dao.queryCityAndProByUserId(htyFctUserBeHaviorSearchDTO);
    }
}
