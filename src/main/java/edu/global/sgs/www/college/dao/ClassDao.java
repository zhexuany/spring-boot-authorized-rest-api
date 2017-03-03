package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDao {
    void add(Class c);

    void delete(int clazzId);

    List<Class> findAll();

    int getClassCount(@Param("specName") String specName, @Param("year") String year);
}
