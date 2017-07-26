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
        String expectResult = "the 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    private void validate_Input_words_process_to_expected_word(String inputStr, String expectResult) {
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.process(inputStr);
        //Then
        assertEquals(result, expectResult);
    }

    @Test
    public void should_process_two_words() throws Exception {
        //Given
        String inputStr = "the is";
        String expectResult = "the 1/nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_pracess_two_same_words_with_sorted() throws Exception {
        //Given
        String inputStr = "the the is";
        String expectResult = "the 2/nis 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }

    @Test
    public void should_process_sorted_with_count_descending() throws Exception {
        //Given
        String inputStr = "the is is";
        String expectResult = "is 2/nthe 1";
        validate_Input_words_process_to_expected_word(inputStr, expectResult);
    }
}
