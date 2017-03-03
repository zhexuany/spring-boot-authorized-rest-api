package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.Course;
import org.springframework.ui.Model;

import java.util.List;

public interface CourseBiz {
    List<Course> findAll();

    List<String> findAllSpecName();

    void add(Course course);

    void delete(String courseTitle);
}
