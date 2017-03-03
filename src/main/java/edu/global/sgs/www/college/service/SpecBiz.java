package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.Spec;
import edu.global.sgs.www.entity.custom.DeptAndSpec;

import java.util.List;

public interface SpecBiz {

    void update(String specName, String newSpecName);

    void add(Spec spec);

    void delete(String specName);

    List<DeptAndSpec> findDeptAndSpec();

    List<String> findDpet();
}
