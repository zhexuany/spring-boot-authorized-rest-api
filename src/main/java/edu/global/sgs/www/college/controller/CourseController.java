package edu.global.sgs.www.college.controller;

import edu.global.sgs.www.college.service.CourseBiz;
import edu.global.sgs.www.entity.Course;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("course.do")
public class CourseController {
    @Resource(name = "courseBizImpl")
    private CourseBiz courseBiz;

    @RequiresRoles("admin")
    @RequestMapping("course.view")
    public String courseView(Model m) {
        m.addAttribute("courseList", courseBiz.findAll());
        return "/admin/college/course";
    }

    @RequiresRoles("admin")
    @RequestMapping("course_add.view")
    public String courseAddView(Model m) {
        m.addAttribute("specNameList", courseBiz.findAllSpecName());
        return "/admin/college/course_add";
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Course course) {
        courseBiz.add(course);
        return "redirect:/course.do/course.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(String courseTitle) {
        courseBiz.delete(courseTitle);
        return "redirect:/course.do/course.view";
    }
}

