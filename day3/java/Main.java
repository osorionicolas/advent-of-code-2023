package day3.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    List<String> symbols = List.of("*", "#", "$", "+");
    public static void main(String[] args) throws IOException {
        //String file = "day3/input";
        String file = "day3/example1";
        //String file = "day3/example2";
        List<String> stream1 = Files.readAllLines(Paths.get(file));
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

    private static Integer part1(List<String> lines) {
        List<IntStream> nRanges = new ArrayList<>();
        List<IntStream> sRanges = new ArrayList<>();

        for(String line : lines) {
            Pattern pDots = Pattern.compile("\\.+");
            Pattern pNumber = Pattern.compile("\\d{1,3}");
            Pattern pSymbols = Pattern.compile("[*#+$]");
            System.out.println("-------NUMBERS------");

            Matcher mn = pNumber.matcher(line);
            while(mn.find()) {
                nRanges.add(IntStream.rangeClosed(mn.start(), mn.end()));
            }
            System.out.println("-------SYMBOLS------");
            Matcher ms = pSymbols.matcher(line);
            while(ms.find()) {
                sRanges.add(IntStream.rangeClosed(ms.start(), ms.end()));
            }
        }
        return 0;
    }

    private static Integer part2(Stream<String> lines) {
        return 0;
    }

    private static boolean isOverlapping(Integer x1, Integer x2, Integer y1, Integer y2) {
        return Math.max(x1,y1) <= Math.min(x2,y2);
    }
}