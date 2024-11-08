package com.app.controller;

import com.app.service.GreetMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetMsgController {

    @Autowired
    private GreetMsgService service;

    //handler methods below

    @RequestMapping("/welcome.htm")
    public String showHomePage(){
        return "home"; //lvn - logical view name
    }

    @RequestMapping("/greet.htm")
    public ModelAndView showGreetMsgPage() {
        //use the service
        String msg = service.generateGreetMsg();
        return new ModelAndView("result", "greetMsg", msg);
    }

    @RequestMapping("/psm.htm")
    public String showPersonalisedMsgPage(Model model){
        //use the service
        String greetMsg = service.generateGreetMsg();

        model.addAttribute("greetMsg", greetMsg);
        model.addAttribute("personName", "Manish Sikhawal");

        //return view name
        return "result";
    }





}
