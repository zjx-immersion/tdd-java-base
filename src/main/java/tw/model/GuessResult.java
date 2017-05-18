package tw.model;

import tw.Answer;

/**
 * Created by jxzhong on 2017/5/18.
 */
public class GuessResult {
    private final Answer inputAnswer;
    private final String result;

    public GuessResult(String result, Answer inputAnswer) {
        this.result = result;
        this.inputAnswer = inputAnswer;
    }

    public String result() {
        return result;
    }

    public Answer inputAnswer() {
        return inputAnswer;
    }
}
