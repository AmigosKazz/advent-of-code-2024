package aoc.day1;

import aoc.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readInput(false, 1, false);

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

        left.sort(Integer::compare);
        right.sort(Integer::compare);

        int res = 0;
        for (int i = 0; i < left.size(); i++) {
            System.out.println(STR."\{right.get(i)} \{left.get(i)}");
            if (right.get(i) > left.get(i)) {
                res += right.get(i) - left.get(i);
            } else {
                res += left.get(i) - right.get(i);
            }
        }

        System.out.println(res);
    }
}