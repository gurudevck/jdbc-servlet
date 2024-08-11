package com.hsbc.dao;

import com.hsbc.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDaoImpl implements StudentDao{
    private List<Student> list = new ArrayList<>();

    @Override
    public boolean createStudent(Student student) throws IllegalArgumentException {
        for(Student stud : list) {
            if (stud.getStudentId() == student.getStudentId()) {
                throw new IllegalArgumentException("Student is already present.");
            }
        }
        return list.add(student);
    }
    @Override
    public Student readStudentByStudentId(int studentId) {
        for(Student student : list){
            if(student.getStudentId() == studentId){
                return student;
            }
        }
        throw new IllegalArgumentException("Student ["+studentId+"] not found.");
    }
    @Override
    public Collection<Student> readAllStudents() {
        return list;
    }
}
