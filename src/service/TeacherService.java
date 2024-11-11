package service;

import model.Teacher;

import java.sql.SQLException;

public interface TeacherService {

    void createTeacher(int teacher_id, String firstName, String lastName, String nationalCode) throws SQLException;
    void updateTeacher(int teacher_id, String firstName, String lastName, String nationalCode) throws SQLException;
    void deleteTeacher(int teacher_id) throws SQLException;
}

