package com.hsbc.factory;

import com.hsbc.dao.ArrayListDaoImpl;
import com.hsbc.dao.StudentDao;

public class StudentDaoFactory {
    private static StudentDao dao = null;
    private static StudentDaoFactory instance = null;

    private StudentDaoFactory(){
    }
    public static StudentDaoFactory getInstance(){
        if(instance == null){
            instance = new StudentDaoFactory();
        }
        return instance;
    }
    public  StudentDao createStudentDao(int ch){
        if(ch ==1){
            dao = new ArrayListDaoImpl();
        } else if (ch == 2) {

        }
        return dao;
    }

}
