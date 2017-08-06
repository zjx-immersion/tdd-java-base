package com.tw.apiend.endpoints;

import com.tw.core.Gradereport;
import com.tw.core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tw.service.StudentGradeService;

import java.util.List;

/**
 * Created by jxzhong on 2017/8/6.
 */
@RestController
@RequestMapping("/api")
public class GradeReportResource {

    private final StudentGradeService studentGradeService;

    @Autowired
    public GradeReportResource(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @PostMapping(value = "/gradereports", produces = "application/json")
    public ResponseEntity get(@RequestBody final List<Student> stus) {
        if (null == stus || 0 == stus.size()) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Gradereport gradereport = studentGradeService.generateReport(stus);
        return new ResponseEntity(gradereport, HttpStatus.CREATED);
    }
}
