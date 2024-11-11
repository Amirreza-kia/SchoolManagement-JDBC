package repository;

import db.Database;
import model.Exam;
import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExamRepository implements BaseRepository<Exam> {
    @Language("SQL")
    private static final String FIND_EXAM_BY_ID = "select * from schoolsystemmanagment.public.exam where exam_id =?";
    @Language("SQL")
    private static final String FIND_ALL_EXAMS = "select * from schoolsystemmanagment.public.exam";
    @Language("SQL")
    private static final String INSERT_EXAM = "insert into schoolsystemmanagment.public.exam(exam_id, exam_name) values(?,?)";
    @Language("SQL")
    private static final String UPDATE_EXAM_QUERY = "UPDATE schoolsystemmanagment.public.exam SET exam_id = ? where exam_id = ?";
    @Language("SQL")
    private static final String DELETE_EXAM_WITH_EXAM_ID = "delete from schoolsystemmanagment.public.exam where exam_id = ?";

    Database database = new Database();




    @Override
    public Optional<Exam> findById(int id) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(FIND_EXAM_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Optional<Exam> optionalExam = Optional.empty();
        while (rs.next()) {
            Exam exam = new Exam();
            exam.setExamId(rs.getInt("exam_id"));
            exam.setExamName(rs.getString("exam_name"));
            optionalExam = Optional.of(exam);
        }
        return optionalExam;
    }

    @Override
    public List<Exam> findAll() throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(FIND_ALL_EXAMS);
        ResultSet rs = ps.executeQuery();
        List<Exam> exams = new ArrayList<>();
        while (rs.next()) {
            Exam exam = new Exam();
            exam.setExamId(rs.getInt("exam_id"));
            exam.setExamName(rs.getString("exam_name"));
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public void persist(Exam entity) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(INSERT_EXAM);
        ps.setInt(1, entity.getExamId());
        ps.setString(2, entity.getExamName());
        ps.executeUpdate();

    }

    @Override
    public void update(Exam entity) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(UPDATE_EXAM_QUERY);
        ps.setInt(1, entity.getExamId());
        ps.setString(2, entity.getExamName());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = this.database.getPreparedStatement(DELETE_EXAM_WITH_EXAM_ID);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
