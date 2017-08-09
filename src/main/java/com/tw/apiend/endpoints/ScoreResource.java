package com.tw.apiend.endpoints;

import com.tw.core.Grade;
import com.tw.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jxzhong on 2017/8/9.
 */
@RestController
@RequestMapping("/api/students/{number}")
public class ScoreResource {

    private final StudentGradeService studentGradeService;

    @Autowired
    public ScoreResource(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @PostMapping(value = "/grades"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity create(@PathVariable String number, @RequestBody Grade grade) {
        if (isGradleValidated(grade)) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        studentGradeService.addGradeToStudent(number, grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(grade);
    }

    @GetMapping(value = "/grades"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity get(@PathVariable String number) {

        Grade grade = studentGradeService.getStudentGrade(number);
        return ResponseEntity.status(HttpStatus.OK).body(grade);
    }

    private boolean isGradleValidated(@Valid @RequestBody Grade grade) {
        return null == grade || null == grade.getChineseScore()
                || null == grade.getMathsScore()
                || null == grade.getEnglishScore()
                || null == grade.getProgramScore();
    }
}
