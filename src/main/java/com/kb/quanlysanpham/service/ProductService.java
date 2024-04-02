package com.kb.quanlysanpham.service;

import com.kb.quanlysanpham.modal.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findProductByName(String name);

    public Product findProductById(Long id);
    public void deleteProduct(Product product);

    public void deleteProductById(Long id);

    public void saveProduct(Product product);


    public List<Product> findProductByCategory(Long id);

}
