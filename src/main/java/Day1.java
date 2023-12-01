import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {

        try {
            URL inputFile = Day1.class.getClassLoader().getResource("day1.txt");
            assert inputFile != null;
            List<String> inputLines = Files.readAllLines(Path.of(inputFile.toURI()));
            System.out.println(solvePart1(inputLines));

        } catch (Throwable e) {
            System.err.println("Could not load dataset");
        }
    }

    public static int solvePart1(List<String> input) {
        return input.stream()
                .mapToInt(Day1::calibrationValueFor)
                .sum();
    }

    // encapsulation?
    // advent of code
    public static int calibrationValueFor(String line) {
        var stringNumber = line.chars()
                .mapToObj((int c) -> (char) c)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        String firstDigit = stringNumber.substring(0, 1);
        String lastDigit = stringNumber.substring(stringNumber.length() - 1);
        return Integer.parseInt(firstDigit + lastDigit);
    }
}