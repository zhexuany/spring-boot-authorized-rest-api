package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findAll();

    void add(Course course);

    void delete(String courseTitle);

    List<String> findAllCourseTitle();
}
