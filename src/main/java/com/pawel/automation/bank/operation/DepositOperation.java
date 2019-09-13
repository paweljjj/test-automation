package com.pawel.automation.bank.operation;

import com.pawel.automation.bank.account.Account;

public class DepositOperation implements Operation {

    @Override
    public void execute(Account account, long funds) {
        account.deposit(funds);
    }

}