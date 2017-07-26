package core;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class GradeReportBuilder {
    private final Klass klass;

    public GradeReportBuilder(Klass klass) {
        this.klass = klass;
    }

    public Gradereport build() {
        Gradereport gradereport = new Gradereport();
        gradereport.setStudentInfos(this.klass.getAllStudent());
        return gradereport;
    }
}
