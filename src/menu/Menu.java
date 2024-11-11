package menu;

import exception.UserNotFoundException;
import util.ApplicationContext;
import util.Printer;
import util.Util;

import java.sql.SQLException;

public class Menu {

  //فرق merge vs rebase
    public static void startMenu() throws SQLException {

        System.out.println("\u001B[91m" + "Welcome to School Management System");

        while (true) {
            Printer.printItem(ApplicationContext.LOGIN_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }

    }


    private static void loginMenu() throws SQLException {

        String username = Util.getStringInput("ENTER YOUR USERNAME:  ");
        String password = Util.getStringInput("ENTER YOUR PASSWORD:  ");
        try {
            String role = ApplicationContext.userService.login(username, password);
            switch (role) {
                case "admin":
                    System.out.println("--------------------");
                    System.out.println("YOUR ADMIN ROLE");
                    System.out.println("ADMIN MENU");
                    adminMenu();
                    break;
                case "student":
                    System.out.println("--------------------");
                    System.out.println("YOUR STUDENT ROLE");
                    System.out.println("STUDENT MENU");
                    studentMenu();
                    break;
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());

        }

    }

    private static void adminMenu() throws SQLException {
        Printer.printItem(ApplicationContext.ADMIN_MENU_ITEM);
        int choice = Util.getIntInput("SELECT ONE ITEM = ");
        try {
            switch (choice) {
                case 1:
                    //create course
                    Printer.printCoureItem(ApplicationContext.courseRepository.findAll());
                    int courseId = Util.getIntInput("ENTER COURSE ID = ");
                    String courseName = Util.getStringInput("ENTER COURSE NAME = ");
                    int courseUnit = Util.getIntInput("ENTER COURSE UNIT = ");
                    ApplicationContext.courseService.createCourse(courseId, courseName, courseUnit);
                    System.out.println("\u001B[33m"+"COURSE CREATED SUCCESSFULLY");
                    break;
                case 2:
                    //update course
                    Printer.printCoureItem(ApplicationContext.courseRepository.findAll());
                    int courseId1 = Util.getIntInput("ENTER COURSE ID = ");
                    String courseName1 = Util.getStringInput("ENTER COURSE NAME = ");
                    int courseUnit1 = Util.getIntInput("ENTER COURSE UNIT = ");
                    ApplicationContext.courseService.updateCourse(courseId1, courseName1, courseUnit1);
                    System.out.println("\u001B[33m"+"COURSE UPDATED SUCCESSFULLY");
                    break;
                case 3:
                    //create teacher
                    Printer.printTeacherItem(ApplicationContext.teacherRepository.findAll());
                    int teacherId = Util.getIntInput("ENTRE TEACHER ID = ");
                    String teacherFirstname = Util.getStringInput("ENTER TEACHER FIRSTNAME = ");
                    String teacherLastname = Util.getStringInput("ENTER TEACHER LASTNAME = ");
                    String nationalCode = Util.getStringInput("ENTER TEACHER NATIONAL CODE = ");
                    ApplicationContext.teacherService.createTeacher(teacherId, teacherFirstname, teacherLastname, nationalCode);
                    System.out.println("\u001B[33m"+"TEACHER CREATED SUCCESSFULLY");
                    break;
                case 4:
                    //update teacher
                    Printer.printTeacherItem(ApplicationContext.teacherRepository.findAll());
                    int teacherId1 = Util.getIntInput("ENTER TEACHER ID = ");
                    String teacherFirstname1 = Util.getStringInput("ENTER TEACHER FIRSTNAME = ");
                    String teacherLastname1 = Util.getStringInput("ENTER TEACHER LASTNAME = ");
                    String nationalCode1 = Util.getStringInput("ENTER TEACHER NATIONAL CODE = ");
                    ApplicationContext.teacherService.createTeacher(teacherId1, teacherFirstname1, teacherLastname1, nationalCode1);
                    System.out.println("\u001B[33m"+"TEACHER UPDATE SUCCESSFULLY");
                    break;
                case 5:
                    //create student
                    Printer.printStudentItem(ApplicationContext.studentRepository.findAll());
                    int studentId = Util.getIntInput("ENTER STUDENT ID = ");
                    String studentFirstname = Util.getStringInput("ENTER STUDENT FIRSTNAME = ");
                    String studentLastname = Util.getStringInput("ENTER STUDENT LASTNAME = ");
                    int studentGpus = Util.getIntInput("ENTER STUDENT GPU = ");
                    String nationalCode2 = Util.getStringInput("ENTER NATIONAL CODE = ");
                    ApplicationContext.studentService.createStudent(studentId, studentFirstname, studentLastname, studentGpus, nationalCode2);
                    System.out.println("\u001B[33m"+"STUDENT CREATED SUCCESSFULLY");
                    break;
                case 6:
                    //update student
                    Printer.printStudentItem(ApplicationContext.studentRepository.findAll());
                    int studentId2 = Util.getIntInput("ENTER STUDENT ID = ");
                    String studentFirstname2 = Util.getStringInput("ENTER STUDENT FIRSTNAME = ");
                    String studentLastname2 = Util.getStringInput("ENTER STUDENT LASTNAME = ");
                    int studentGpus2 = Util.getIntInput("ENTER STUDENT GPU = ");
                    String nationalCode22 = Util.getStringInput("ENTER NATIONAL CODE = ");
                    ApplicationContext.studentService.updateStudent(studentId2, studentFirstname2, studentLastname2, studentGpus2, nationalCode22);
                    System.out.println("\u001B[33m"+"STUDENT UPDATED SUCCESSFULLY");
                    break;
                case 7:
                    //delete course
                    Printer.printCoureItem(ApplicationContext.courseRepository.findAll());
                    int courseId3 = Util.getIntInput("ENTER COURSE ID = ");
                    ApplicationContext.courseService.deleteCourse(courseId3);
                    System.out.println("\u001B[33m"+"COURSE DELETED SUCCESSFULLY");
                    break;
                case 8:
                    //delete student
                    Printer.printStudentItem(ApplicationContext.studentRepository.findAll());
                    int studentId3 = Util.getIntInput("ENTER STUDENT ID = ");
                    ApplicationContext.studentService.deleteStudent(studentId3);
                    System.out.println("\u001B[33m"+"STUDENT DELETED SUCCESSFULLY");
                    break;
                case 9:
                    //delete teacher
                    Printer.printTeacherItem(ApplicationContext.teacherRepository.findAll());
                    int teacherId3 = Util.getIntInput("ENTER TEACHER ID = ");
                    ApplicationContext.teacherService.deleteTeacher(teacherId3);
                    System.out.println("\u001B[33m"+"TEACHER DELETED SUCCESSFULLY");
                    break;
                case 10:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);

            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void studentMenu() throws SQLException {
        Printer.printItem(ApplicationContext.STUDENT_MENU_ITEM);
        int choice = Util.getIntInput("SELECT ONE ITEM = ");
        try {
            switch (choice) {
                case 1:
                    //create course
                    int courseId = Util.getIntInput("ENTER COURSE ID = ");
                    String courseName = Util.getStringInput("ENTER COURSE NAME = ");
                    int courseUnit = Util.getIntInput("ENTER COURSE UNIT = ");
                    ApplicationContext.courseService.createCourse(courseId, courseName, courseUnit);
                    break;
                case 2:
                    //see gpu information
                    String studentNationalId = Util.getStringInput("ENTER STUDENT NATIONAL CODE = ");
                    ApplicationContext.studentService.seeGpu(studentNationalId);
                    Printer.printStudentItem(ApplicationContext.studentRepository.findAll());
                    break;
                case 3:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }





    //select avg(gpu) form student where studentId
    //count = تعداد اسامی یا
}
