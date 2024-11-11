package service.impi;

import model.Course;
import repository.CourseRepository;
import service.CourseService;
import util.ApplicationContext;

import java.sql.SQLException;

public class CourseServiceImpi implements CourseService {

    @Override
    public void createCourse(int courseId,String courseTitle,int courseUnit) throws SQLException {
        Course course = new Course(courseId,courseTitle,courseUnit);
        ApplicationContext.courseRepository.persist(course);
    }


    @Override
    public void updateCourse(int courseId,String courseTitle,int courseUnit) throws SQLException {
        Course course = new Course(courseId,courseTitle,courseUnit);
        ApplicationContext.courseRepository.update(course);
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        ApplicationContext.courseRepository.delete(courseId);
    }


}
