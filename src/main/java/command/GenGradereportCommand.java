package command;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class GenGradereportCommand extends Command {
    private static final String GEN_GRADE_REPORT_CONTENT = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";

    public GenGradereportCommand(String order) {
        super(order, GEN_GRADE_REPORT_CONTENT);
    }
}
