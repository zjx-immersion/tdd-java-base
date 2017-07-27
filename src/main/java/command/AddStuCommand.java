package command;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class AddStuCommand extends Command {
    private static final String ADD_STU_CONTENT = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：";

    public AddStuCommand(String order) {
        super(order, ADD_STU_CONTENT);
    }
}
