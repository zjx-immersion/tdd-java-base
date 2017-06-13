/**
 * Created by jxzhong on 2017/6/13.
 */
public class Caculator {
    public int add(int input1, int input2) {
        return addPrivate(input1, input2);
    }

    private int addPrivate(int input1, int input2) {
        return input1 + input2;
    }
}
