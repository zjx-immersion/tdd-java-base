package com.tw.apiend.endpoints;

import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import com.tw.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jxzhong on 2017/8/6.
 */
@RestController
@RequestMapping("/api")
public class GradeReportResource {

    private final ReportService reportService;

    @Autowired
    public GradeReportResource(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping(value = "/gradereports",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity generate(@RequestBody final List<Student> stus) {
        if (null == stus || 0 == stus.size()) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Gradereport gradereport = reportService.generateReport(stus);
        return new ResponseEntity(gradereport, HttpStatus.CREATED);
    }

    @PostMapping(value = "/defaultgradereports",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity generate() {
        Gradereport gradereport = reportService.generateReportForAllStudents();
        return new ResponseEntity(gradereport, HttpStatus.CREATED);
    }
}
