package aoc.day5;

import aoc.Util;

import java.io.IOException;
import java.util.*;

public class day5b {
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
                String[] splitArr = line.split(",");

                List<String> before = Arrays.asList(splitArr);
                List<String> after = new ArrayList<>();
                after.addAll(Arrays.asList(splitArr));

                after.sort((a, b) -> {
                    if (!rules.containsKey(a)) return 0;
                    List<String> right = rules.get(a);
                    if (right.contains(b)) return -1;
                    return 0;
                });

                if (!before.toString().equals(after.toString())) {
                    result += Integer.parseInt(after.get(after.size() / 2));
                }
            }
        }

        System.out.println(result);
    }
}
