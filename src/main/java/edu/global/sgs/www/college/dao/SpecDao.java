package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Spec;
import edu.global.sgs.www.entity.custom.DeptAndSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecDao {
    List<Spec> findAll();

    void update(@Param("specName") String specName, @Param("newSpecName") String newSpecName);

    void add(Spec spec);

    void delete(String specName);

    List<DeptAndSpec> findDeptAndSpec();

    String findIdByName(String specName);

    List<String> findAllSpecName();
}
