import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jxzhong on 2017/7/25.
 */
public class WordFrequencyGameTest {
    @Test
    public void should_get_the_1_when_input_the() throws Exception {
        //Given
        String inputStr = "the";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.process(inputStr);
        //Then
        assertEquals(result, "the 1");
    }

    @Test
    public void should_process_two_words() throws Exception {
        //Given
        String inputStr = "the is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.process(inputStr);

        //Then
        assertEquals(result, "the 1/nis 1");
    }
}
