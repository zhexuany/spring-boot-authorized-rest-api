package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Class;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;

public class ClassJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public Map findAll() {
        String sql =  "SELECT * FROM class";
        return jdbcTemplateObject.queryForMap(sql);
    }

    public void add(Class c) {
        String sql = "INSERT INTO class(class_id,class_name,year,spec_name) VALUES (?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, c.getClassId(), c.getClassName(), c.getYear(), c.getSpecName());
    }

    public void delete(Integer i) {
        String sql = "delete from Student where id = ?";
        jdbcTemplateObject.update(sql, i);
    }

    public int getClassCount(String spec, String year) {
        String sql = "SELECT count(class_id) FROM class WHERE spec_name = ? AND year = ?";
        return jdbcTemplateObject.queryForObject(sql, new Object[] { spec, year }, Integer.class);
    }
}
