package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/firstview")
    String returnFirstView(Model vModel){
        vModel.addAttribute("name", "Steve");
        return "first-view";
    }

    @GetMapping("/fav-city")
    public String returnCityForm() {
        return "fav-city";
    }

    @PostMapping("/fav-city")
    public String returnSearchResults(@RequestParam String query, Model vModel) {
        vModel.addAttribute("city", query);
        return "city-results";
    }
}
