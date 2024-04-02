package com.kb.quanlysanpham.service;

import com.kb.quanlysanpham.modal.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();
    public Category findCategoryByName(String name);


    public Category findCategoryById(Long id);


    public void saveCategory(Category category);

    public void deleteCategoryById(Long id);
}
