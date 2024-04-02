package com.kb.quanlysanpham.repository;

import com.kb.quanlysanpham.modal.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findAll();
    public Category findCategoryByName(String name);

    public Category findCategoryById(Long id);

    public void deleteCategoryById(Long id);

}
