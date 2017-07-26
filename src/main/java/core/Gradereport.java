package core;

import java.util.List;
import java.util.zip.ZipFile;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class Gradereport {

    public Gradereport() {
    }

    private List<Student> studentInfos;

    public List<Student> getStudentInfos() {
        return this.studentInfos;
    }

    public void setStudentInfos(List<Student> studentInfos) {
        this.studentInfos = studentInfos;
    }
}
