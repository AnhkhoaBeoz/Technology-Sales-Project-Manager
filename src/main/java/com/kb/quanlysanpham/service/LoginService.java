package com.kb.quanlysanpham.service;

public interface LoginService {
    void register(String username, String email, String password, String confirmPassword, String fullName, String address, String phone);
}
