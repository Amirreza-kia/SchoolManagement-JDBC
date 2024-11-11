package service;

import java.sql.SQLException;

public interface StudentService {
    void createStudent(int studentId , String firstName , String lastName , int gpu, String nationalCode) throws SQLException;
    void updateStudent(int studentId , String firstName , String lastName , int gpu, String nationalCode) throws SQLException;
    void deleteStudent(int studentId) throws SQLException;
    void seeGpu(String nationalCode) throws SQLException;
}
