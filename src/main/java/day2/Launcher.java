package day2;

import day1.Day1;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Launcher {

    public static void main(String[] args) throws Exception {
        URL inputFile = Day1.class.getClassLoader().getResource("inputs/day2.txt");
        assert inputFile != null;
        List<String> inputLines = Files.readAllLines(Path.of(inputFile.toURI()));

        int result = inputLines.stream().map(Parser::parse)
                .filter(game -> game.satisfies(12, 13, 14))
                .mapToInt(Game::getId)
                .sum();

        int powerResult = inputLines.stream().map(Parser::parse)
                .map(Game::getMinimalSet)
                .mapToInt(Grabs::getPower)
                .sum();

        System.out.println(result);
        System.out.println(powerResult);
    }
}
