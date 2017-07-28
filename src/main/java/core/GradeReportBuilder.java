package core;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class GradeReportBuilder {
    private Klass klass;

    public GradeReportBuilder(Klass klass) {
        this.klass = klass;
    }

    public Gradereport buildIndicatedStuReport(List<Student> stuList) {
        Gradereport gradereport = new Gradereport();
        gradereport.setStudentGradeItems(this.klass.getAllStudent().stream()
                .filter(s -> stuList.stream().anyMatch(indicatedStu -> indicatedStu.getNumber().equals(s.getNumber())))
                .map(s -> new StudentGradeItem(
                        s.getName(),
                        s.getNumber(),
                        s.getMathsScore(),
                        s.getChineseScore(),
                        s.getEnglishScore(),
                        s.getProgramScore())).collect(Collectors.toList()));
        return gradereport;
    }
}
