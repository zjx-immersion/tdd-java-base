package com.tw.apiend.endpoints;

import com.tw.core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tw.service.StudentGradeService;

/**
 * Created by jxzhong on 2017/8/6.
 */
@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentGradeService studentGradeService;

    @Autowired
    public StudentResource(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
    }

    @PostMapping(value = "/students", produces = "application/json")
    public ResponseEntity create(@RequestBody final Student stu) {
        if (null == stu || null == stu.getName()) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        studentGradeService.addStudent(stu);
        return new ResponseEntity(stu, HttpStatus.CREATED);
    }

}
