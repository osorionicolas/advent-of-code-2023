package day2.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Map<String, Integer> colors = Map.of("red", 12, "green", 13, "blue", 14);
    static Pattern p = Pattern.compile("(\\d{1,2})\\s((blue)|(red)|(green))");

    public static void main(String[] args) throws IOException {
        String file = "day2/input";
        //String file = "day2/example1";
        //String file = "day2/example2";
        List<String> lines = Files.readAllLines(Paths.get(file));
        long start1 = System.currentTimeMillis();
        Integer part1 = part1(lines);
        long end1 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end1 - start1));
        System.out.println(part1); // 2593

        long start2 = System.currentTimeMillis();
        Integer part2 = part2(lines);
        long end2 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: " + (end2 - start2));
        System.out.println(part2); // 54699
    }

    private static Integer part1(List<String> lines) {
        int result = 0;
        for(int i = 0; i < lines.size(); i++) {
            boolean applies = false;
            String current = lines.get(i);
            String[] splitted = current.split(";");
            for(String split : splitted){
                Matcher m = p.matcher(split);

                while (m.find()) {
                    applies = Integer.parseInt(m.group(1)) <= colors.get(m.group(2));
                    if(!applies) break;
                }
                if(!applies) break;
            }
            if(applies) result += i + 1;
        }
        return result;
    }

    private static Integer part2(List<String> lines) {
        int result = 0;
        for (String line : lines) {
            Map<String, Integer> minimum = new java.util.HashMap<>(Map.of("red", 0, "green", 0, "blue", 0));
            int aux = 1;
            String[] splitted = line.split(";");
            for (String split : splitted) {
                Matcher m = p.matcher(split);
                while (m.find()) {
                    Integer currentValue = Integer.parseInt(m.group(1));
                    if (currentValue > minimum.get(m.group(2))) minimum.put(m.group(2), currentValue);
                }
            }
            for (Map.Entry<String, Integer> entry : minimum.entrySet()) {
                aux *= entry.getValue();
            }
            result += aux;
        }
        return result;
    }

}