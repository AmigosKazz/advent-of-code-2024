package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> readInput(boolean test, int day, boolean partb) throws IOException {
        String testdir = "";
        if (test) {
            testdir = (partb) ? "test_b" : "test_a";
        } else  {
            testdir = (partb) ? "input_b" : "input_a";
        }
        BufferedReader br = new BufferedReader(new FileReader((STR."\{testdir}/day\{day}.txt")));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}
