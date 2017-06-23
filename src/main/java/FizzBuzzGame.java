/**
 * Created by jxzhong on 2017/6/13.
 */
public class FizzBuzzGame {
    public String call(Integer input) {

        String result = "";
        if (input % 3 == 0) {
            result += "Fizz";
        }
        if (input % 5 == 0) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            result = input.toString();
        }

        return result;
    }
}
