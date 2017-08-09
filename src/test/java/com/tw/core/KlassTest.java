package com.tw.core;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        stu1.setNumber("5");

        //Then
        assertEquals(students.size(), 2);
        assertEquals(students.get(0).getNumber(), "1");
    }

    @Test
    public void should_fuzzy_match_students_after_insert_two_students_when_input_name() throws Exception {
        //Given
        Student stu1 = new Student("Tom", "1", 90, 88, 98, 100);
        Student stu2 = new Student("Jim", "2", 95, 98, 92, 80);
        Klass klass = new Klass();

        //When
        klass.addStudents(stu1, stu2);
        List<Student> students = klass.findByNumberOrNumber("om");

        //Then
        assertEquals(students.size(), 1);
        assertThat(students.get(0).getName(), containsString("To"));
    }

    @Test
    public void should_fuzzy_match_students_after_insert_two_students_when_input_number() throws Exception {
        //Given
        Student stu1 = new Student("Tom", "001", 90, 88, 98, 100);
        Student stu2 = new Student("Jim", "2", 95, 98, 92, 80);
        Klass klass = new Klass();

        //When
        klass.addStudents(stu1, stu2);
        List<Student> students = klass.findByNumberOrNumber("1");
        stu1.setNumber("007");

        //Then
        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getNumber(), "001");
    }
}
