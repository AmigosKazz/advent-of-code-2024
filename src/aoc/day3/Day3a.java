package aoc.day3;

import aoc.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readInput(false, 3, false);

        StringBuilder inputBuilder = new StringBuilder();
        for (String singleLine : lines) {
            inputBuilder.append(singleLine);
        }
        String line = inputBuilder.toString();

        Pattern pattern = Pattern.compile("mul\\((\\d+),\\s*(\\d+)\\)");
        Matcher matcher = pattern.matcher(line);

        BigInteger res = BigInteger.ZERO;
        while (matcher.find()) {
            int val1 = Integer.parseInt(matcher.group(1));
            int val2 = Integer.parseInt(matcher.group(2));
            res = res.add(BigInteger.valueOf(val1).multiply(BigInteger.valueOf(val2)));
        }
        System.out.println(res);
    }
}
