package service.impi;

import model.Student;
import repository.StudentRepository;
import service.StudentService;
import util.ApplicationContext;

import java.sql.SQLException;

public class StudentServiceImpi implements StudentService {

    @Override
    public void createStudent(int studentId, String firstName, String lastName, int gpu, String nationalCode) throws SQLException {
        Student student = new Student(studentId, firstName, lastName, gpu, nationalCode);
        ApplicationContext.studentRepository.persist(student);

    }

    @Override
    public void updateStudent(int studentId, String firstName, String lastName, int gpu, String nationalCode) throws SQLException {
        Student student = new Student(studentId, firstName, lastName, gpu, nationalCode);
        ApplicationContext.studentRepository.update(student);

    }

    @Override
    public void deleteStudent(int studentId) throws SQLException {
        ApplicationContext.studentRepository.delete(studentId);
    }

    @Override
    public void seeGpu(String nationalCode) throws SQLException {
        ApplicationContext.studentRepository.seeGpu(nationalCode);
    }

}
