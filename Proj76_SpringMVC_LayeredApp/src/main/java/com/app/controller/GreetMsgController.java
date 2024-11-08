package com.app.controller;

import com.app.service.GreetingMsgService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GreetMsgController implements Controller {

    private GreetingMsgService greetingMsgService;

    public GreetMsgController(GreetingMsgService greetingMsgService) {
        this.greetingMsgService = greetingMsgService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        view name====> result  model(data) --> service
       String msg = greetingMsgService.generateGreetingMsg();
       ModelAndView modelAndView = new ModelAndView("result","greetMsg",msg);
       return modelAndView;
    }
}
