package com.example.excercise.Content;

import com.example.excercise.Account.Account;
import com.example.excercise.Account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContentService {
    private final AccountRepository accountRepo;

    private final ContentRepository contentRepository;
    @Autowired
    public ContentService(ContentRepository contentRepository, AccountRepository accountRepo) {
        this.contentRepository = contentRepository;
        this.accountRepo = accountRepo;
    }



    public Content post(Content content, Account account) {
        if (contentRepository.findById(content.getName()).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Account Existed");
        if (contentRepository.findById(content.getAuthor()).isPresent())
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid author field");
        if (accountRepo.findById(account.getUsername()).equals(accountRepo.findById(account.getPassword())))
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Password is wrong");
        return contentRepository.save(content);
    }
}
