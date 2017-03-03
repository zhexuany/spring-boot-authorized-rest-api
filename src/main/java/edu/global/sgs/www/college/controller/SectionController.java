package edu.global.sgs.www.college.controller;

import edu.global.sgs.www.college.service.SectionBiz;
import edu.global.sgs.www.entity.Section;
import edu.global.sgs.www.entity.Timetable;
import edu.global.sgs.www.util.TermContainer;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("section.do")
public class SectionController {
    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;

    @RequiresRoles("admin")
    @RequestMapping("section.view")
    public String sectionView(Model m) {
        m.addAttribute("sectionList", sectionBiz.findAllCustom());
        return "/admin/college/section";
    }

    @RequiresRoles("admin")
    @RequestMapping("section_add.view")
    public String sectionAddView(Model m) {
        m.addAttribute("courseTitleList", sectionBiz.findAllCourseTitle());
        m.addAttribute("staffList", sectionBiz.findAllStaff());
        m.addAttribute("termList", TermContainer.getTermList());
        return "/admin/college/section_add";
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Section section, HttpSession session) {
        sectionBiz.add(section);
        return "redirect:section.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int secId) {
        sectionBiz.delete(secId);
        return "redirect:section.view";
    }
}
