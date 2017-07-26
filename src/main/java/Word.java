/**
 * Created by jxzhong on 2017/7/26.
 */
public class Word {
    private String value;
    private int count;

    public Word(String w, int i) {
        this.value = w;
        this.count = i;
    }

    public String getValue() {
        return this.value;
    }

    public int getCount() {
        return this.count;
    }
}
