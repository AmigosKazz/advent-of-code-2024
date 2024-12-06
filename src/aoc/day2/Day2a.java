package aoc.day2;

import java.io.IOException;
import java.util.List;

public class Day2a {
    public static void main(String[] args) throws IOException {
        List<String> lines = aoc.Util.readInput(false, 2, false);

        int num_safe = 0;
        for (String line : lines) {
            String[] numStr = line.split(" ");
            int currentNum = -1;
            int inc = 0;
            boolean safe = true;
            for (String num : numStr) {
                int number = Integer.parseInt(num);
                if (currentNum == -1) {
                    currentNum = number;
                    continue;
                }
                if (currentNum > number) {
                    if (inc > 0) {
                        safe = false;
                        break;
                    } else if (inc == 0) {
                        inc = -1;
                    }
                    if (Math.abs(currentNum - number) > 3) {
                        safe = false;
                        break;
                    }
                    currentNum = number;
                } else if (currentNum < number) {
                    if (inc < 0) {
                        safe = false;
                        break;
                    } else if (inc == 0) {
                        inc = 1;
                    }
                    if (Math.abs(currentNum - number) > 3) {
                        safe = false;
                        break;
                    }
                    currentNum = number;
                } else {
                    safe = false;
                    break;
                }
            }
            num_safe += safe ? 1 : 0;
        }

        System.out.println(num_safe);
    }
}
