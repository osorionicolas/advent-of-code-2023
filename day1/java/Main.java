package day1.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    static Map<String, String> numbers = Map.of("one", "o1ne", "two", "t2wo", "three", "t3hree", "four", "f4our", "five", "f5ive", "six", "s6ix", "seven", "s7even", "eight", "e8ight", "nine", "n9ine");

    public static void main(String[] args) throws IOException {
        String file = "day1/input";
        //String file = "day1/example1";
        //String file = "day1/example2";
        Stream<String> stream1 = Files.lines(Paths.get(file));
        long start1 = System.currentTimeMillis();
        Integer part1 = part1(stream1);
        long end1 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end1 - start1));
        System.out.println(part1);

        Stream<String> stream2 = Files.lines(Paths.get(file));
        long start2 = System.currentTimeMillis();
        Integer part2 = part2(stream2);
        long end2 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end2 - start2));
        System.out.println(part2);
    }

    private static Integer part1(Stream<String> lines) {
        return lines
                .map(Main::apply)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static Integer part2(Stream<String> lines) {

        return part1(lines
                .map(line -> {
                    for (Map.Entry<String, String> entry : numbers.entrySet()) {
                        line = line.replaceAll(entry.getKey(), entry.getValue());
                    }
                    return line;
                }));

    }

    private static String apply(String line) {
        String first = "";
        String second = "";

        for (char character : line.toCharArray()) {
            if (Character.isDigit(character)) {
                if (first.isEmpty()) first = String.valueOf(character);
                second = String.valueOf(character);
            }
        }

        return first.concat(second);
    }
}