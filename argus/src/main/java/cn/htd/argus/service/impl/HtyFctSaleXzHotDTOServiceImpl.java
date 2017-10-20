package cn.htd.argus.service.impl;

import cn.htd.argus.bean.BrandSortDTO;
import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleHotDTO;
import cn.htd.argus.dao.HtyFctSaleXzHotDTOMapper;
import cn.htd.argus.dto.HtyFctSaleXzHotDTO;
import cn.htd.argus.service.HtyFctSaleXzHotDTOService;
import cn.htd.common.Pager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleXzHotDTOServiceImpl implements HtyFctSaleXzHotDTOService{

    @Autowired
    private HtyFctSaleXzHotDTOMapper dao;

    @Override
    public HtyFctSaleXzHotDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleXzHotDTO dto = new HtyFctSaleXzHotDTO();
        return null;
    }

    @Override
    public Long queryPageCount(HtyFctSaleSearchDTO searchDTO) {
        return dao.queryPageCount(searchDTO);
    }

    @Override
    public Long queryPageSumCount(HtyFctSaleSearchDTO searchDTO) {
        return dao.queryPageSumCount(searchDTO);
    }

    @Override
    public List<SaleHotDTO> queryPage(HtyFctSaleSearchDTO searchDTO, Pager pager) {
        List<SaleHotDTO> dtos = new ArrayList<SaleHotDTO>();
        List<HtyFctSaleXzHotDTO> list = dao.querySumPage(searchDTO, pager);
       if(list != null){
           for(HtyFctSaleXzHotDTO i: list){
               SaleHotDTO dto = new SaleHotDTO();
               dto.setPpName(i.getPpName());
               dto.setPlName(i.getPlName());
               dto.setMaxXsAmt(i.getMaxXsAmt());
               dto.setMinXsAmt(i.getMinXsAmt());
               dto.setProdName(i.getProdName());
               dto.setProdCode(i.getProdCode());
               dto.setQtyAvg(i.getXsQty());
               dtos.add(dto);
           }
       }else{
           return null;
       }
        return dtos;
    }

    @Override
    public List<BrandSortDTO> queryBrand() {
        List<BrandSortDTO> list = new ArrayList<BrandSortDTO>();
        List<HtyFctSaleXzHotDTO> list1 = dao.queryBrand();
        if(list1 != null){
            for(HtyFctSaleXzHotDTO i:list1){
                BrandSortDTO dto = new BrandSortDTO();
                dto.setBrandName(i.getPpName());
                dto.setSortNum(i.getPpCode());
                list.add(dto);
            }
        }else{
            return null;
        }
        return list;
    }

    @Override
    public List<BrandSortDTO> queryCategory() {
        List<BrandSortDTO> list = new ArrayList<BrandSortDTO>();
        List<HtyFctSaleXzHotDTO> list1 = dao.queryCategory();
        if(list1 != null){
            for(HtyFctSaleXzHotDTO i:list1){
                BrandSortDTO dto = new BrandSortDTO();
                dto.setBrandName(i.getPlName());
                dto.setSortNum(i.getPlCode());
                list.add(dto);
            }
        }else{
            return null;
        }
        return list;
    }
}
