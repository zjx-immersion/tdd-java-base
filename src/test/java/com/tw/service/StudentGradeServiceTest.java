package com.tw.service;

import com.tw.core.GradeReportBuilder;
import com.tw.core.respository.StudentRepository;
import com.tw.core.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by jxzhong on 2017/7/27.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentGradeServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private GradeReportBuilder gradeReportBuilder;

    @Test
    public void shoud_add_student() throws Exception {
        //Given
        Student stu = new Student("Tom", "1", 90, 88, 98, 100);
        StudentService studentGradeService = new StudentService(this.studentRepository, this.gradeReportBuilder);
        //When
        studentGradeService.addStudent(stu);
        //Then
        verify(this.studentRepository, times(1)).addStudents(stu);
    }


    @Test
    public void shoud_search_student_call() throws Exception {
        //Given
        String keyWords= anyString();
        StudentService studentGradeService = new StudentService(this.studentRepository, this.gradeReportBuilder);
        //When
        List<Student> students = studentGradeService.findByNumberOrName(keyWords);
        //Then
        verify(this.studentRepository,times(1)).findByNumberOrNumber(keyWords);

    }
}
