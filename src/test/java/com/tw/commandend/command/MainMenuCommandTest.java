package com.tw.commandend.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by jxzhong on 2017/7/31.
 */
public class MainMenuCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_get_menu_and_exit_text_when_execute_menu_command_and_input_3() throws Exception {
        //Given
        MainMenuCommand command = new MainMenuCommand("0");
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        Scanner scanner = new Scanner(System.in);
        //When
        command.sc = scanner;
        command.input();
        //Then
        assertEquals("\n" +
                "***********\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3):\n" +
                "***********\n" +
                "\n" +
                "\n" +
                "欢迎使用学生成绩管理系统，已经退出!" +
                "\n", outContent.toString());
    }


    @Test
    public void inputTest1() throws Exception {
        //Given
        RouteController controller = mock(RouteController.class);
        AddStuCommand addCommand = mock(AddStuCommand.class);

        when(controller.generateCommand("1")).thenReturn(addCommand);
        doNothing().when(addCommand).input();

        MainMenuCommand command = new MainMenuCommand("0");

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Scanner scanner = new Scanner(System.in);
        //When
        command.routeController = controller;
        command.sc = scanner;
        command.input();
        //Then
        verify(controller, times(1)).generateCommand("1");
    }
}