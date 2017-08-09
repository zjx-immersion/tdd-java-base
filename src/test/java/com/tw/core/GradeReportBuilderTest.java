package com.tw.core;

import com.tw.core.model.Grade;
import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import com.tw.core.model.StudentGradeItem;
import com.tw.core.respository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/7/26.
 */

@RunWith(MockitoJUnitRunner.class)
public class GradeReportBuilderTest {

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void should_get_report_includes_students() throws Exception {
        //Given
        GradeReportBuilder reportBuilder = new GradeReportBuilder(studentRepository);
        List<Student> students = asList(new Student("Tom", "1", 90, 88, 98, 100));
        List<StudentGradeItem> gradeItems = asList(new StudentGradeItem("Tom", "1", 90, 88, 98, 100));
        StudentGradeItem studentGradeItemOrigin = gradeItems.get(0);
        when(studentRepository.getAllStudent()).thenReturn(students);

        //When
        Gradereport report = reportBuilder.buildIndicatedStuReport(students);

        //Then
        assertEquals(report.getStudentGradeItems().size(), gradeItems.size());
        StudentGradeItem studentGradeItem1 = report.getStudentGradeItems().get(0);
        assertEquals(studentGradeItem1.getName(), studentGradeItemOrigin.getName());
        assertEquals(studentGradeItem1.getNumber(), studentGradeItemOrigin.getNumber());
        assertEquals(studentGradeItem1.getMathsScore(), studentGradeItemOrigin.getMathsScore());
        assertEquals(studentGradeItem1.getChineseScore(), studentGradeItemOrigin.getChineseScore());
        assertEquals(studentGradeItem1.getEnglishScore(), studentGradeItemOrigin.getEnglishScore());
        assertEquals(studentGradeItem1.getProgramScore(), studentGradeItemOrigin.getProgramScore());
    }

    @Test
    public void shoule_get_tital_and_average_score_with_any_stu_when_class_inclues_more_than_one_studentinfos() throws Exception {
        GradeReportBuilder reportBuilder = new GradeReportBuilder(studentRepository);
        List<Student> students = asList(
                new Student("Tom", "1", 90, 88, 98, 100),
                new Student("Jim", "2", 95, 93, 92, 80)
        );
        when(studentRepository.getAllStudent()).thenReturn(students);

        //When
        Gradereport report = reportBuilder.buildIndicatedStuReport(students);

        //Then
        assertThat(report.getStudentGradeItems().get(0).getTotalScore(), is(376));
        assertThat(report.getStudentGradeItems().get(0).getAvergeScore(), is(94));
        assertThat(report.getStudentGradeItems().get(1).getTotalScore(), is(360));
        assertThat(report.getStudentGradeItems().get(1).getAvergeScore(), is(90));
    }

    @Test
    public void shoule_get_class_total_and_average_scorn_when_class_inclues_more_than_one_studentinfos() throws Exception {
        GradeReportBuilder reportBuilder = new GradeReportBuilder(studentRepository);
        List<Student> students = asList(
                new Student("Tom", "1", 90, 88, 98, 100),
                new Student("Jim", "2", 95, 93, 92, 80)
        );
        when(studentRepository.getAllStudent()).thenReturn(students);

        //When
        Gradereport report = reportBuilder.buildIndicatedStuReport(students);

        //Then
        assertThat(report.getTotalScore(), is(736));
        assertThat(report.getAvergeScore(), is(368));
    }


    @Test
    public void shoule_get_indicated_stus_report_when_include_un_exist_stu_input() throws Exception {
        GradeReportBuilder reportBuilder = new GradeReportBuilder(studentRepository);
        List<Student> students = asList(
                new Student("Tom", "1", 90, 88, 98, 100),
                new Student("Jim", "2", 95, 93, 92, 80)
        );
        when(studentRepository.getAllStudent()).thenReturn(students);

        List<Student> indicatedStudents = asList(
                new Student("Tom", "1", 90, 88, 98, 100),
                new Student("Jason", "3", 95, 93, 92, 80)
        );

        //When
        Gradereport report = reportBuilder.buildIndicatedStuReport(indicatedStudents);

        //Then
        assertEquals(report.getStudentGradeItems().size(), 1);
        assertEquals(report.getStudentGradeItems().get(0).getNumber(), "1");
    }

    @Test
    public void should_generate_report_when_input_one_stu_and_conresponsed_grade() throws Exception {
        //Given
        GradeReportBuilder reportBuilder = new GradeReportBuilder();
        List<Student> students = asList(
                new Student("Tom", "1")
        );
        List<Grade> grades = asList(
                new Grade("1", 90, 88, 98, 100)
        );

        List<StudentGradeItem> gradeItems = asList(
                new StudentGradeItem("Tom", "1", 90, 88, 98, 100));
        StudentGradeItem studentGradeItemOrigin = gradeItems.get(0);
        //When
        Gradereport report = reportBuilder.buildStudentGradeReport(students, grades);


        //Then
        assertEquals(report.getStudentGradeItems().size(), gradeItems.size());
        StudentGradeItem studentGradeItem1 = report.getStudentGradeItems().get(0);
        assertEquals(studentGradeItem1.getName(), studentGradeItemOrigin.getName());
        assertEquals(studentGradeItem1.getNumber(), studentGradeItemOrigin.getNumber());
        assertEquals(studentGradeItem1.getMathsScore(), studentGradeItemOrigin.getMathsScore());
        assertEquals(studentGradeItem1.getChineseScore(), studentGradeItemOrigin.getChineseScore());
        assertEquals(studentGradeItem1.getEnglishScore(), studentGradeItemOrigin.getEnglishScore());
        assertEquals(studentGradeItem1.getProgramScore(), studentGradeItemOrigin.getProgramScore());

    }

    @Test
    public void should_generate_report_when_input_indicated_stus_and_conresponsed_grades() throws Exception {
        //Given
        GradeReportBuilder reportBuilder = new GradeReportBuilder();
        List<Student> students = asList(
                new Student("Tom", "1"),
                new Student("Jim", "2")
        );
        List<Grade> grades = asList(
                new Grade("1", 90, 88, 98, 100),
                new Grade("2", 95, 93, 92, 80)
        );

        List<StudentGradeItem> gradeItems = asList(
                new StudentGradeItem("Tom", "1", 90, 88, 98, 100),
                new StudentGradeItem("Jim", "2", 95, 93, 92, 80));
        //When
        Gradereport report = reportBuilder.buildStudentGradeReport(students, grades);
        StudentGradeItem studentGradeItem1 = report.getStudentGradeItems().get(0);
        StudentGradeItem studentGradeItem2 = report.getStudentGradeItems().get(1);

        //Then
        assertEquals(report.getStudentGradeItems().size(), gradeItems.size());
        assertEquals(studentGradeItem1.getName(), gradeItems.get(0).getName());
        assertEquals(studentGradeItem1.getMathsScore(), gradeItems.get(0).getMathsScore());
        assertEquals(studentGradeItem2.getName(), gradeItems.get(1).getName());
        assertEquals(studentGradeItem2.getMathsScore(), gradeItems.get(1).getMathsScore());
    }


    @Test
    public void shoule_get_total_and_average_score_when_report_inclues_more_than_one_studentinfos() throws Exception {
        //Given
        GradeReportBuilder reportBuilder = new GradeReportBuilder();
        List<Student> students = asList(
                new Student("Tom", "1"),
                new Student("Jim", "2")
        );
        List<Grade> grades = asList(
                new Grade("1", 90, 88, 98, 100),
                new Grade("2", 95, 93, 92, 80)
        );

        //When
        Gradereport report = reportBuilder.buildStudentGradeReport(students, grades);

        //Then
        assertThat(report.getStudentGradeItems().get(0).getTotalScore(), is(376));
        assertThat(report.getStudentGradeItems().get(0).getAvergeScore(), is(94));
        assertThat(report.getStudentGradeItems().get(1).getTotalScore(), is(360));
        assertThat(report.getStudentGradeItems().get(1).getAvergeScore(), is(90));
        assertThat(report.getTotalScore(), is(736));
        assertThat(report.getAvergeScore(), is(368));
    }
}
