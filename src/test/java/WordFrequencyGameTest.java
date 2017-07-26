import org.junit.Test;

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
}
