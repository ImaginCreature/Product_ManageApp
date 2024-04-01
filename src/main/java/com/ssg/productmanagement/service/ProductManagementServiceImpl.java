package com.ssg.productmanagement.service;

import com.ssg.productmanagement.domain.ProductVO;
import com.ssg.productmanagement.dto.ProductDTO;
import com.ssg.productmanagement.mapper.ProductManagementMapper;
import com.ssg.productmanagement.dto.PageRequestDTO;
import com.ssg.productmanagement.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductManagementServiceImpl implements ProductManagementService {
    private final ProductManagementMapper productManagementMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(ProductDTO productDTO) {
        log.info(modelMapper);
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        log.info(productVO);
        productManagementMapper.insert(productVO);
    }

    @Override
    public ProductDTO getOne(Long pno) {
        ProductVO productVO = productManagementMapper.selectOne(pno);
        ProductDTO productDTO = modelMapper.map(productVO, ProductDTO.class);
        return productDTO;
    }

    @Override
    public void remove(Long pno) {
        productManagementMapper.delete(pno);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        productManagementMapper.update(productVO);
    }

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        List<ProductVO> vos = productManagementMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtos = vos.stream()
                .map(vo -> modelMapper.map(vo, ProductDTO.class))
                .toList();
        int total = productManagementMapper.getCount(pageRequestDTO);

        PageResponseDTO<ProductDTO> pageResponseDTO = PageResponseDTO.<ProductDTO>All()
                .dtoList(dtos)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }
    /*서비스 주석 1*/

}
