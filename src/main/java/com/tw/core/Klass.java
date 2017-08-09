package com.tw.core;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 2017/7/26.
 */

@Component
public class Klass {
    private List<Student> students;

    public Klass() {
        students = new ArrayList<>();
    }

    public void addStudents(Student... stu) {
        this.students.addAll(asList(stu));
    }

    public List<Student> getAllStudent() {
        return this.students.stream().collect(Collectors.toList());
    }

    public List<Student> findByNumberOrNumber(String keyWords) {

        return this.students.stream()
                .filter(s-> s.getNumber().toLowerCase().contains(keyWords.toLowerCase())
                        || s.getName().toLowerCase().contains(keyWords.toLowerCase()))
                .collect(Collectors.toList());
    }
}
