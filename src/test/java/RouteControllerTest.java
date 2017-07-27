import command.Command;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class RouteControllerTest {
    @Test
    public void should_get_main_menu_command_when_first_start_with_order_0() throws Exception {
        //Given
        RouteController routeController = new RouteController();
        //When
        Command command = routeController.generateCommand("0");
        //Then
        assertEquals(command.getState(), "0");
        assertEquals(command.getContent(), "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）");
    }

    @Test
    public void should_get_add_stu_content_command_when_first_start_with_order_1() throws Exception {
        //Given
        RouteController routeController = new RouteController();
        //When
        Command command = routeController.generateCommand("1");
        //Then
        assertEquals(command.getState(), "1");
        assertEquals(command.getContent(), "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：");
    }


    @Test
    public void should_get_grade_report_content_command_when_input_order_2() throws Exception {
        //Given
        RouteController routeController = new RouteController();
        //When
        Command command = routeController.generateCommand("2");
        //Then
        assertEquals(command.getState(), "2");
        assertEquals(command.getContent(), "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    @Test
    public void should_exit_app_content_command_when_input_order_3() throws Exception {
        //Given
        RouteController routeController = new RouteController();
        //When
        Command command = routeController.generateCommand("3");
        //Then
        assertEquals(command.getState(), "3");
        assertEquals(command.getContent(), "欢迎使用学生成绩管理系统，已经退出!");
    }
}


