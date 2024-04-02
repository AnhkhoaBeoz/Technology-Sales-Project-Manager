package com.kb.quanlysanpham.modal;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts", indexes = {@Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_username", columnList = "username")})
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên đăng nhập không được trống")
    @Size(min = 5, max = 50, message = "Tên đăng nhập phải có từ 5 đến 50 ký tự")
    private String username;

    @NotBlank(message = "Mật khẩu không được trống")
    @Size(min = 8, max = 100, message = "Mật khẩu phải có từ 8 đến 100 ký tự")
    private String password;

    @NotBlank(message = "Email không được trống")
    @Email(message = "Email không hợp lệ")
    @Column(unique = true)
    private String email;
    private String fullName;
    private String address;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
