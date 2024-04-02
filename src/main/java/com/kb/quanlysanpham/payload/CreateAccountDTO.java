package com.kb.quanlysanpham.payload;

import com.kb.quanlysanpham.modal.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateAccountDTO {

    @Size(min = 5, max = 50, message = "Tên đăng nhập phải có từ 5 đến 50 ký tự")
    private String username;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Mật khẩu không được trống")
    private String password;
    @Size(min = 5, max = 50, message = "Họ tên phải có từ 5 đến 50 ký tự")
    private String fullName;
    @Size(min = 5, max = 50, message = "Địa chỉ phải có từ 5 đến 50 ký tự")
    private String address;
    @Pattern(regexp = "0[0-9]{9,10}", message = "Số điện thoại không hợp lệ")
    private String phone;
    private Role role;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(String username, String email, String password, String fullName, String address, String phone, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}