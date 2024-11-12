package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

//    @RequestMapping("/welcome")
//    public String showHomePage(){
//        return "home";
//    }


//    @RequestMapping
    @RequestMapping("/")
    public String showDefaultHomePage(){
        return "home";
    }

    //by default - GET METHOD
    @RequestMapping("/register")
    public String saveStudentData(){
        return "result";
    }

    // explicitly mentioned - POST method
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveStudentData2(){
        return "result2";
    }

    @RequestMapping(value = {"/home", "/welcome", "/manish", "/index"})
    public String showHomePage2(){
        return "home";
    }
}
