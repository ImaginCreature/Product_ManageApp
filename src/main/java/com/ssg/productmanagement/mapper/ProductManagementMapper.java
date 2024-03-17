package com.ssg.productmanagement.config.mapper;

import com.ssg.todomvc.domain.TodoVO;
import com.ssg.todomvc.dto.PageRequestDTO;

import java.util.List;

public interface ProductManagementMapper {
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> selectAll();
    TodoVO selectOne(Long tno);
    void delete(Long tno);
    void update(TodoVO todoVO);
    int getCount(PageRequestDTO pageRequestDTO);
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

}
