package com.hsbc.service;

import com.hsbc.exceptions.DuplicateStudentException;
import com.hsbc.exceptions.InvalidStudentIdException;
import com.hsbc.model.Student;

import java.util.Collection;

public interface StudentService {
    public boolean addStudent(Student student)throws DuplicateStudentException;
    public Student findStudentById(int studentId)throws InvalidStudentIdException;
    public Collection<Student> findAllStudents();
}
