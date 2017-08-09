package com.tw.core;

import com.tw.core.model.Grade;
import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import com.tw.core.model.StudentGradeItem;
import com.tw.core.respository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/7/26.
 */
@Component
public class GradeReportBuilder {
    private StudentRepository studentRepository;

    public GradeReportBuilder() {
    }

    public GradeReportBuilder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Gradereport buildIndicatedStuReport(List<Student> stuList) {
        Gradereport gradereport = new Gradereport();
        gradereport.setStudentGradeItems(this.studentRepository.getAllStudent().stream()
                .filter(s -> stuList.stream().anyMatch(indicatedStu -> indicatedStu.getNumber().equals(s.getNumber())))
                .map(s -> new StudentGradeItem(
                        s.getName(),
                        s.getNumber(),
                        s.getMathsScore(),
                        s.getChineseScore(),
                        s.getEnglishScore(),
                        s.getProgramScore())).collect(Collectors.toList()));
        return gradereport;
    }

    public Gradereport buildStudentGradeReport(List<Student> students, List<Grade> grades) {
        Gradereport gradereport = new Gradereport();
        gradereport.setStudentGradeItems(grades.stream()
                .filter(grade -> students.stream().anyMatch(indicatedStu -> indicatedStu.getNumber().equals(grade.getStuNumber())))
                .map(grade -> {
                    Student stu = students.stream().filter(s -> grade.getStuNumber().equals(s.getNumber())).findFirst().get();
                    return new StudentGradeItem(
                            stu.getName(),
                            stu.getNumber(),
                            grade.getMathsScore(),
                            grade.getChineseScore(),
                            grade.getEnglishScore(),
                            grade.getProgramScore());
                }).collect(Collectors.toList()));
        return gradereport;
    }

}
