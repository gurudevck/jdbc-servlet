package com.hsbc.exceptions;

public class InvalidStudentIdException extends Exception{
    public InvalidStudentIdException(){
        super();
    }
    public InvalidStudentIdException(String msg){
        super(msg);
    }
    public InvalidStudentIdException(String msg, Throwable t){
        super(msg, t);
    }
    public InvalidStudentIdException(Throwable t){
        super(t);
    }
}
