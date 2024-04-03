package com.kb.quanlysanpham.controller.user;

import com.kb.quanlysanpham.service.CategoryService;
import com.kb.quanlysanpham.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/product")
public class UserProductController {

    private ProductService productService;

    private CategoryService categoryService;

    public UserProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showProduct(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAll());
        return "user-product";
    }

    @GetMapping("/category/{categoryId}")
    public String showProductsByCategory(@PathVariable Long categoryId, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findProductByCategory(categoryId));
        return "user-product";
    }
}
