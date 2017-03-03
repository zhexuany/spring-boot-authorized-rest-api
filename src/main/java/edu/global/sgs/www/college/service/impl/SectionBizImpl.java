package edu.global.sgs.www.college.service.impl;

import edu.global.sgs.www.college.dao.CourseDao;
import edu.global.sgs.www.college.dao.SectionDao;
import edu.global.sgs.www.college.dao.StaffDao;
import edu.global.sgs.www.college.service.SectionBiz;
import edu.global.sgs.www.entity.Section;
import edu.global.sgs.www.entity.Staff;
import edu.global.sgs.www.entity.custom.SectionCustom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SectionBizImpl implements SectionBiz {

    @Resource
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private SectionDao sectionDao;
    @Resource
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private CourseDao courseDao;
    @Resource
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private StaffDao staffDao;


    @Transactional
    @Override
    public void delete(int secId) {
        sectionDao.delete(secId);
    }

    @Override
    public void add(Section section) {
        sectionDao.add(section);

    }

    @Override
    public List<SectionCustom> findAllCustom() {
        return sectionDao.findAllCustom();
    }

    @Override
    public List<String> findAllCourseTitle() {
        return courseDao.findAllCourseTitle();
    }


    @Override
    public List<Staff> findAllStaff() {
        return staffDao.findAll();
    }

}
