package model;

import java.util.Date;

public class Exam {

    private int examId;
    private String examName;

    public Exam() {
    }

    public Exam(int examId, String examName) {
        this.examId = examId;
        this.examName = examName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
