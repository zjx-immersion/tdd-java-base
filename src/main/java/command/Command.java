package command;

import service.StudentGradeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class Command {

    protected static BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private String content;
    private String state;

    private StudentGradeService studentGradeService;


    public Command(String order) {
        this(order, "");
    }

    public Command(String state, String content) {
        this.content = content;
        this.state = state;
    }

    protected StudentGradeService getStudentGradeService() {
        return studentGradeService;
    }

    public void setStudentGradeService(StudentGradeService studentGradeService) {
        this.studentGradeService = studentGradeService;
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
