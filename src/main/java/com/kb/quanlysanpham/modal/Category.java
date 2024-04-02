package com.kb.quanlysanpham.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 3, max = 50, message = "Tên danh mục phải từ 3 đến 50 ký tự")
    private String name;

    @Size(min = 3, max = 255, message = "Mô tả phải từ 3 đến 255 ký tự")
    private String description;

    public Category() {
    }

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}