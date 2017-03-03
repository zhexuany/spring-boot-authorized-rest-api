package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    void add(Student student);

    void update(Student student);

    void delete(int studentId);
}
