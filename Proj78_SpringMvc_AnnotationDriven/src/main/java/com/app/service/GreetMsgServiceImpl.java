package com.app.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service("greetMsgService")
public class GreetMsgServiceImpl implements GreetMsgService {
    @Override
    public String generateGreetMsg() {
        String greetMsg = null;
        Date d = new Date();
        d.setDate(7);

        if(d.getDate()==7){
            greetMsg = "HAPPY CHHATH PUJA!";
        }
        else {
            greetMsg = "HAPPY WORK DAY!";
        }

        return greetMsg;
    }
}
