package com.ssg.productmanagement.controller;

import com.ssg.productmanagement.dto.ProductDTO;
import com.ssg.productmanagement.service.ProductManagementService;
import com.ssg.productmanagement.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/productmanagement")
@Log4j2
@RequiredArgsConstructor
public class ProductManagementController {
    private final ProductManagementService productManagementService;

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("product management list.........");

        if(bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }

       model.addAttribute("responseDTO", productManagementService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("product management register get.......");
    }

    @PostMapping("/register")
    public String registerPost(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("product management register post......");

        if(bindingResult.hasErrors()) {
            log.info("has errors....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/productmanagement/register";
        }

        log.info(productDTO);
        productManagementService.register(productDTO);

        return "redirect:/productmanagement/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long pno, PageRequestDTO pageRequestDTO, Model model) {
        ProductDTO productDTO = productManagementService.getOne(pno);
        log.info(productDTO);

        model.addAttribute("dto", productDTO);
    }

    @PostMapping("/remove")
    public String remove(Long pno, RedirectAttributes redirectAttributes) {
        log.info("---------remove-----------");
        log.info("pno: " + pno);
        productManagementService.remove(pno);

        return "redirect:/productmanagement/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("has errors....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("dto", productDTO.getPno());
            return "redirect:/productmanagement/modify";
        }
        log.info(productDTO);
        productManagementService.modify(productDTO);
        return "redirect:/productmanagement/list";
    }

}
