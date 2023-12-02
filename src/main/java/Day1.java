import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {

        try {
            URL inputFile = Day1.class.getClassLoader().getResource("day1.txt");
            assert inputFile != null;
            List<String> inputLines = Files.readAllLines(Path.of(inputFile.toURI()));
            System.out.println(solvePart(inputLines, Day1::identity));
            System.out.println(solvePart(inputLines,Day1::handleSpelledNumbers));

            // new Day1( Day1::identity).solve(inputLines);
            // new Day1( Day1::handleSpelledNumbers).solve(inputLines);

            // Day1.part1().solve(inputLines);
            // Day1.part2().solve(inputLines);
        } catch (Throwable e) {
            System.err.println("Could not load dataset");
        }
    }

    public static int solvePart(List<String> input, Function<String, String> preprocess) {
        return input.stream()
                .mapToInt(line -> calibrationValueFor(line, preprocess))
                .sum();
    }

    public static int calibrationValueFor(String line, Function<String, String> preProcessor) {
        var stringNumber = preProcessor.apply(line)
                .chars()
                .mapToObj((int c) -> (char) c)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        String firstDigit = stringNumber.substring(0, 1);
        String lastDigit = stringNumber.substring(stringNumber.length() - 1);
        return Integer.parseInt(firstDigit + lastDigit);
    }

    public static String identity(String line) {

        return line;
    }

    public static String handleSpelledNumbers(String line) {
        return line.replaceAll("zero", "zero0zero")
                .replaceAll("one", "one1one")
                .replaceAll("two", "two2two")
                .replaceAll("three", "three3three")
                .replaceAll("four", "four4four")
                .replaceAll("five", "five5five")
                .replaceAll("six", "six6six")
                .replaceAll("seven", "seven7seven")
                .replaceAll("eight", "eight8eight")
                .replaceAll("nine", "nine9nine");
    }

}