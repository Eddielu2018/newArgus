package cn.htd.argus.mappers;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.bean.HtyFctCustInDto;
import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctCustAllDto;

public interface HtyFctCustAllDTOMapper {

    List<HtyFctCustAllDto> selectByNoPair(HtyFctCustInDto inDto);

    Integer selectForAmtAll(HtyFctCustAnalysisInDTO inDto);

    HtyFctCustAllDto selectForAnalysis(HtyFctCustAnalysisInDTO inDto);

    Integer selectForAmtOnline(HtyFctCustAnalysisInDTO inDto);

    Integer selectForQtyB2b(HtyFctCustAnalysisInDTO inDto);

    Integer selectForQtyBoss(HtyFctCustAnalysisInDTO inDto);

    Integer selectForQtyHzg(HtyFctCustAnalysisInDTO inDto);

    Integer selectForAmtDk(HtyFctCustAnalysisInDTO inDto);

    List<HtyFctCustAllDto> selectForPair(HtyFctCustAnalysisInDTO inDto);

    List<HtyFctCustAllDto> selectForManager(HtyFctCustAllDto model);

    BigDecimal selectSumAmt(HtyFctCustAllDto model);

    HtyFctCustAllDto  queryCityAndProByUserId(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);

}