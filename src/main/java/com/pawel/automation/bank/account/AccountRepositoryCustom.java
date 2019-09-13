package com.pawel.automation.bank.account;

import java.util.Optional;

public interface AccountRepositoryCustom {

    Optional<Account> getByNumber(String accountNumber);

}