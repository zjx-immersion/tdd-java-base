package tw.commands;

import tw.Answer;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class InputCommand {

    private final Answer inputAnswer;

    public InputCommand(Answer inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    public Answer input() {
        return inputAnswer;
    }
}
