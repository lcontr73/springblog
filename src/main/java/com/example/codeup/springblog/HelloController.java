package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Establishes that this class is a controller.
@Controller
public class HelloController {
    //Establishes the URL Pattern we are listening for (specifically a Get request)
    @GetMapping("/hello")
    //Establishes what the body of the response will be.
    @ResponseBody
    //Defines what the response body will be.
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "This is a different mapping!";
    }

   // @GetMapping("/increment/{number}")
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one = " + (number +1) + "!";
    }

}
