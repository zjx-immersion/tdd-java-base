package tw.generator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by jxzhong on 2017/5/18.
 */
public class RandomIntGeneratorTest {


    @Test
    public void should_get_4_digits_numstr_and_every_digit_less_than_10() throws Exception {
        //given
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        //when
        String numStr = randomIntGenerator.generateNums(9, 4);
        //then
        assertThat(numStr.length(), is(7));

    }
}