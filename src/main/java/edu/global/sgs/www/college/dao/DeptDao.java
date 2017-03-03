package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.custom.DeptAndSpec;
import edu.global.sgs.www.entity.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> findAll();

    void add(String deptName);

    String findIdByName(String deptName);

    void update(Dept dept);

    void delete(int deptId);

    List<String> findAllDeptName();

}
