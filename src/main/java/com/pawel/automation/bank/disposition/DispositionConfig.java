package com.pawel.automation.bank.disposition;

import com.pawel.automation.bank.account.AccountRepository;
import com.pawel.automation.bank.operation.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class DispositionConfig {

    @Bean
    public DispositionService dispositionService(AccountRepository accountRepository, Map<String, Operation> operations) {
        return new DispositionService(accountRepository, operations);
    }

}
