package service.impi;

import model.Teacher;
import repository.TeacherRepository;
import service.TeacherService;
import util.ApplicationContext;

import java.sql.SQLException;

public class TeacherServiceImpi implements TeacherService {

    @Override
    public void createTeacher(int teacher_id, String firstName, String lastName, String nationalCode) throws SQLException {
        Teacher teacher = new Teacher(teacher_id, firstName, lastName, nationalCode);
        ApplicationContext.teacherRepository.persist(teacher);
    }

    @Override
    public void updateTeacher(int teacher_id, String firstName, String lastName, String nationalCode) throws SQLException {
        Teacher teacher = new Teacher(teacher_id, firstName, lastName, nationalCode);
        ApplicationContext.teacherRepository.update(teacher);

    }

    @Override
    public void deleteTeacher(int teacher_id) throws SQLException {
        ApplicationContext.teacherRepository.delete(teacher_id);
    }

}
