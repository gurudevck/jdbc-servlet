package com.hsbc.dao;

import com.hsbc.model.Student;

import java.util.Collection;

public interface StudentDao {
    // CRUD
    public boolean createStudent(Student student)throws IllegalArgumentException;
    public Student readStudentByStudentId(int studentId);
    public Collection<Student> readAllStudents();
}
