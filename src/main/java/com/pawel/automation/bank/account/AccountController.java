package com.pawel.automation.bank.account;

import com.pawel.automation.bank.common.Mapper;
import com.pawel.automation.bank.common.UriBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/accounts", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
@RestController
public class AccountController {

    @NonNull
    private Mapper mapper;
    @NonNull
    private AccountService accountService;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount() {
        Account account = accountService.createAccount();
        URI uri = uriBuilder.requestUriWithId(account.getId());
        return ResponseEntity.created(uri).body(mapper.map(account, AccountDto.class));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AccountDto getByNumber(@PathVariable("id") String number) {
        Account account = accountService.getAccountByNumber(number);
        return mapper.map(account, AccountDto.class);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccountByNumber(@PathVariable("id") String number) {
        accountService.deleteAccount(number);
        return ResponseEntity.noContent().build();
    }

}