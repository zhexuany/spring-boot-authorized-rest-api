package edu.global.sgs.www.college.controller;

import edu.global.sgs.www.college.service.ClassBiz;
import edu.global.sgs.www.util.TermContainer;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("class.do")
public class ClassController {

    @Resource(name = "classBizImpl")
    private ClassBiz clazzBiz;

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(String deptName, String specName, String year) {
        clazzBiz.add(deptName, specName, year);
        return "redirect:/class.do/class.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int clazzId) {
        clazzBiz.delete(clazzId);
        return "redirect:/class.do/class.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("class.view")
    public String findAll(Model m) {
        m.addAttribute("clazzList", clazzBiz.findAll());
        return "/admin/college/class";
    }

    @RequiresRoles("admin")
    @RequestMapping("clazz_add.view")
    public String findDeptAndSpec(Model m) {
        m.addAttribute("deptAndSpecJson", clazzBiz.findDeptAndSpecJson());
        m.addAttribute("deptNameList", clazzBiz.findDeptNameList());
        m.addAttribute("termList", TermContainer.getTermList());
        return "admin/college/class_add";
    }
}
