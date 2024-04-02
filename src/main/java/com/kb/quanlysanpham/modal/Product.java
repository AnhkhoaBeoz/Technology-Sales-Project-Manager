package com.kb.quanlysanpham.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "Products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Tên sản phẩm phải từ 3 đến 50 ký tự")
    private String productName;
    @Size(min = 3, max = 255, message = "Mô tả phải từ 3 đến 255 ký tự")
    private String description;

    @DecimalMin(value = "0.0", inclusive = false, message = "Giá sản phẩm phải là số")
    private Double price;

    @Lob
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }



    public Product(String productName, String description, Double price, Category category) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String productName, String description, Double price, String image, Category category) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
