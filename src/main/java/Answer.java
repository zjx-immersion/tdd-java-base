import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Answer {


    private List<String> NumList;

    public static Answer createAnswer(String inputStr) {
        Answer answer = new Answer();
        answer.setNumList(Arrays.stream(inputStr.split(" ")).collect(Collectors.toList()));
        return answer;
    }

    public List<String> getNumList() {
        return NumList;
    }

    public void setNumList(List<String> numList) {
        this.NumList = numList;
    }
}
