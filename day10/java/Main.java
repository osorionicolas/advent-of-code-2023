package day10.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        //String file = "day1/input";
        String file = "day1/example1";
        //String file = "day1/example2";
        Stream<String> stream1 = Files.lines(Paths.get(file));
        long start1 = System.currentTimeMillis();
        Integer part1 = part1(stream1);
        long end1 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end1 - start1));
        System.out.println(part1);

        /*Stream<String> stream2 = Files.lines(Paths.get(file));
        long start2 = System.currentTimeMillis();
        Integer part2 = part2(stream2);
        long end2 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end2 - start2));
        System.out.println(part2);*/
    }

    private static Integer part1(Stream<String> lines) {
        return 0;
    }

    private static Integer part2(Stream<String> lines) {
        return 0;
    }

}