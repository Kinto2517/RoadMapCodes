package com.example.atmproject.controller;


import com.example.atmproject.model.Account;
import com.example.atmproject.model.User;
import com.example.atmproject.service.AccountService;
import com.example.atmproject.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showAccount(Model model) {

        Collection<Account> accounts = accountService.getAllAccounts();

        model.addAttribute("accounts", accounts);

        return "account";
    }

    @GetMapping("/addForm")
    public String addReport(Model model) {

        Account account = new Account();
        List<User> users = userService.getAllUsers();
        account.setBalance(0);

        model.addAttribute("account", account);
        model.addAttribute("users", users);
        return "addAccountForm";

    }

    @PostMapping("/addAccount")
    public String addReport(@ModelAttribute("report") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "addAccountForm";
        }

        accountService.saveAccount(account);

        return "redirect:/account";
    }

    @GetMapping("/detail")
    public String showAccountDetail(@RequestParam("id") int id, Model model) {

        Account account = accountService.getAccountById(id);

        model.addAttribute("account", account);

        return "details";
    }

    @GetMapping("/deposit")
    public String deposit(@RequestParam("amount") double amount,@RequestParam ("id") int id) {

        if (amount > 0) {
            accountService.deposit(id, amount);
        }
        return "redirect:/account";
    }

    @GetMapping("/withdraw")
    public String withdraw(@RequestParam("amount") double amount,@RequestParam ("id") int id) {

        if (amount > 0) {
            accountService.withdraw(id, amount);
        }
        return "redirect:/account";
    }

    @GetMapping("/transfer")
    public String transfer(@RequestParam("amount") double amount,@RequestParam ("fromAccountId") int fromAccountId,@RequestParam ("toAccountId") int toAccountId) {

        if (amount > 0) {
            accountService.transfer(fromAccountId, toAccountId, amount);
        }
        return "redirect:/account";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {

        accountService.delete(id);
        return "redirect:/account";
    }



}
