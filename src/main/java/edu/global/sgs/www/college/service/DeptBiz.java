package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.custom.DeptAndSpec;
import edu.global.sgs.www.entity.Dept;

import java.util.List;

public interface DeptBiz {
    List<Dept> findAll();

    void add(String deptName);

    void update(Dept dept);

    void delete(int deptId);

}
