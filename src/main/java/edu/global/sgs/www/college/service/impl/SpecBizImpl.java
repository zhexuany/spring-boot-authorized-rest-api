package edu.global.sgs.www.college.service.impl;

import edu.global.sgs.www.college.dao.DeptDao;
import edu.global.sgs.www.college.dao.SpecDao;
import edu.global.sgs.www.college.service.SpecBiz;
import edu.global.sgs.www.entity.Spec;
import edu.global.sgs.www.entity.custom.DeptAndSpec;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecBizImpl implements SpecBiz {

    @Resource
    private SpecDao specDao;

    @Resource
    private DeptDao deptDao;

    public List<DeptAndSpec> findDeptAndSpec() {
        return specDao.findDeptAndSpec();
    }

    @Override
    public void update(String specName, String newSpecName) {
        specDao.update(specName, newSpecName);
    }

    @Override
    public void add(Spec spec) {
        specDao.add(spec);
    }

    @Override
    public void delete(String specName) {
        specDao.delete(specName);
    }

    @Override
    public List<String> findDpet() {
        return deptDao.findAllDeptName();
    }
}
