package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class Klass {
    private List<Student> students;

    public Klass() {
        students = new ArrayList<>();
    }

    public void addStudents(Student... stu) {
        this.students.addAll(asList(stu));
    }

    public List<Student> getAllStudent() {
        return this.students.stream().collect(Collectors.toList());
    }
}
