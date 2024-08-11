package com.hsbc.exceptions;

public class DuplicateStudentException extends Exception{
    public DuplicateStudentException(){
        super();
    }
    public DuplicateStudentException(String msg){
        super(msg);
    }
    public DuplicateStudentException(String msg, Throwable t){
        super(msg, t);
    }
    public DuplicateStudentException(Throwable t){
        super(t);
    }
}
