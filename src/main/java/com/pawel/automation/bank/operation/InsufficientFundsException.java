package com.pawel.automation.bank.operation;

import com.pawel.automation.bank.BankException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Insufficient Funds")
public class InsufficientFundsException extends BankException {
}
