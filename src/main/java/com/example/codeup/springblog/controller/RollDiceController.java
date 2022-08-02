package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String pickANumber() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String returnDiceRollResults(@PathVariable String number, Model vModel) {
        Random rn = new Random();
        int roll = (int)Math.floor(Math.random()*(6-1+1)) +1;
        vModel.addAttribute("roll", roll);
        vModel.addAttribute("number", number);
        return "roll-dice-n";

    }
}
