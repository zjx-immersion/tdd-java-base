package com.tw.service;

import com.tw.core.GradeReportBuilder;
import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jxzhong on 2017/8/9.
 */
@Service
public class ReportService {

    private final StudentService studentService;
    private final GradeReportBuilder gradeReportBuilder;
    private final GradeService gradeService;

    @Autowired
    public ReportService(StudentService studentRepository,
                         GradeReportBuilder gradeReportBuilder,
                         GradeService gradeService) {

        this.studentService = studentRepository;
        this.gradeReportBuilder = gradeReportBuilder;
        this.gradeService = gradeService;
    }


    public Gradereport generateReport(List<Student> stuList) {
        return this.gradeReportBuilder.buildIndicatedStuReport(stuList);
    }

    public Gradereport generateReportForAllStudents() {

        return this.gradeReportBuilder.buildStudentGradeReport(this.studentService.findAllStudents(),
                this.gradeService.findAllGrades());
    }
}
