package com.example.chaloagain.services;

import com.example.chaloagain.models.Account;
import com.example.chaloagain.models.Authority;
import com.example.chaloagain.repositories.AccountRepository;
import com.example.chaloagain.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.saveAndFlush(account);

    }

    public Optional<Account> findByEmail(String email){
        return accountRepository.findOneByEmail(email);
    }

}
