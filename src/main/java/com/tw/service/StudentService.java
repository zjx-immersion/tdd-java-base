package com.tw.service;

import com.tw.core.*;
import com.tw.core.model.Student;
import com.tw.core.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jxzhong on 2017/7/27.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GradeReportBuilder gradeReportBuilder;

    @Autowired
    public StudentService(StudentRepository studentRepository, GradeReportBuilder gradeReportBuilder) {

        this.studentRepository = studentRepository;
        this.gradeReportBuilder = gradeReportBuilder;
    }

    public Boolean addStudent(Student stu) {
        try {
            if (this.studentRepository.isExist(stu.getNumber())) {
                throw new Exception("This student number is exist!");
            }
            this.studentRepository.addStudents(stu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Student> findAllStudents() {
        return this.studentRepository.getAllStudent();
    }

    public List<Student> findByNumberOrName(String keyWords) {
        return this.studentRepository.findByNumberOrNumber(keyWords);
    }


}
