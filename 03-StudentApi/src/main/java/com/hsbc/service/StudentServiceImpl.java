package com.hsbc.service;

import com.hsbc.dao.StudentDao;
import com.hsbc.exceptions.DuplicateStudentException;
import com.hsbc.exceptions.InvalidStudentIdException;
import com.hsbc.model.Student;

import java.util.Collection;

public class StudentServiceImpl implements StudentService{
    // this will make service layer tiet-coupled coupled with dao layer
    //private StudentDao dao = new StudentDaoArrayImpl();
    private StudentDao dao = null;

    // help us to set-up dependency
    public void setDao(StudentDao dao){
        this.dao = dao;
    }

    @Override
    public boolean addStudent(Student student)throws DuplicateStudentException {
        try {
            boolean result = dao.createStudent(student);
            return result;
        }
        catch (IllegalArgumentException e){
            throw new DuplicateStudentException(e.getMessage(), e);
        }
    }
    @Override
    public Student findStudentById(int studentId) throws InvalidStudentIdException{
        try{
            Student result = dao.readStudentByStudentId(studentId);
            return result;
        }catch (IllegalArgumentException e){
            throw new InvalidStudentIdException(e.getMessage(), e);
        }
    }
    @Override
    public Collection<Student> findAllStudents() {
        return dao.readAllStudents();
    }
}
