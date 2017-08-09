package com.tw.commandend.transform;

import com.tw.core.model.Gradereport;
import com.tw.core.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/7/27.
 */
public class Transformer {

    private static final String STU_REGREX = "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";

    public static Student formatStudent(String input) {
        Student stu = null;
        Matcher matcher = Pattern.compile(STU_REGREX).matcher(input);
        if (matcher.matches()) {
            stu = new Student(matcher.group(1),
                    matcher.group(2),
                    Integer.parseInt(matcher.group(3)),
                    Integer.parseInt(matcher.group(4)),
                    Integer.parseInt(matcher.group(5)),
                    Integer.parseInt(matcher.group(6)));
        }
        return stu;
    }

    public static List<Student> formatStudentNos(String input) {
        List<Student> stus = Arrays.asList(input.split(",")).stream()
                .map(num -> new Student(num.trim()))
                .collect(Collectors.toList());
        return stus;
    }

    public static String formatReportText(Gradereport gradereport) {

        String reportTemplate = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "%1$s" +
                "========================\n" +
                "全班总分：%2$s\n" +
                "全班总平均分：%3$s";

        String gradereportItemTemplate = "%1$s|%2$d|%3$d|%4$d|%5$d|%6$d|%7$d\n";

        String itemsText = gradereport.getStudentGradeItems().stream()
                .map(item -> String.format(gradereportItemTemplate, item.getName(),
                        item.getMathsScore(),
                        item.getChineseScore(),
                        item.getEnglishScore(),
                        item.getProgramScore(),
                        item.getAvergeScore(),
                        item.getTotalScore())).collect(Collectors.joining());


        return String.format(reportTemplate,
                itemsText,
                gradereport.getTotalScore(),
                gradereport.getAvergeScore());
    }
}
