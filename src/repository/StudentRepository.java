package repository;

import db.Database;
import model.Student;
import org.intellij.lang.annotations.Language;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements BaseRepository<Student>{

    @Language("SQL")
    private static final String FIND_STUDENT_BY_ID = "select * from schoolsystemmanagment.public.student where student_id =?";
    @Language("SQL")
    private static final String FIND_ALL_STUDENTS = "select * from schoolsystemmanagment.public.student";
    @Language("SQL")
    private static final String INSERT_STUDENT_QUERY = "insert into schoolsystemmanagment.public.student(student_id,first_name, last_name" +
            ", gpu, national_code)\n" +
            "values (?,?,?,?,?)";
    @Language("SQL")
    private static final String UPDATE_STUDENT_QUERY = "UPDATE schoolsystemmanagment.public.student SET first_name = ?," +
            " last_name = ?,gpu = ?,national_code = ? WHERE student_id = ?";
    @Language("SQL")
    private static final String DELETE_STUDENT_WITH_STUDENT_ID = "delete from schoolsystemmanagment.public.student where student_id = ?";

    @Language("SQL")
    private static final String FIND_STUDENT_GPU = "select * from schoolsystemmanagment.public.student where national_code = ? ";

    Database database = new Database();



    @Override
    public Optional<Student> findById(int id) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_STUDENT_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Optional<Student> optionalStudent = Optional.empty();
        while (rs.next()) {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentFirstname(rs.getString("first_name"));
            student.setStudentLastname(rs.getString("last_name"));
            student.setGpu(rs.getInt("gpu"));
            student.setNationalCode(rs.getString("national_code"));
            optionalStudent = Optional.of(student);
        }

        return optionalStudent;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_ALL_STUDENTS);
        ResultSet rs = ps.executeQuery();
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentFirstname(rs.getString("first_name"));
            student.setStudentLastname(rs.getString("last_name"));
            student.setGpu(rs.getInt("gpu"));
            student.setNationalCode(rs.getString("national_code"));
            students.add(student);
        }
        return students;
    }

    @Override
    public void persist(Student entity) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(INSERT_STUDENT_QUERY);
        ps.setInt(1, entity.getStudentId());
        ps.setString(2, entity.getStudentFirstname());
        ps.setString(3, entity.getStudentLastname());
        ps.setInt(4, entity.getGpu());
        ps.setString(5, entity.getNationalCode());
        ps.executeUpdate();
    }

    @Override
    public void update(Student entity) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(UPDATE_STUDENT_QUERY);
        ps.setInt(1, entity.getStudentId());
        ps.setString(2, entity.getStudentFirstname());
        ps.setString(3, entity.getStudentLastname());
        ps.setInt(4, entity.getGpu());
        ps.setString(5, entity.getNationalCode());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(DELETE_STUDENT_WITH_STUDENT_ID);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public void seeGpu (String nationalCode) throws SQLException {
        PreparedStatement ps = database.getPreparedStatement(FIND_STUDENT_GPU);
        ps.setString(1, nationalCode);
        ResultSet rs = ps.executeQuery();
        Optional<Student> optionalStudent = Optional.empty();
        while (rs.next()) {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setStudentFirstname(rs.getString("first_name"));
            student.setStudentLastname(rs.getString("last_name"));
            student.setGpu(rs.getInt("gpu"));
            student.setNationalCode(rs.getString("national_code"));
            optionalStudent = Optional.of(student);
        }


    }
}
