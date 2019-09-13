package com.pawel.automation.bank.operation;

import com.pawel.automation.bank.account.Account;

public interface Operation {

    void execute(Account account, long funds);

}