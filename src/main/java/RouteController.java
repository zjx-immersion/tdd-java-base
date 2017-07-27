import command.*;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class RouteController {


    public Command generateCommand(String order) {

        Command command;
        switch (order) {
            case "0":
                command = new MainMenuCommand(order);
                break;
            case "1":
                command = new AddStuCommand(order);
                break;
            case "2":
                command = new GenGradereportCommand(order);
                break;
            case "3":
                command = new ExitCommand(order);
                break;

            default:
                command = new Command("0");
                break;
        }
        return command;
    }
}
