package com.app.dao;

import com.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{

    private static final String INSERT_STUDENT="INSERT into student_table_mvc VALUES(?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveStudent(Student student) {

       int rowCountAffected = jdbcTemplate.update(INSERT_STUDENT,
                student.getId(), student.getName(), student.getEmail(), student.getCourse()
                );
     return  rowCountAffected;
    }
}
