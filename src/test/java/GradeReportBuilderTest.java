import core.GradeReportBuilder;
import core.Gradereport;
import core.Klass;
import core.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/7/26.
 */

@RunWith(MockitoJUnitRunner.class)
public class GradeReportBuilderTest {

    @Mock
    private Klass klass;

    @Test
    public void should_get_report_includes_students() throws Exception {
        //Given
        GradeReportBuilder reportBuilder = new GradeReportBuilder(klass);
        List<Student> students = asList(new Student("Tom", "1", 90, 88, 98, 100));
        when(klass.getAllStudent()).thenReturn(students);

        //When
        Gradereport report = reportBuilder.build();

        //Then
        assertThat(report.getStudentInfos(), is(students));
    }
}
