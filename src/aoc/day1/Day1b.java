package aoc.day1;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1b {
    public static void main(String[] args) throws IOException {
        List<String> lines = aoc.Util.readInput(false, 1, false);

        List<Integer> left = new ArrayList<>();
        List<Integer> right =  new ArrayList<>();

        Pattern pattern =  Pattern.compile("(\\d+)[^\\d]+(\\d+)");

        for (String line : lines) {
            if (line.isEmpty()) continue;
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                left.add(Integer.parseInt(m.group(1)));
                right.add(Integer.parseInt(m.group(2)));
            }
        }

        BigInteger res = BigInteger.ZERO;
        for (Integer a: left) {
            int count = 0;
            for (Integer b : right) {
                count += a.intValue() == b.intValue() ? 1 : 0;
            }
            res = res.add(BigInteger.valueOf(a).multiply(BigInteger.valueOf(count)));
        }

        System.out.println(res);
    }
}
