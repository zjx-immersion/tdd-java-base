package com.tw.service;

import com.tw.core.model.Grade;
import com.tw.core.respository.StudentRepository;
import com.tw.core.respository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jxzhong on 2017/8/9.
 */
@Service
public class GradeService {

    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    public Boolean addOrUpdateGradeOfStudent(String stuNumber, Grade grade) {

        try {
            if (!this.studentRepository.isExist(stuNumber)) {
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
        if (!this.studentRepository.isExist(stuNumber)) {
            throw new NullPointerException("Student is not exist!");
        }
        Grade grade = this.gradeRepository.findGradeByStudentNumber(stuNumber);
        return grade;
    }

    public List<Grade> findAllGrades() {

        return this.gradeRepository.findAll();
    }
}
