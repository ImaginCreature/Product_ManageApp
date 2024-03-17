package com.ssg.productmanagement.config.service;

import com.ssg.productmanagement.config.domain.ProductVO;
import com.ssg.productmanagement.config.dto.ProductDTO;
import com.ssg.productmanagement.config.mapper.ProductManagementMapper;
import com.ssg.todomvc.domain.TodoVO;
import com.ssg.todomvc.dto.PageRequestDTO;
import com.ssg.todomvc.dto.PageResponseDTO;
import com.ssg.todomvc.dto.TodoDTO;
import com.ssg.todomvc.mapper.TodoMapper;
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
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> vos = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtos = vos.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .toList();
        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>All()
                .dtoList(dtos)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

}
