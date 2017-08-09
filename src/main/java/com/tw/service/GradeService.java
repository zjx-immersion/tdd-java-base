package com.tw.service;

import com.tw.core.Grade;
import com.tw.core.Klass;
import com.tw.core.respository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jxzhong on 2017/8/9.
 */
@Service
public class GradeService {

    private final Klass klass;
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(Klass klass, GradeRepository gradeRepository) {
        this.klass = klass;
        this.gradeRepository = gradeRepository;
    }

    public Boolean addOrUpdateGradeOfStudent(String stuNumber, Grade grade) {

        try {
            if (!this.klass.isExist(stuNumber)) {
                throw new NullPointerException("tudent is not exist!");
            }
            grade.setStuNumber(stuNumber);
            if(!this.gradeRepository.saveOrUpdateGrade(grade)){
                throw new Exception("Update student with grade failed!");
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Grade getStudentGrade(String stuNumber) {
        if (!this.klass.isExist(stuNumber)) {
            throw new NullPointerException("Student is not exist!");
        }
        Grade grade = this.gradeRepository.findGradeByStudentNumber(stuNumber);
        return grade;
    }

}
