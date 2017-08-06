package commandend.command;

import core.Student;
import commandend.transform.Transformer;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class AddStuCommand extends Command {
    private static final String ADD_STU_CONTENT = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：";
    private static final String ERROR_CONTENT = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";

    public AddStuCommand(String order) {
        super(order, ADD_STU_CONTENT);
    }

    @Override
    public void input() {
        System.out.println(this.getContent());
        String input = sc.nextLine();
        Student stu = Transformer.formatStudent(input);
        if (stu == null) {
            this.setContent(ERROR_CONTENT);
            input();
        }
        getStudentGradeService().addStudent(stu);
        System.out.println();
        routeController.generateCommand("0").input();

    }
}
