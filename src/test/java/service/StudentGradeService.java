package service;

import core.GradeReportBuilder;
import core.Gradereport;
import core.Klass;
import core.Student;

import java.util.List;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class StudentGradeService {

    private Klass klass;
    private GradeReportBuilder gradeReportBuilder;

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
}
