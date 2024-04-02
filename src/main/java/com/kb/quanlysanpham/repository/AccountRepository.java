package com.kb.quanlysanpham.repository;

import com.kb.quanlysanpham.modal.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByEmail(String email);
    Account findAccountByUsername(String username);
    Account findAccountById(Long id);
}
