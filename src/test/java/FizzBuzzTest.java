import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by jxzhong on 2017/6/13.
 */
public class FizzBuzzTest {
    //FizzBuzz
    //1.input 2 output 2
    //2.inuut 3 o Fizz
    //3.i 5 o Buzz
    @Test
    public void should_get_2_when_input_2() throws Exception {

        //When
        Integer input = 2;
        //Given
        FizzBuzzGame fizzBuzz = new FizzBuzzGame();
        String result = fizzBuzz.call(input);
        //Then
        assertThat(result, is(input.toString()));
    }

    @Test
    public void should_get_Fizz_when_input_3() throws Exception {

        //When
        Integer input = 3;
        //Given
        FizzBuzzGame fizzBuzz = new FizzBuzzGame();
        String result = fizzBuzz.call(input);
        //Then
        assertThat(result, is("Fizz"));
    }


    @Test
    public void should_get_Buzz_when_input_5() throws Exception {

        //When
        Integer input = 5;
        //Given
        FizzBuzzGame fizzBuzz = new FizzBuzzGame();
        String result = fizzBuzz.call(input);
        //Then
        assertThat(result, is("Buzz"));
    }


    @Test
    public void should_get_FizzBuzz_when_input_15() throws Exception {

        //When
        Integer input = 3 * 5;
        //Given
        FizzBuzzGame fizzBuzz = new FizzBuzzGame();
        String result = fizzBuzz.call(input);
        //Then
        assertThat(result, is("FizzBuzz"));
    }
}
