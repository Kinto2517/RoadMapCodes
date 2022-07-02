package com.example.atmproject.service.imp;

import com.example.atmproject.model.Account;
import com.example.atmproject.repository.AccountRepository;
import com.example.atmproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountServiceImp implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void deposit(int id, double amount) {
        Account account = accountRepository.findById(id).get();
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        }
    }

    @Override
    public void withdraw(int id, double amount) {
        Account account = accountRepository.findById(id).get();
        if (account != null) {
            if(account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            }else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        }

    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, double amount) {

        Account fromAccount = accountRepository.findById(fromAccountId).get();
        Account toAccount = accountRepository.findById(toAccountId).get();
        if (fromAccount != null && toAccount != null) {
            if(fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                accountRepository.save(fromAccount);
                accountRepository.save(toAccount);
            }else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        }

    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}

