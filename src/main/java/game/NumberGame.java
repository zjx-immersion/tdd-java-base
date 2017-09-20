package game;

/**
 * Created by jxzhong on 2017/9/14.
 */
public class NumberGame {
    public String convert(String numberStr) {
        String resultStr = "";
        int number;

        try{
            number = Integer.valueOf(numberStr);
        }
        catch (NumberFormatException ex){
            return resultStr;
        }

        if(number%3 ==0) {

            resultStr += "fizz";
        }
        if(number%5 ==0) {

            resultStr += "buzz";
        }
        if(number%7 ==0) {

            resultStr += "whizz";
        }
       return  resultStr.equals("")? numberStr:resultStr;
    }
}
