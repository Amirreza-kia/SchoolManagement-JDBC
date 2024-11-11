package service;

import java.sql.SQLException;

public interface CourseService {

    void createCourse(int courseId,String courseTitle,int courseUnit) throws SQLException;
    void updateCourse(int courseId,String courseTitle,int courseUnit) throws SQLException;
    void deleteCourse(int courseId) throws SQLException;
}
