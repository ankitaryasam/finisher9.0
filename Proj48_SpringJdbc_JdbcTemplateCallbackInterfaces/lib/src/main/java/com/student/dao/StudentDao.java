package com.student.dao;

import com.student.entity.StudentEntity;

public interface StudentDao {
    public StudentEntity getStudentById(int id) throws Exception;
}
