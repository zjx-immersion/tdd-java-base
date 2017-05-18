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
        String RadomNumStr = this.randomIntGenerator.generateNums(9, 4);
        Answer answer = Answer.createAnswer(RadomNumStr);
        answer.validate();
        return answer;
    }
}
