package command;

import core.Student;
import transform.InputTransformer;

import java.io.IOException;
import java.util.List;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class GenGradereportCommand extends Command {
    private static final String GEN_GRADE_REPORT_CONTENT = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    private static final String ERROR_CONTENT = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";


    public GenGradereportCommand(String order) {
        super(order, GEN_GRADE_REPORT_CONTENT);
    }

    @Override
    public void input() {
        RouteController routeController = new RouteController();
        System.out.println(this.getContent());
        try {
            String input = bufferedReader.readLine();
            List<Student> stus = InputTransformer.formatStudentNos(input);
            if (stus.isEmpty()) {
                this.setContent(ERROR_CONTENT);
                input();
            }
            getStudentGradeService().generateReport(stus);
            routeController.generateCommand("0").input();

        } catch (IOException e) {

        }
    }
}
