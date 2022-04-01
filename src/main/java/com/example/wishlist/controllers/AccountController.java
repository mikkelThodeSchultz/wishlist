package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class AccountController
{
    // simulates the db
    private ArrayList<String> userNames = new ArrayList<>(Arrays.asList("", "a", "ab", "abc"));

    @GetMapping("/account")
    public String start(Model model)
    {
        model.addAttribute("userNames", userNames);
        return "account";
    }

    @PostMapping("/account")
    public String createLogin(WebRequest account, Model model)
    {
        String user = account.getParameter("userName");
        userNames.add(user);
        model.addAttribute("userNames", userNames);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String accountCreated() {
        return "/login";
    }
}
