package edu.global.sgs.www.college.service.impl;

import edu.global.sgs.www.college.dao.CourseDao;
import edu.global.sgs.www.college.dao.SpecDao;
import edu.global.sgs.www.college.service.CourseBiz;
import edu.global.sgs.www.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseBizImpl implements CourseBiz {

    @Resource
    private CourseDao courseDao;

    @Resource
    private SpecDao specDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public List<String> findAllSpecName() {
        return specDao.findAllSpecName();
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void delete(String courseTitle) {
        courseDao.delete(courseTitle);
    }
}
