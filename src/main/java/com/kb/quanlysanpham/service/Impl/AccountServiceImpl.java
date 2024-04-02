package com.kb.quanlysanpham.service.Impl;

import com.kb.quanlysanpham.modal.Account;
import com.kb.quanlysanpham.repository.AccountRepository;
import com.kb.quanlysanpham.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account findAccountByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);

    }

    @Override
    public Account findById(Long id) {
        return this.accountRepository.findAccountById(id);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    @Override
    public void saveOrUpdate(Account account) {
        if (account != null) {
            this.accountRepository.save(account);
        }
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        this.accountRepository.deleteById(id);
    }
}
