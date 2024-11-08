package com.app.service;

import java.util.Date;

public class GreetingMsgServiceImpl  implements GreetingMsgService {
    @Override
    public String generateGreetingMsg() {

        System.out.println("service method called");
        Date d = new Date();
        d.setYear(124);
        d.setMonth(9);
        d.setDate(19);

        if(d.getDate()==31){
            return "HAPPY DIWALI!";
        }
        else{
                return "HAPPY WORK DAY!";
        }

    }
}
