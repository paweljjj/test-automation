package com.pawel.automation.bank.disposition;

import com.pawel.automation.bank.account.Account;
import com.pawel.automation.bank.account.AccountNotFoundException;
import com.pawel.automation.bank.account.AccountRepository;
import com.pawel.automation.bank.operation.Operation;
import com.pawel.automation.bank.operation.UnknownOperationException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@AllArgsConstructor
public class DispositionService {

    private AccountRepository accountRepository;
    private Map<String, Operation> operations;

    public void process(Disposition disposition) {
        Account account = getAccount(disposition.getAccountNumber());
        Operation operation = getOperation(disposition.getOperationName());
        operation.execute(account, disposition.getFunds());
        accountRepository.save(account);
    }

    private Account getAccount(String accountNumber) {
        return accountRepository.getByNumber(accountNumber)
                .orElseThrow(AccountNotFoundException::new);
    }

    private Operation getOperation(String operationName) {
        if (operationName == null || !operations.containsKey(operationName)) {
            throw new UnknownOperationException();
        }
        return operations.get(operationName);
    }

}