package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.Class;
import edu.global.sgs.www.entity.custom.DeptAndSpec;

import java.util.List;

public interface ClassBiz {
    void add(String deptName, String specName, String year);

    void delete(int clazzId);

    List<Class> findAll();

    List<DeptAndSpec> findDeptAndSpec();

    String findDeptAndSpecJson();

    List<String> findDeptNameList();
}
