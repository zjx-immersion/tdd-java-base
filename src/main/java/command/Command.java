package command;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class Command {

    private String content;
    private String state;

    public Command(String order) {
        this(order, "");
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
