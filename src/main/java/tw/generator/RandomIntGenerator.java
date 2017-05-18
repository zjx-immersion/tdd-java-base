package tw.generator;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class RandomIntGenerator {

    public RandomIntGenerator() {
    }

    public String generateNums(Integer digitmax, Integer numbersNeeded) {

        Random rng = new Random();
        Set<String> generated = new LinkedHashSet<>();
        while (generated.size() < numbersNeeded) {
            Integer next = rng.nextInt(digitmax - 1) + 1;
            generated.add(next.toString());
        }
        return String.join(" ", generated);
    }
}
