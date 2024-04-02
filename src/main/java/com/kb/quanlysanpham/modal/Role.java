package com.kb.quanlysanpham.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "role", indexes = {@Index(name = "idx_name", columnList = "name")})
@Builder

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "ROLE_[A-Z]+", message = "Tên Role phải bắt đầu bằng ROLE_ và viết hoa")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

    public Role() {
    }

    public Role(Long id, String name, Set<Account> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}