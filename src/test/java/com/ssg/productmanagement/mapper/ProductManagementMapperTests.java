package com.ssg.productmanagement.mapper;

import com.ssg.productmanagement.domain.ProductVO;
import com.ssg.productmanagement.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductManagementMapperTests {
    @Autowired(required = false)
    private ProductManagementMapper productManagementMapper;

    @Test
    public void testGetTime() {
        log.info(productManagementMapper.getTime());
    }

    @Test
    public void testInsert() {
        ProductVO productVO = ProductVO.builder()
                .name("감자깡")
                .price(1300L)
                .quantity(267)
                .build();
        productManagementMapper.insert(productVO);
    }

    @Test
    public void testSelectAll() {
        List<ProductVO> list = productManagementMapper.selectAll();
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        ProductVO vo = productManagementMapper.selectOne(3L);
        log.info(vo);
    }

    @Test
    public void testDelete() {
        productManagementMapper.delete(3L);
    }

    @Test
    public void testUpdate() {
        productManagementMapper.update(productManagementMapper.selectOne(1L));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<ProductVO> voList = productManagementMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }
    /*mapper test 주석 1*/
    /* mapper test 주석 2 */
    /* mapper test 주석 3 */
}
