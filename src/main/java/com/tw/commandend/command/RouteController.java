package com.tw.commandend.command;

import com.tw.core.GradeReportBuilder;
import com.tw.core.respository.GradeRepository;
import com.tw.core.respository.StudentRepository;
import com.tw.service.GradeService;
import com.tw.service.ReportService;
import com.tw.service.StudentService;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class RouteController {

    private final static GradeCommandAdapterService GRADE_COMMAND_ADAPTER_SERVICE = getService();

    public RouteController() {
    }

    public Command generateCommand(String order) {

        Command command;
        switch (order) {
            case "0":
                command = new MainMenuCommand(order);
                break;
            case "1":
                command = new AddStuCommand(order);
                break;
            case "2":
                command = new GenGradereportCommand(order);
                break;
            case "3":
                command = new ExitCommand(order);
                break;
            default:
                command = new Command("0");
                break;
        }
        command.setGradeCommandAdapterService(this.GRADE_COMMAND_ADAPTER_SERVICE);
        return command;
    }

    private static GradeCommandAdapterService getService() {

        StudentRepository studentRepository = new StudentRepository();
        GradeRepository gradeRepository = new GradeRepository();
        GradeReportBuilder gradeReportBuilder = new GradeReportBuilder(studentRepository);
        StudentService studentService = new StudentService(studentRepository, gradeReportBuilder);
        GradeService gradeService = new GradeService(studentRepository, gradeRepository);
        ReportService reportService = new ReportService(studentService, gradeReportBuilder, gradeService);
        return new GradeCommandAdapterService(studentService, gradeService, reportService);
    }
}
