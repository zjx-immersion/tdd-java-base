package tw.generator;

import tw.Answer;
import tw.exception.OutOfRangeAnswerException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class AnswerGenerator {
    private final RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate() throws OutOfRangeAnswerException {
        List<String> numList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numList.add(this.randomIntGenerator.nextInt().toString());
        }
        Answer answer = Answer.createAnswer(String.join(" ", numList));
        answer.validate();
        return answer;
    }
}
