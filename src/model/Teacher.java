package model;

public class Teacher {
    private int teacherId;
    private String teacherFirstname;
    private String teacherLastname;
    private String nationalCode;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherFirstname, String teacherLastname, String nationalCode) {
        this.teacherId = teacherId;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.nationalCode = nationalCode;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "| Teacher " +
                "\t | teacherId       =" + teacherId +
                "\t | teacherFirstname=" + teacherFirstname +
                "\t | teacherLastname =" + teacherLastname +
                "\t | nationalCode    =" + nationalCode +
                '}';

    }
}
