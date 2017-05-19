package tw.commands;

import tw.Answer;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GuessInputCommand implements InputCommand {

    private final Answer inputAnswer;

    public GuessInputCommand(Answer inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    @Override
    public Answer input() {
        return inputAnswer;
    }
}
