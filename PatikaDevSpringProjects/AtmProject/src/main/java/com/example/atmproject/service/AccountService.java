package com.example.atmproject.service;

import com.example.atmproject.model.Account;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface AccountService {
    void deposit(int id, double amount);
    void withdraw(int id, double amount);

    void transfer(int fromAccountId, int toAccountId, double amount);

    Collection<Account> getAllAccounts();

    void delete(int id);

    Account getAccountById(int id);

    void saveAccount(Account account);
}
