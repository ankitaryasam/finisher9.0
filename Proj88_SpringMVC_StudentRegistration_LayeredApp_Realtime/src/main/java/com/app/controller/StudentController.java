package com.app.controller;


import com.app.model.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/registration")
    public String showStudentRegistrationPage(@ModelAttribute("student")Student student){
        student.setCourse("springboot");

        //return lvn
        return "student_reg_form";
    }


    @PostMapping("/registration")
    public String registerNewStudent(Map<String, Object> map, @ModelAttribute("student") Student student){
       String status = studentService.registerNewStudent(student);

        map.put("resultData", status);

        return "result";
    }

}
