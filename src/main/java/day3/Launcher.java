package day3;

import day1.Day1;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws Exception {
        URL inputFile = Day1.class.getClassLoader().getResource("inputs/day3.txt");
        assert inputFile != null;
        List<String> inputLines = Files.readAllLines(Path.of(inputFile.toURI()));

        List<Integer> numbers = new Parser().extract(inputLines);
        numbers.forEach(System.out::println);


        int result =  numbers.stream().mapToInt(Integer::valueOf).sum();

        System.out.println("result = " + result);
    }
}
