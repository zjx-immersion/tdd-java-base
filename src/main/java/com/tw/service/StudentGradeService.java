package com.tw.service;

import com.tw.core.GradeReportBuilder;
import com.tw.core.Gradereport;
import com.tw.core.Klass;
import com.tw.core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jxzhong on 2017/7/27.
 */
@Service
public class StudentGradeService {

    private final Klass klass;
    private final GradeReportBuilder gradeReportBuilder;

    @Autowired
    public StudentGradeService(Klass klass, GradeReportBuilder gradeReportBuilder) {

        this.klass = klass;
        this.gradeReportBuilder = gradeReportBuilder;
    }

    public void addStudent(Student stu) {
        this.klass.addStudents(stu);
    }

    public Gradereport generateReport(List<Student> stuList) {
        return this.gradeReportBuilder.buildIndicatedStuReport(stuList);
    }

    public Gradereport generateReportForAllStudents() {
        return this.gradeReportBuilder.buildIndicatedStuReport(this.klass.getAllStudent());
    }

    public List<Student> findAllStudents() {
        return this.klass.getAllStudent();
    }

    public List<Student> findByNumberOrName(String keyWords) {
        return this.klass.findByNumberOrNumber(keyWords);
    }
}
