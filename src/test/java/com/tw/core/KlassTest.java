package com.tw.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class KlassTest {
    @Test
    public void should_get_students_after_insert_two_students() throws Exception {
        //Given
        Student stu1 = new Student("Tom", "1", 90, 88, 98, 100);
        Student stu2 = new Student("Jim", "2", 95, 98, 92, 80);
        Klass klass = new Klass();

        //When
        klass.addStudents(stu1, stu2);
        List<Student> students = klass.getAllStudent();

        //Then
        assertEquals(students.size(), 2);
    }
}
