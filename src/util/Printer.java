package util;

import model.Course;
import model.Student;
import model.Teacher;

import java.util.List;
import java.util.Optional;

public class Printer {

    public static void printItem(String[] menuItem) {
        System.out.println("\u001B[34m" + "--------------------");
        for (int i = 0; i < menuItem.length; i++) {
            System.out.printf("\u001B[34m" + "%d ) %s \n", (i + 1), menuItem[i]);
        }
        System.out.println("\u001B[34m" + "--------------------");
    }

    public static void printCoureItem(List<Course> coureItem) {
        System.out.println("\u001B[34m" + "_____________________________________________________________________________");
        for (Course c : coureItem) {
            System.out.println(c);
        }
        System.out.println("\u001B[34m" + "_____________________________________________________________________________");
    }

    public static void printTeacherItem(List<Teacher> teacherItem) {
        System.out.println("\u001B[34m" + "_____________________________________________________________________________");
        for (Teacher t : teacherItem) {
            System.out.println(t);
        }
        System.out.println("\u001B[34m" + "_____________________________________________________________________________");
    }

    public static void printStudentItem(List<Student> studentItem) {
        System.out.println("\u001B[34m" + "-____________________________________________________________________________");
        for (Student s : studentItem) {
            System.out.println(s);
        }
        System.out.println("\u001B[34m" + "_____________________________________________________________________________");
    }

}
