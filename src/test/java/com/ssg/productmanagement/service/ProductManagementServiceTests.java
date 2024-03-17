package com.ssg.productmanagement.service;

import com.ssg.productmanagement.dto.ProductDTO;
import com.ssg.productmanagement.dto.PageRequestDTO;
import com.ssg.productmanagement.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class) // 'spring-test' used in Junit5
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ProductManagementServiceTests {
    @Autowired
    private ProductManagementService productManagementService;

    @Test
    public void testRegister() throws Exception{
        ProductDTO productDTO = ProductDTO.builder()
                .name("마이쮸")
                .price(800L)
                .quantity(1500)
                .build();
        productManagementService.register(productDTO);
    }
    
    @Test
    public void testModify() throws Exception{
        ProductDTO productDTO = ProductDTO.builder()
                .pno(2L)
                .name("LG gram")
                .price(1200000L)
                .quantity(300)
                .build();
        productManagementService.modify(productDTO);
    }

    @Test
    public void testRemove() throws Exception{
        productManagementService.remove(4L);
    }

    @Test
    public void testPaging() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(5)
                .build();
        PageResponseDTO<ProductDTO> responseDTO = productManagementService.getList(pageRequestDTO);
        log.info(responseDTO);
        responseDTO.getDtoList().stream().forEach(productDTO -> log.info(productDTO));
    }

}


