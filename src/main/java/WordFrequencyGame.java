import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by jxzhong on 2017/7/25.
 */
public class WordFrequencyGame {
    public String process(String inputStr) {
        String[] wordArr = inputStr.split(" ");
        List<Word> wordList = Arrays.stream(wordArr).map(w -> new Word(w, 1)).collect(Collectors.toList());
        return wordList.stream().map( w -> w.getValue() + " " + w.getCount()).collect(joining("/n"));
    }
}
