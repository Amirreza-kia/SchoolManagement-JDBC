package repository;

import db.Database;
import model.Teacher;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherRepository implements BaseRepository<Teacher>{

    @Language("SQL")
    private static final String FIND_TEACHER_BY_ID = "select * from schoolsystemmanagment.public.teacher where teachers_id =?";
    @Language("SQL")
    private static final String FIND_ALL_TEACHERS = "select * from schoolsystemmanagment.public.teacher";
    @Language("SQL")
    private static final String INSERT_TEACHER_QUERY = "insert into schoolsystemmanagment.public.teacher(teachers_id,first_name," +
            " last_name, national_code)\n" +
            "values (?,?,?,?)";
    @Language("SQL")
    private static final String UPDATE_TEACHER_QUERY = "UPDATE schoolsystemmanagment.public.teacher SET" +
            "  first_name = ? ,last_name = ?,national_code = ? " +
            "WHERE teachers_id = ?";
    @Language("SQL")
    private static final String DELETE_TEACHER_WITH_TEACHER_ID =
            "delete from schoolsystemmanagment.public.teacher where teachers_id = ?";

    Database database = new Database();



    @Override
    public Optional<Teacher> findById(int id) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_TEACHER_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Optional<Teacher> optionalTeacher = Optional.empty();
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("teachers_id"));
            teacher.setTeacherFirstname(rs.getString("first_name"));
            teacher.setTeacherLastname(rs.getString("last_name"));
            teacher.setNationalCode(rs.getString("national_code"));
            optionalTeacher = Optional.of(teacher);
        }
        return optionalTeacher;
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_ALL_TEACHERS);
        ResultSet rs = ps.executeQuery();
        List<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("teachers_id"));
            teacher.setTeacherFirstname(rs.getString("first_name"));
            teacher.setTeacherLastname(rs.getString("last_name"));
            teacher.setNationalCode(rs.getString("national_code"));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public void persist(Teacher entity) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(INSERT_TEACHER_QUERY);
        ps.setInt(1, entity.getTeacherId());
        ps.setString(2, entity.getTeacherFirstname());
        ps.setString(3, entity.getTeacherLastname());
        ps.setString(4, entity.getNationalCode());
        ps.executeUpdate();

    }

    @Override
    public void update(Teacher entity) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(UPDATE_TEACHER_QUERY);
        ps.setString(2, entity.getTeacherFirstname());
        ps.setString(3, entity.getTeacherLastname());
        ps.setString(4, entity.getNationalCode());
        ps.setInt(1, entity.getTeacherId());
        ps.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(DELETE_TEACHER_WITH_TEACHER_ID);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
