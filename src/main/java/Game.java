/**
 * Created by jxzhong on 2017/5/16.
 */
public class Game {
    private final Answer actualAnswer;

    public Game(Answer actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public String guess(Answer inputAnswer) {
        final int[] existRecord = actualAnswer.check(inputAnswer).getValue();
        return String.format("%1$sA%2$sB", existRecord[0], existRecord[1]);
    }
}
