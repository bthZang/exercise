package com.example.excercise.Account;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "auth")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
    public Account getUserName(@RequestBody ObjectNode account) {
        return accountService.getAccount(account.get("username").asText(), account.get("password").asText());
    }

    @PostMapping
    public List<Account> postUserName(@RequestBody Account account) {
        return accountService.postAccount(account);
    }

    @PutMapping
    public List<Account> editUserName(@RequestBody Account account) {
        return accountService.editAccount(account);
    }
}
