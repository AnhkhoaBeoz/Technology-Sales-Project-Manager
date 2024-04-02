package com.kb.quanlysanpham.repository;

import com.kb.quanlysanpham.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAll();

    public Product findByProductName(String name);

    public Product findProductById(Long id);

    public void deleteProductById(Long id);

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    public List<Product> findProductByCategory(Long id);
}
