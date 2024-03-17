package com.ssg.productmanagement.config.service;

import com.ssg.todomvc.dto.PageRequestDTO;
import com.ssg.todomvc.dto.PageResponseDTO;
import com.ssg.todomvc.dto.TodoDTO;

public interface ProductManagementService {
    void register(TodoDTO todoDTO);
    // List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
