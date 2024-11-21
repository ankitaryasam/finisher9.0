package com.app.service;

import com.app.dao.StudentDao;
import com.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public String registerNewStudent(Student student) {
        int i = studentDao.saveStudent(student);
        String status = "";
        if(i==0){
            status = "Student registration failed";
        }
        else{
            status ="Student registration successfull";
        }

        return status;
    }
}
