package com.kb.quanlysanpham.controller.user;

import com.kb.quanlysanpham.service.CategoryService;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
