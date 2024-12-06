package aoc.day2;

import aoc.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2b {
    public static boolean checkSafe(List<String> numStr) {
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
        return safe;
    }

    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 2, false);

        int num_safe = 0;
        for (String line : lines) {
            String[] numStr = line.split(" ");

            List<String> numList = new ArrayList<>();
            numList.addAll(Arrays.stream(numStr).toList());
            boolean safe = checkSafe(numList);
            if (!safe) {
                for (int i = 0; i < numStr.length; i++) {
                    numList = new ArrayList<>();
                    numList.addAll(Arrays.stream(numStr).toList());
                    numList.remove(i);
                    safe = checkSafe(numList);
                    if (safe) break;
                }
                if (!safe) System.out.println(line);
            }
            num_safe += safe ? 1 : 0;
        }

        System.out.println(num_safe);
    }
}