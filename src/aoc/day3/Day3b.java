package aoc.day3;

import aoc.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b {
    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readInput(false, 3, false);
        Pattern pattern = Pattern.compile("(do\\(\\))|(don't\\(\\))|mul\\((\\d+),\\s*(\\d+)\\)");
        BigInteger res = BigInteger.ZERO;
        boolean enable = true;

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    enable = true;
                }
                if (matcher.group(2) != null) {
                    enable = false;
                }
                if (matcher.group(3) != null && matcher.group(4) != null && enable) { // Matches "mul(X,Y)"
                    int val1 = Integer.parseInt(matcher.group(3));
                    int val2 = Integer.parseInt(matcher.group(4));
                    res = res.add(BigInteger.valueOf(val1).multiply(BigInteger.valueOf(val2)));
                }
            }
        }

        System.out.println(res);

    }
}
