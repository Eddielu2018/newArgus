package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyConfigZcfzSubjcodeDTO;

public interface HtyConfigZcfzSubjcodeDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyConfigZcfzSubjcodeDTO record);

    int insertSelective(HtyConfigZcfzSubjcodeDTO record);

    HtyConfigZcfzSubjcodeDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyConfigZcfzSubjcodeDTO record);

    int updateByPrimaryKey(HtyConfigZcfzSubjcodeDTO record);
}