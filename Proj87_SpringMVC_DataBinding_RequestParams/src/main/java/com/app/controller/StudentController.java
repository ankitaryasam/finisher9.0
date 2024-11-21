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

    @GetMapping("/read-student-data")
    public String readStudentData(Map<String, Object> map,
                                 @RequestParam("id") Integer id,
                                 @RequestParam(name = "course", required = false, defaultValue = "none") String course
    ){

        map.put("sid", id);
        map.put("course", course);

        return "result2";

    }

    /*
    @GetMapping("/read-student-data3")
    public String readStudentData2(Map<String, Object> map,
                                  @RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("courses") String courses
    ){

        map.put("sid", id);
        map.put("name", name);
        map.put("courses", courses);

        return "result3";

    }

    */
    @GetMapping("/read-student-data3")
    public String readStudentData2(Map<String, Object> map,
                                   @RequestParam("id") Integer id,
                                   @RequestParam("name") String name,
                                   @RequestParam("courses") String[] courses
    ){

        map.put("sid", id);
        map.put("name", name);
        map.put("courses", courses);

        return "result3";

    }

    @GetMapping("/read-student-data4")
    public String readStudentData4(Map<String, Object> map,
                                   @RequestParam(name = "id", required = false) Integer id,
                                   @RequestParam("name") String name){
        map.put("sid", id);
        map.put("sname", name);

        return "result";


    }



}
