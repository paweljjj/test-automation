package com.pawel.automation.bank.account;

import com.pawel.automation.bank.generator.AccountNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Log
@AllArgsConstructor
public class AccountService {

    private AccountNumberGenerator accountNumberGenerator;
    private AccountRepository accountRepository;

    public Account createAccount() {
        String accountNumber = accountNumberGenerator.getNext();
        Account account = new Account(accountNumber);
        return accountRepository.save(account);
    }

    public Account getAccountByNumber(String number) {
        return accountRepository.getByNumber(number)
                .orElseThrow(AccountNotFoundException::new);
    }

    public void deleteAccount(String number) {
        Account account = getAccountByNumber(number);
        accountRepository.delete(account);
    }

}