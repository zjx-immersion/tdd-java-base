import game.NumberGame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jxzhong on 2017/9/14.
 */
public class FizzBuzzWhizz {
    @Test
    public void should_get_1_when_input_1() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("1");
        //Then
        assertThat(result, is("1"));
    }

    @Test
    public void should_get_fizz_when_input_3() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("3");
        //Then
        assertThat(result, is("fizz"));
    }

    @Test
    public void should_get_buzz_when_input_5() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("5");
        //Then
        assertThat(result, is("buzz"));
    }

    @Test
    public void should_get_whizz_when_input_7() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("7");
        //Then
        assertThat(result, is("whizz"));
    }

    @Test
    public void should_get_fizzbuzzwhizz_when_input_105() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("105");
        //Then
        assertThat(result, is("fizzbuzzwhizz"));
    }

    @Test
    public void should_get_empty_when_input_not_number() throws Exception {
        //Given
        NumberGame numberGame = new NumberGame();
        //When
        String result = numberGame.convert("abc");
        //Then
        assertThat(result, is(""));

    }
}
