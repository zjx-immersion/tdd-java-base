package com.tw.core.respository;

import com.tw.core.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 2017/7/26.
 */

@Component
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
    }

    public void addStudents(Student... stu) {
        this.students.addAll(asList(stu));
    }

    public List<Student> getAllStudent() {
        return this.students.stream().map(Student::new).collect(Collectors.toList());
    }

    public List<Student> findByNumberOrNumber(String keyWords) {

        return this.students.stream()
                .filter(s -> s.getNumber().toLowerCase().contains(keyWords.toLowerCase())
                        || s.getName().toLowerCase().contains(keyWords.toLowerCase()))
                .map(Student::new).collect(Collectors.toList());
    }

    public Student findStudentByNumber(String stuNumber) {
        return this.students.stream()
                .filter(stu -> stu.getNumber().equals(stuNumber))
                .map(Student::new)
                .findFirst().orElse(null);
    }

    public Boolean updateStudent(Student stu) {
        try {
            this.students.remove(this.students.stream()
                    .filter(s -> s.getNumber() == stu.getNumber())
                    .findFirst().get());
            this.students.add(stu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isExist(String stuNumber) {
        return findStudentByNumber(stuNumber) != null;
    }
}
