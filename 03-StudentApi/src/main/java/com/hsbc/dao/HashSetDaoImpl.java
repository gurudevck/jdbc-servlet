package com.hsbc.dao;

import com.hsbc.model.Student;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDaoImpl implements StudentDao {
    private Set<Student> set = new HashSet<>();

    @Override
    public boolean createStudent(Student student) throws IllegalArgumentException {
        boolean result = set.add(student);
        if(!result){
            throw new IllegalArgumentException("Student ["+student.getStudentId()+"] is already present.");
        }
        return result;
    }

    @Override
    public Student readStudentByStudentId(int studentId) {
        for(Student student : set){
            if(student.getStudentId() == studentId){
                return student;
            }
        }
        throw new IllegalArgumentException("Student ["+studentId+"] not found.");
    }

    @Override
    public Collection<Student> readAllStudents() {
        return set;
    }
}
