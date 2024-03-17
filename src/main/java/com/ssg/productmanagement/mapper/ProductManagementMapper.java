package com.ssg.productmanagement.mapper;

import com.ssg.productmanagement.domain.ProductVO;
import com.ssg.productmanagement.dto.PageRequestDTO;

import java.util.List;

public interface ProductManagementMapper {
    String getTime();
    void insert(ProductVO productVO);
    List<ProductVO> selectAll();
    ProductVO selectOne(Long pno);
    void delete(Long pno);
    void update(ProductVO productVO);
    int getCount(PageRequestDTO pageRequestDTO);
    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);

}
