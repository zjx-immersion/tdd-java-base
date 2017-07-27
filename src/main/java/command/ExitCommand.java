package command;

import core.Student;
import transform.InputTransformer;

import java.io.IOException;
import java.util.List;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class ExitCommand extends Command {
    private static final String EXIT_CONTENT = "欢迎使用学生成绩管理系统，已经退出!";

    public ExitCommand(String order) {
        super(order, EXIT_CONTENT);
    }

    @Override
    public void input() {
        System.out.println(this.getContent());
        try {
            bufferedReader.close();

        } catch (IOException e) {

        }
    }
}
