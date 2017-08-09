package com.tw.commandend.transform;

import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;
import com.tw.core.model.StudentGradeItem;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class InputTransformerTest {
    @Test
    public void should_get_stu_when_input_correct_text() throws Exception {
        //Given
        String studentInput = "Jason，122，数学：100，语文：99，英语：92，编程：100";

        //When
        Student student = Transformer.formatStudent(studentInput);

        //Then
        assertEquals(student.getName(), "Jason");
        assertEquals(student.getNumber(), "122");
        assertEquals(student.getMathsScore(), 100);
        assertEquals(student.getChineseScore(), 99);
        assertEquals(student.getEnglishScore(), 92);
        assertEquals(student.getProgramScore(), 100);
    }

    @Test
    public void shoud_get_stu_list_when_input_num_text() throws Exception {
        //Given
        String studentInput = "122 , 2";

        //When
        List<Student> stus = Transformer.formatStudentNos(studentInput);

        //Then
        assertEquals(stus.size(), 2);
        assertEquals(stus.get(0).getNumber(), "122");
    }


    @Test
    public void shoud_get_report_format_when_input_correct_report() throws Exception {
        //Given
        String reportTextOrigin = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "张三|75|95|80|82|83|332\n" +
                "李四|85|80|70|81|79|316\n" +
                "========================\n" +
                "全班总分：648\n" +
                "全班总平均分：324";

        Gradereport report = new Gradereport();
        report.setStudentGradeItems(asList(
                new StudentGradeItem("张三", "111", 75, 95, 80, 82),
                new StudentGradeItem("李四", "222", 85, 80, 70, 81)));

        //When
        String reportText = Transformer.formatReportText(report);

        //Then
        assertEquals(reportText, reportTextOrigin);
    }
}