package com.pawel.automation.bank.operation;

import com.pawel.automation.bank.account.Account;

public class WithdrawOperation implements Operation {

    @Override
    public void execute(Account account, long funds) {
        if (account.getBalance() < funds) {
            throw new InsufficientFundsException();
        }
        account.withdraw(funds);
    }

}