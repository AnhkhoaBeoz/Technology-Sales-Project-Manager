package com.kb.quanlysanpham.service.Impl;

import com.kb.quanlysanpham.Utils.FileUtil;
import com.kb.quanlysanpham.modal.Category;
import com.kb.quanlysanpham.modal.Product;
import com.kb.quanlysanpham.repository.CategoryRepository;
import com.kb.quanlysanpham.repository.ProductRepository;
import com.kb.quanlysanpham.service.CategoryService;
import com.kb.quanlysanpham.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override

    public Product findProductByName(String name) {
        return productRepository.findByProductName(name);
    }

    @Override

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public void saveProduct(Product product) {
        Product product1 = productRepository.findByProductName(product.getProductName());
        if (product1 == null) {
            productRepository.save(product);
        } else {
            product1.setProductName(product.getProductName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            product1.setCategory(product.getCategory());
            product1.setImage(product.getImage());
            productRepository.save(product1);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findProductByCategory(Long id) {
        return productRepository.findProductByCategory(id);
    }

}
