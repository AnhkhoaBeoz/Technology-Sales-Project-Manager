package com.kb.quanlysanpham.service.Impl;

import com.kb.quanlysanpham.modal.Account;
import com.kb.quanlysanpham.modal.Role;
import com.kb.quanlysanpham.service.AccountService;
import com.kb.quanlysanpham.service.LoginService;
import com.kb.quanlysanpham.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service

public class LoginServiceImpl implements LoginService {
    private AccountService accountService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;


    public LoginServiceImpl(AccountService accountService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void register(String username, String email, String password, String confirmPassword, String fullName, String address, String phone) {
        Role role = roleService.findRoleByName("ROLE_USER");
        if (role == null) {
            role = Role.builder().name("ROLE_USER").build();
            this.roleService.saveRole(role);
        }
        Account user = Account.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .fullName(fullName)
                .address(address)
                .phone(phone)
                .roles(Collections.singleton(role))
                .build();
        this.accountService.saveAccount(user);
    }
}
