package com.kb.quanlysanpham.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {
    @NotBlank(message = "Tên đăng nhập không được trống")
    private String username;
    @NotBlank(message = "Mật khẩu không được trống")
    private String password;
    @NotBlank(message = "Mật khẩu xác nhận không được trống")

    private String confirmPassword;
    @NotBlank(message = "Email không được trống")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Họ tên không được trống")
    @Size(min = 5, max = 50, message = "Họ tên phải có từ 5 đến 50 ký tự")
    private String fullName;
    private String address;
    @NotBlank(message = "Số điện thoại không được trống")
    @Size(min = 10, max = 11, message = "Số điện thoại phải có từ 10 đến 11 số")
    @Pattern(regexp = "0[0-9]{9,10}", message = "Số điện thoại không hợp lệ")
    private String phone;

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String username, String password, String confirmPassword, String email, String fullName, String address, String phone) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
}
