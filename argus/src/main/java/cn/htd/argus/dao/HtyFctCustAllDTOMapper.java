package cn.htd.argus.dao;

import java.util.List;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctCustAllDto;

public interface HtyFctCustAllDTOMapper {

	HtyFctCustAllDto selectByPrimaryKey(Long id);
    List<HtyFctCustAllDto> select(HtyFctCustAllDto model);
    List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto);

    Integer selectForAmtAll(HtyFctCustAnalysisInDTO inDto);
    
    HtyFctCustAllDto selectForAnalysis(HtyFctCustAnalysisInDTO inDto);
    
    Integer selectForAmtOnline(HtyFctCustAnalysisInDTO inDto);
    
    Integer selectForQtyB2b(HtyFctCustAnalysisInDTO inDto);
    
    Integer selectForQtyBoss(HtyFctCustAnalysisInDTO inDto);
    
    Integer selectForQtyHzg(HtyFctCustAnalysisInDTO inDto);
    
    Integer selectForAmtDk(HtyFctCustAnalysisInDTO inDto);
    
    List<HtyFctCustAllDto> selectForPair(HtyFctCustAnalysisInDTO inDto);

    List<HtyFctCustAllDto> selectByTimePair(HtyFctCustInDto inDto);
    //活跃会员店满足所有的条件
    List<HtyFctCustAllDto> queryActiveVipByCondition(HtyFctCustAllDto htyFctCustAllDto);

    List<HtyFctCustAllDto> selectByTimeDimension(HtyFctCustInDto inDto);
    //导出明细
    List<HtyFctCustAllDto>queryExport(HtyFctCustAllDto htyFctCustAllDto);

    HtyFctCustAllDto  queryCityAndProByUserId(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}