package aoc.day5;

import aoc.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Util.readInput(false, 5, false);

        Map<String, List<String>> rules = new HashMap<>();
        int result = 0;
        for (String line : lines) {
            if (line.isBlank()) continue;
            if (line.contains("|")) {
                String[] arr = line.split("\\|");
                if (!rules.containsKey(arr[0])) {
                    rules.put(arr[0], new ArrayList<>());
                }
                rules.get(arr[0]).add(arr[1]);
            }
            if (line.contains(",")) {
                Map<String, Integer> lineToCheck = new HashMap<>();
                String[] splitArr = line.split(",");

                for (int i = 0; i < splitArr.length; i++) {
                    lineToCheck.put(splitArr[i], i);
                }

                boolean correct = true;
                for (Map.Entry<String, List<String>> entry : rules.entrySet()) {
                    if (lineToCheck.containsKey(entry.getKey())) {
                        int start = lineToCheck.get(entry.getKey());
                        for (String s : entry.getValue()) {
                            if (lineToCheck.containsKey(s) && start > lineToCheck.get(s)) {
                                correct = false;
                                break;
                            }
                        }
                    }
                }
                if (correct) {
                    result += Integer.parseInt(splitArr[splitArr.length / 2]);
                }
            }
        }
        System.out.println(result);
    }
}
