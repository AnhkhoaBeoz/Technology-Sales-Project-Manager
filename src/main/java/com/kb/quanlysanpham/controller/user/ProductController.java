package com.kb.quanlysanpham.controller.user;

import com.kb.quanlysanpham.service.CategoryService;
import com.kb.quanlysanpham.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/product")
public class ProductController {

    private ProductService productService;

    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "user/product";
    }
}
