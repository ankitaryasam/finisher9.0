package com.app.controller;

import com.app.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StudentController {

    @GetMapping("/get-student")
    public String getStudentData(Map<String, Object> map,
                                 @RequestParam("id") Integer id,
                                 @RequestParam("name") String name
                                 ){

        map.put("sid", id);
        map.put("sname", name);

        return "result";

    }


}
