package com.kb.quanlysanpham.payload;

import com.kb.quanlysanpham.Constants.AppConstant;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    @NotBlank(message = AppConstant.EMAIL_OR_USERNAME_BLANK_MESSAGE)
    private String username;

    @NotBlank(message = AppConstant.PASSWORD_BLANK_MESSAGE)
    private String password;

    public LoginRequestDTO() {
    }


    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
}
