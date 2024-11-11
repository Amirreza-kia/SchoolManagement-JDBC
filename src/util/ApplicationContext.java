package util;

import db.Database;
import repository.*;
import service.*;
import service.impi.*;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationContext {

    public static final String[] LOGIN_MENU_ITEM = {"LOGIN USER", "EXIT"};
    public static final String[] ADMIN_MENU_ITEM = {"CREATE COURSE","UPDATE COURSE",
            "CREATE TEACHER","UPDATE TEACHER","CREATE STUDENT","UPDATE STUDENT"
            ,"DELETE COURSE","DELETE STUDENT","DELETE TEACHER", "BACK LAST MENU"};
    public static final String[] STUDENT_MENU_ITEM = {"CREATE COURSE","SEE GPU INFORMATION"
            ,"BACK LAST MENU"};



    public static CourseService courseService = new CourseServiceImpi();
    public static ExamService examService = new ExamServiceImpi();
    public static UserService userService = new UserServiceImpi();
    public static TeacherService teacherService = new TeacherServiceImpi();
    public static StudentService studentService = new StudentServiceImpi();



    public static CourseRepository courseRepository = new CourseRepository();
    public static ExamRepository examRepository = new ExamRepository();
    public static UserRepository userRepository = new UserRepository();
    public static TeacherRepository teacherRepository = new TeacherRepository();
    public static StudentRepository studentRepository = new StudentRepository();




}