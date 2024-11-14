package com.app.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ServletConfig servletConfig;

    @RequestMapping("/register")
    public String registerStudent(){
      return "student_registration";
    }

    @RequestMapping("/get-student")
    public String getStudentList(HttpSession session, HttpServletRequest req){
        System.out.println("get---student---method");

        System.out.println("web app name : " +  servletContext.getContextPath());
        System.out.println("dispatcher servlet logical name " + servletConfig.getServletName());
        System.out.println("session id " + session.getId());

        System.out.println("request uri : " + req.getRequestURI());
        return "student-list";
    }


    @RequestMapping("/get-student-data")
    public String getStudentData(Map<String, Object> map){
        //create the model data
        map.put("name", "Manish Verma");
        map.put("course", "Spring Boot");

        //return the logical view name
        return "student-info";
    }


    @RequestMapping("/student-details")
    public String showStudentDetails(Map<String, Object> map){
        //collection data
        String name="Amit Kumar";
        List<String> courseEnrolled = List.of("spring boot", "microservices", "hibernate");
        Set<Long> phoneNumbers = Set.of(9876543211L, 1234567890L );
        Map<String, Integer> examMarks = Map.of("spring boot", 89, "microservices", 37);
        String accessCoupons[] = new String[]{"NEW10", "FIRST20", "EARLY15"};

        map.put("name", name);
        map.put("courseEnrolled", courseEnrolled);
        map.put("phoneNumbers", phoneNumbers);
        map.put("examMarks",examMarks);
        map.put("accessCoupons", accessCoupons);

        //return the logical view name
        return "student-info";
    }



}
