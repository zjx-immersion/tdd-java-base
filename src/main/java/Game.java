/**
 * Created by jxzhong on 2017/5/16.
 */
public class Game {
    private final Answer actualAnswer;

    public Game(Answer actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public String guess(Answer inputAnswer) {
        final int[] existRecord = {0, 0};
        this.actualAnswer.getNumList().forEach(num -> {
            int index = inputAnswer.getNumList().indexOf(num);
            if (index != -1) {
                if (index == actualAnswer.getNumList().indexOf(num)) {
                    existRecord[0]++;
                } else {
                    existRecord[1]++;
                }
            }
        });
        return String.format("%1$sA%2$sB", existRecord[0], existRecord[1]);
    }
}
