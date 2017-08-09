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

    public void addStudent(Student stu) {
        this.studentRepository.addStudents(stu);
    }

    public List<Student> findAllStudents() {
        return this.studentRepository.getAllStudent();
    }

    public List<Student> findByNumberOrName(String keyWords) {
        return this.studentRepository.findByNumberOrNumber(keyWords);
    }


}
