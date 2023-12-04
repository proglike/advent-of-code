package day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    @Test
    void game1() {
        Game game1 = new Game(1, List.of(
                new Grabs(4, 0, 3),
                new Grabs(2, 2, 6),
                new Grabs(0, 2, 0)
        ));

        assertThat(game1.satisfies(12, 13, 14)).isTrue();
    }

    @Test
    void game3() {
        // Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
        Game game3 = new Game(3, List.of(
                new Grabs(20, 8, 6),
                new Grabs(4, 13, 5),
                new Grabs(1, 5, 0)
        ));

        assertThat(game3.satisfies(12, 13, 14)).isFalse();
    }

    @Test
    void parsing() {
        String line = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";

        Assertions.assertThat(Parser.parse(line)).isEqualTo(new Game(3, List.of(
                new Grabs(20, 8, 6),
                new Grabs(4, 13, 5),
                new Grabs(1, 5, 0)
        )));
    }


    @Test
    void filterGamesSatisfying() {
        List<String> enonce = List.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        int result = enonce.stream().map(Parser::parse)
                .filter(game -> game.satisfies(12, 13, 14))
                .mapToInt(Game::getId)
                .sum();

        assertThat(result).isEqualTo(8);
    }
}
