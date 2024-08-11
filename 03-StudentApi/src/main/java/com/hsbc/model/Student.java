package com.hsbc.model;

public class Student {
    private int studentId;
    private String studentName;
    private double studentScore;

    public Student(){
    }
    public Student(int studentId, String studentName, double studentScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentScore = studentScore;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public double getStudentScore() {
        return studentScore;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentScore=" + studentScore +
                '}';
    }

}
