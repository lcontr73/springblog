package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleViewController {

    @GetMapping("/helloworld")
    public String returnHelloWorld(Model vModel) {
        vModel.addAttribute("name", "Bob");
        return "/hello-world";
    }

    @GetMapping("/search")
    public String returnSearchForm() {
        return "/search";
    }

    @PostMapping("/search")
    public String returnSearchResults(@RequestParam String query, Model vModel) {
        vModel.addAttribute("search", query);
        return "/search-results";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/login";
    }

    @PostMapping("/login")
    public String processLogin() {
        //authenticate user
        return "redirect:/";
    }


}
