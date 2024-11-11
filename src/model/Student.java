package model;

import java.util.Date;

public class Student {
    private int studentId;
    private String studentFirstname;
    private String studentLastname;
    private int gpu;
    private String nationalCode;



    public Student() {}

    public Student(int studentId, String studentFirstname, String studentLastname, int gpu, String nationalCode) {
        this.studentId = studentId;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.gpu = gpu;
        this.nationalCode = nationalCode;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }


    public int getGpu() {
        return gpu;
    }

    public void setGpu(int gpu) {
        this.gpu = gpu;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
    @Override
    public String toString() {
        return "| Student " +
                "\t | studentId       =" + studentId +
                "\t | studentFirstname='" + studentFirstname +
                "\t | studentLastname ='" + studentLastname +
                "\t | gpu             =" + gpu +
                "\t | nationalCode    ='" + nationalCode +
                '|';

    }
}
