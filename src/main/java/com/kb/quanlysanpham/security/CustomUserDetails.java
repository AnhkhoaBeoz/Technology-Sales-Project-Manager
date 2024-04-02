package com.kb.quanlysanpham.security;


import com.kb.quanlysanpham.modal.Account;
import com.kb.quanlysanpham.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableWebSecurity
public class CustomUserDetails implements UserDetailsService {
    private AccountRepository accountRepository;

    public CustomUserDetails(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account getAccount = this.accountRepository.findAccountByUsername(username);
        if (getAccount == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthoritySet = getAccount.getRoles().stream().map(
                it -> new SimpleGrantedAuthority(it.getName())
        ).collect(Collectors.toSet());

        return new User(getAccount.getEmail(), getAccount.getPassword(), grantedAuthoritySet);
    }

}
