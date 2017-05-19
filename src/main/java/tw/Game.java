package tw;

import tw.exception.OutOfRangeAnswerException;
import tw.generator.AnswerGenerator;
import tw.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Game {
    private final Answer actualAnswer;
    private final List<GuessResult> guessResults;

    public Game(AnswerGenerator answerGenerator) throws OutOfRangeAnswerException {
        this.actualAnswer = answerGenerator.generate();
        this.guessResults = new ArrayList();
    }

    public GuessResult guess(Answer inputAnswer) {
        final int[] existRecord = actualAnswer.check(inputAnswer).getValue();
        String result = String.format("%1$sA%2$sB", existRecord[0], existRecord[1]);
        GuessResult guessResult = new GuessResult(result, inputAnswer);
        guessResults.add(guessResult);
        return guessResult;
    }

    public List<GuessResult> guessHistory() {
        return guessResults;
    }
}
