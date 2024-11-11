package repository;

import db.Database;
import exception.CourseNotFoundException;
import model.Course;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository implements BaseRepository<Course> {


    @Language("SQL")
    private static final String FIND_ALL_COURSES_SQL = "SELECT * FROM schoolsystemmanagment.public.course";
    @Language("SQL")
    private static final String FIND_COURSE_BY_ID = "select * from schoolsystemmanagment.public.course where course_id =?";
    @Language("SQL")
    private static final String INSERT_COURSE_QUERY = "insert into schoolsystemmanagment.public.course(course_id," +
            " course_title, course_unit)\n" + "values (?,?,?)";
    @Language("SQL")
    private static final String UPDATE_COURSE_QUERY = "update schoolsystemmanagment.public.course set course_title=? , course_unit=?" +
            " where course_id = ?";
    @Language("SQL")
    private static final String DELETE_COURSE_QUERY = "delete from schoolsystemmanagment.public.course where course_id = ?";

    Database database = new Database();



    @Override
    public Optional<Course> findById(int courseId) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_COURSE_BY_ID);
        ps.setInt(1,courseId);
        ResultSet rs = ps.executeQuery();
        Optional<Course> optionalCourse = Optional.empty();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseTitle(rs.getString("course_title"));
            course.setCourseUnit(rs.getInt("course_unit"));
            optionalCourse = Optional.of(course);
        }
        return optionalCourse;

    }

    @Override
    public List<Course> findAll() throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(FIND_ALL_COURSES_SQL);
        ResultSet rs = ps.executeQuery();
        List<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setCourseTitle(rs.getString("course_title"));
            course.setCourseUnit(rs.getInt("course_unit"));
            courses.add(course);
        }
        return courses;
    }

    @Override
    public void persist(Course entity) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(INSERT_COURSE_QUERY);
        ps.setInt(1,entity.getCourseId());
        ps.setString(2,entity.getCourseTitle());
        ps.setInt(3,entity.getCourseUnit());
        ps.executeUpdate();
    }

    @Override
    public void update(Course entity) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(UPDATE_COURSE_QUERY);
        ps.setInt(3,entity.getCourseId());
        ps.setString(1, entity.getCourseTitle());
        ps.setInt(2, entity.getCourseUnit());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
            PreparedStatement ps = database.getPreparedStatement(DELETE_COURSE_QUERY);
            ps.setInt(1, id);
            ps.executeUpdate();

    }

}
