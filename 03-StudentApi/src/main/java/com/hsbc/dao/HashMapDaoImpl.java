package com.hsbc.dao;

import com.hsbc.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDaoImpl implements StudentDao{
    private Map<Integer, Student> map = new HashMap<>();
    
    @Override
    public boolean createStudent(Student student) throws IllegalArgumentException {
        return false;
    }

    @Override
    public Student readStudentByStudentId(int studentId) {
        return null;
    }

    @Override
    public Collection<Student> readAllStudents() {
        return List.of();
    }
}
