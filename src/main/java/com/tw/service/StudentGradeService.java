package com.tw.service;

import com.tw.core.*;
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

    public Boolean addGradeToStudent(String stuNumber, Grade grade) {

        try {
            Student stu = this.klass.findStudentByNumber(stuNumber);
            if (stu == null) {
                throw new NullPointerException("student is not exist!");
            }
            stu.setMathsScore(grade.getMathsScore());
            stu.setChineseScore(grade.getChineseScore());
            stu.setEnglishScore(grade.getEnglishScore());
            stu.setProgramScore(grade.getProgramScore());
            if(!this.klass.updateStudent(stu)){
                throw new Exception("Update student with grade failed!");
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Grade getStudentGrade(String number) {
        Student stu = this.klass.findStudentByNumber(number);
        Grade grade = new Grade();
        grade.setChineseScore(stu.getChineseScore());
        grade.setMathsScore(stu.getMathsScore());
        grade.setEnglishScore(stu.getEnglishScore());
        grade.setProgramScore(stu.getProgramScore());
        return grade;
    }
}
