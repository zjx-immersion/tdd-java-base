package com.tw.apiend.endpoints;

import com.tw.core.model.Grade;
import com.tw.service.GradeService;
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
@RequestMapping("/api/students/{number}/grades")
public class ScoreResource {

    private final GradeService gradeService;

    @Autowired
    public ScoreResource(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping(value = ""
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity create(@PathVariable String number, @RequestBody Grade grade) {
        if (isGradleValidated(grade)) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        gradeService.addOrUpdateGradeOfStudent(number, grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(grade);
    }

    @GetMapping(value = ""
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity get(@PathVariable String number) {

        Grade grade = gradeService.getStudentGrade(number);
        if (grade == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Student's grade is not exist!\"}");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(grade);
        }
    }

    private boolean isGradleValidated(@Valid @RequestBody Grade grade) {
        return null == grade || null == grade.getChineseScore()
                || null == grade.getMathsScore()
                || null == grade.getEnglishScore()
                || null == grade.getProgramScore();
    }
}
