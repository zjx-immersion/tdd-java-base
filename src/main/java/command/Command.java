package command;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class Command {
    private static final String MAIN_CONTENT = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3）";

    private String content;
    private String state;

    public Command(String order) {
        this(order, MAIN_CONTENT);
    }

    public Command(String state, String content) {
        this.content = content;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getContent() {
        return content;
    }

}
