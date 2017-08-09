package com.tw.commandend.command;

import com.tw.service.ReportService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class Command {

    protected static BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Scanner sc = new Scanner(System.in);
    public static RouteController routeController;


    private String content;
    private String state;

    private GradeCommandAdapterService gradeCommandAdapterService;


    public Command(String order) {
        this(order, "");
    }

    public Command(String state, String content) {
        this.content = content;
        this.state = state;
        this.routeController = new RouteController();
    }

    protected GradeCommandAdapterService getGradeCommandAdapterService() {
        return gradeCommandAdapterService;
    }

    public void setGradeCommandAdapterService(GradeCommandAdapterService gradeCommandAdapterService) {
        this.gradeCommandAdapterService = gradeCommandAdapterService;
    }

    public String getState() {
        return state;
    }

    public String getContent() {
        return content;
    }


    public void input() {
    }

    public void setContent(String content) {
        this.content = content;
    }
}
