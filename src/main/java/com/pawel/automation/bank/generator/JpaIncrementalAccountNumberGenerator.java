package com.pawel.automation.bank.generator;

import lombok.Setter;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.atomic.AtomicLong;

public class JpaIncrementalAccountNumberGenerator implements AccountNumberGenerator {

    private static final String ACCOUNT_NUMBER_FORMAT = "%026d";

    @Setter
    private AtomicLong counter = new AtomicLong();

    public String getNext() {
        return String.format(ACCOUNT_NUMBER_FORMAT, counter.incrementAndGet());
    }

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(a.number) from Account a";

    public JpaIncrementalAccountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        String lastAccountNumber = entityManagerFactory.createEntityManager()
                .createQuery(SELECT_LAST_ACCOUNT_NUMBER, String.class)
                .getSingleResult();
        if (lastAccountNumber != null) {
            setCounter(new AtomicLong(Long.parseLong(lastAccountNumber)));
        }
    }

}