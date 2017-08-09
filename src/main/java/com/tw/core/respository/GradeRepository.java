package com.tw.core.respository;

import com.tw.core.model.Grade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/8/9.
 */
@Component
public class GradeRepository {

    private final List<Grade> grades;

    public GradeRepository() {
        grades = new ArrayList<>();
    }

    public boolean saveOrUpdateGrade(Grade grade) {
        try {
            Grade existGrade = findGradeByStudentNumber(grade.getStuNumber());
            if (existGrade != null) {
                this.grades.remove(existGrade);
            }
            this.grades.add(grade);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Grade findGradeByStudentNumber(String stuNubmer) {
        return this.grades.stream()
                .filter(g -> g.getStuNumber().equals(stuNubmer))
                .findFirst()
                .orElse(null);
    }

    public List<Grade> findAll() {
        return this.grades.stream().map(Grade::new).collect(Collectors.toList());
    }
}
