package com.pawel.automation.bank.account;

import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepositoryCustom {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Account> getByNumber(String accountNumber) {
        try {
            return Optional.of(entityManager.createNamedQuery(Account.SELECT_ACCOUNT_BY_NUMBER, Account.class)
                    .setParameter("number", accountNumber)
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

}