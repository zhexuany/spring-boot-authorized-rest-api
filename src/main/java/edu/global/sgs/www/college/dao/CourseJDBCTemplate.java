package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Course;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by zhexuany on 3/3/17.
 */
public class CourseJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public Map findAll() {
       String sql = "SELECT * FROM course";
       return jdbcTemplateObject.queryForMap(sql);
    }

    public void add(Course c) {
       String sql =  "INSERT INTO course(course_title,type,credits,speciality) VALUES(?, ?, ?, ?)";
       jdbcTemplateObject.update(sql, c.getCourseTitle(), c.getType(), c.getCredits(), c.getSpeciality());
    }

    public void delete(String title) {
        String sql = "DELETE FROM course WHERE course_title=?";
        jdbcTemplateObject.update(sql, title);
    }

 /*
    <select id="findAllCourseTitle" resultType="String">
        SELECT course_title FROM course
    </select>
  */
}
