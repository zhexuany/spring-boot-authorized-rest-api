package edu.global.sgs.www.college.service.impl;

import edu.global.sgs.www.college.dao.ClassDao;
import edu.global.sgs.www.college.dao.DeptDao;
import edu.global.sgs.www.college.dao.SpecDao;
import edu.global.sgs.www.college.service.ClassBiz;
import edu.global.sgs.www.entity.Class;
import edu.global.sgs.www.entity.custom.DeptAndSpec;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ClassBizImpl implements ClassBiz {

    @Resource
    private ClassDao classDao;
    @Resource
    private DeptDao deptDao;
    @Resource
    private SpecDao specDao;

    public void add(String deptName, String specName, String year) {
        Class c = new Class();
        c.setSpecName(specName);
        int classCount = classDao.getClassCount(specName, year) + 1;
        c.setClassId(year.substring(2) + deptDao.findIdByName(deptName) + specDao.findIdByName(specName) + classCount);
        c.setYear(year);
        classDao.add(c);
    }

    public void delete(int clazzId) {
        classDao.delete(clazzId);
    }

    public List<Class> findAll() {
        return classDao.findAll();
    }

    @Override
    public List<DeptAndSpec> findDeptAndSpec() {
        return specDao.findDeptAndSpec();
    }


    @Override
    public String findDeptAndSpecJson() {
        Gson gson = new Gson();

        List<DeptAndSpec> deptAndSpecList = specDao.findDeptAndSpec();

        HashMap<String, List<String>> map = new HashMap<>();


        for (DeptAndSpec deptAndSpec : deptAndSpecList) {
            map.put(deptAndSpec.getDeptName(), deptAndSpec.getSpecName());
        }
        return gson.toJson(map);
    }

    //TODO 在这里感觉不应该查询两次应该使用上面的结果keyset,磁盘的开销远大于运算,如果开一个deptAndSpecList变量存储这个变量是线程安全的么,留坑= =！
    //感觉这里应该是取决于biz的BEAN在spring中的作用域
    @Override
    public List<String> findDeptNameList() {
        return deptDao.findAllDeptName();
    }


}
