package com.kb.quanlysanpham.service.Impl;

import com.kb.quanlysanpham.modal.Category;
import com.kb.quanlysanpham.repository.CategoryRepository;
import com.kb.quanlysanpham.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public void saveCategory(Category category) {
        Category category1 = categoryRepository.findCategoryByName(category.getName());
        if (category1 == null) {
            categoryRepository.save(category);
        } else {
            category1.setName(category.getName());
            category1.setDescription(category.getDescription());
            categoryRepository.save(category1);
        }

    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteCategoryById(id);
    }
}
