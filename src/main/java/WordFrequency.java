/**
 * Created by jxzhong on 2017/6/13.
 */

import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class WordFrequency {
    public static String handle(String text) {

        return text.equals("") ? text : Arrays.stream(text.split("\\s+")).collect(groupingBy(w -> w))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .map(e -> e.getKey() + " " + e.getValue().size())
                .collect(joining("\r\n"));
    }
}