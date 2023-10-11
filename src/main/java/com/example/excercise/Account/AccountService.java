package com.example.excercise.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account getAccount(String username, String password) {
        if (accountRepository.findById(username).isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Account not found");
        if (!accountRepository.findById(username).get().getPassword().equals(password))
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Password is wrong");
        return accountRepository.findById(username).get();
    }
    public List<Account> postAccount(Account account) {
        if (accountRepository.findById(account.getUsername()).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account existed");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        return accountRepository.saveAll(accounts);
    }
    public List<Account> editAccount(Account account) {
        if (accountRepository.findById(account.getUsername()).isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Account not found");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        accountRepository.deleteById(account.getUsername());
        return accountRepository.saveAll(accounts);
    }


}
