package com.kb.quanlysanpham.service;

import com.kb.quanlysanpham.modal.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountService {
    Account findById(Long id);
    void saveOrUpdate(Account account);
    List<Account> findAll();
    Account findAccountByEmail(String email);
    Account findAccountByUsername(String username);
    void saveAccount(Account account);
    void deleteAccount(Long id);
}
