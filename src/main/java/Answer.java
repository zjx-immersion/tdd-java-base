import model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Answer {


    private List<String> numList;

    public static Answer createAnswer(String inputStr) {
        Answer answer = new Answer();
        answer.setNumList(Arrays.stream(inputStr.split(" ")).collect(Collectors.toList()));
        return answer;
    }

    public Record check(Answer inputAnswer) {
        Record record = new Record();
        this.numList.forEach(num -> {
            int index = inputAnswer.getNumList().indexOf(num);
            if (index != -1) {
                if (index == this.numList.indexOf(num)) {
                    record.increaseCurrentNum();
                } else {
                    record.increaseIncludeOnlyNum();
                }
            }
        });
        return record;
    }

    public List<String> getNumList() {
        return numList;
    }

    public void setNumList(List<String> numList) {
        this.numList = numList;
    }
}
