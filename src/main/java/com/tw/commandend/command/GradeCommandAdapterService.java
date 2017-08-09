package com.tw.commandend.command;

import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import com.tw.service.GradeService;
import com.tw.service.ReportService;
import com.tw.service.StudentService;

import java.util.List;

/**
 * Created by jxzhong on 2017/8/9.
 */
public class GradeCommandAdapterService {


    private final StudentService studentService;
    private final GradeService gradeService;
    private final ReportService reportService;


    public GradeCommandAdapterService(StudentService studentService, GradeService gradeService, ReportService reportService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
        this.reportService = reportService;
    }


    public Gradereport generateReport(List<Student> stuList) {
        return this.reportService.generateReport(stuList);
    }

    public void addStudent(Student stu) {
        //todo should add the featire fpr add grade separated with student
        this.studentService.addStudent(stu);
    }

}

