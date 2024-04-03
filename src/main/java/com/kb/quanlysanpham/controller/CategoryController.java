package com.kb.quanlysanpham.controller;

import com.kb.quanlysanpham.Constants.AppConstant;
import com.kb.quanlysanpham.modal.Category;
import com.kb.quanlysanpham.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category-add";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "category-add";
        }
        if (category.getId() != null) {
            Category category1 = categoryService.findCategoryById(category.getId());
            category1.setName(category.getName());
            categoryService.saveCategory(category1);
        } else {
            categoryService.saveCategory(category);
        }
        redirectAttributes.addFlashAttribute("message", AppConstant.MESSAGE_CATEGORY_SAVED_SUCCESSFULLY);
        return "redirect:admin/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoryService.deleteCategoryById(id);
        redirectAttributes.addFlashAttribute("message", AppConstant.MESSAGE_CATEGORY_DELETED_SUCCESSFULLY);
        return "redirect:admin/category";
    }

    @GetMapping("/data")
    public String dataCategory(Model model) {
        categoryService.saveCategory(Category.builder()
                .name("Điện thoại di động")
                .description("Danh mục chứa các sản phẩm điện thoại di động và máy tính bảng")
                .build());

        categoryService.saveCategory(Category.builder()
                .name("Laptop và máy tính để bàn")
                .description("Danh mục chứa các sản phẩm laptop và máy tính để bàn")
                .build());

        categoryService.saveCategory(Category.builder()
                .name("Smartwatch")
                .description("Danh mục chứa các sản phẩm smartwatch và đồng hồ thông minh")
                .build());

        categoryService.saveCategory(Category.builder()
                .name("Gaming")
                .description("Danh mục chứa các sản phẩm gaming và thiết bị chơi game")
                .build());

        categoryService.saveCategory(Category.builder()
                .name("Phụ kiện")
                .description("Danh mục chứa các sản phẩm phụ kiện điện thoại, máy tính, laptop")
                .build());
        return "redirect:/category";
    }
}
