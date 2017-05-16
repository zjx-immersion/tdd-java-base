/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private String actualAnswer_1_2_3_4;

    @Before
    public void setUp() throws Exception {
        actualAnswer_1_2_3_4 = "1 2 3 4";
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        //then
        validateGuessNumber(actualAnswer_1_2_3_4, "5 6 7 8", "0A0B");
    }

    @Test
    public void should_return_1A0B_when_1_is_correct() {
        //given
        String inputAnswerStr = "1 5 6 7";
        String expectValue = "1A0B";

        //then
        validateGuessNumber(actualAnswer_1_2_3_4, inputAnswerStr, expectValue);
    }

    @Test
    public void should_return_0A2B_when_2_and_4_are_include() {
        //then
        validateGuessNumber(actualAnswer_1_2_3_4, "2 4 7 8", "0A2B");
    }


    @Test
    public void should_return_2A2B_when_1_3_are_correct_and_4_2_are_include() {
        //then
        validateGuessNumber(actualAnswer_1_2_3_4, "1 4 3 2", "2A2B");
    }

    private void validateGuessNumber(String actualAnswerStr, String inputAnswerStr, String expectValue) {
        Answer actualAnswer = Answer.createAnswer(actualAnswerStr);
        Game game = new Game(actualAnswer);
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result, is(expectValue));
    }
}
