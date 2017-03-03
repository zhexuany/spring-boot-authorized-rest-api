package edu.global.sgs.www.college.service;

import edu.global.sgs.www.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentBiz {
    List<Student> studentView();

    void add(Student student, MultipartFile pic) throws IOException;

    void update(Student student);

    void delete(int studentId);
}
