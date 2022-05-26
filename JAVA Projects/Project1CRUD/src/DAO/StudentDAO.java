package DAO;

import MAIN.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAllStudents();
    void insert(Student student);
    void insert(List<Student> students);
}
