package model;

public class Course {

    private int courseId;
    private String courseTitle;
    private int courseUnit;

    public Course() {
    }

    public Course(int courseId, String courseTitle, int courseUnit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseUnit = courseUnit;
    }

    public int getCourseId() {
        return courseId;
    }

    public  void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    @Override
    public String toString() {
        return "| Course "+
                "\t | courseId    = " + courseId +
                "\t | courseTitle = " + courseTitle +
                "\t | courseUnit  = " + courseUnit +  '|' ;
    }
}
