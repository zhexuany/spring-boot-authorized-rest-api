package edu.global.sgs.www.college.dao;

import edu.global.sgs.www.entity.Staff;

import java.util.List;

public interface StaffDao {
    List<String> findAllName();

    String findIdByName(String staffId);

    List<Staff> findAll();

    void add(Staff staff);
}
