package command;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class MainMenuCommand extends Command {

    private static final String MAIN_CONTENT = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3）";

    public MainMenuCommand(String order) {
        super(order, MAIN_CONTENT);
    }
}
