package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.Section;
import edu.global.sgs.www.entity.Staff;
import edu.global.sgs.www.entity.Timetable;
import edu.global.sgs.www.entity.custom.SectionCustom;

import java.util.List;

public interface SectionBiz {
    void delete(int sectionId);

    void add(Section section);

    List<SectionCustom> findAllCustom();

    List<String> findAllCourseTitle();

    List<Staff> findAllStaff();

}
