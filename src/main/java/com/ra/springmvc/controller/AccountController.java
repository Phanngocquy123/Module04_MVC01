package com.ra.springmvc.controller;

import com.ra.springmvc.model.Account;
import com.ra.springmvc.model.StorageDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/login")
    public String login(){
        return "accounts/login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        model.addAttribute("account", new Account());
        return "accounts/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "accounts/signup";
        }

        LocalDate now = LocalDate.now();
        LocalDate birthDate = account.getBirthDay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDate, now);
        //System.out.println(period.getYears());
        if (period.getYears() < 18) {
            bindingResult.rejectValue("birthDay", "account.birthDay", "Người dùng phải đủ 18 tuổi.");
            return "accounts/signup";
        }

        Account acc = new Account();
        acc.setUserName(account.getUserName());
        acc.setPassword(account.getPassword());
        acc.setPhone(account.getPhone());
        acc.setBirthDay(account.getBirthDay());


        StorageDatabase.accounts.add(acc);
        return "redirect:/accounts/login";

    }
}
