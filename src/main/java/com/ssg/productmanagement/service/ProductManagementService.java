package com.ssg.productmanagement.service;

import com.ssg.productmanagement.dto.ProductDTO;
import com.ssg.productmanagement.dto.PageRequestDTO;
import com.ssg.productmanagement.dto.PageResponseDTO;

public interface ProductManagementService {
    void register(ProductDTO productDTO);
    ProductDTO getOne(Long pno);
    void remove(Long pno);
    void modify(ProductDTO productDTO);
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
}
