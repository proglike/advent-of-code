package day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @Test
    void parse_one_number() {
        List<String> input = List.of("..........",
                "617*......",
                "..........");

        assertThat(new Parser().extract(input)).containsExactly(617);
    }

    @Test
    void parse_one_number_at_end_of_line() {
        List<String> input = List.of("..........",
                "......*617",
                "..........");

        assertThat(new Parser().extract(input)).containsExactly(617);
    }

    @Test
    void parse_one_number_not_near_special_char() {
        List<String> input = List.of("..........",
                ".......617",
                "..........");

        assertThat(new Parser().extract(input)).isEmpty();
    }

    @Test
    void parse_one_number_with_special_char_up() {
        List<String> input = List.of("........*.",
                ".......617",
                "..........");

        assertThat(new Parser().extract(input)).containsExactly(617);
    }

    @Test
    void parse_numbers_separated_with_special_char_up() {
        List<String> input = List.of("........*.",
                "....12*617",
                "..........");

        assertThat(new Parser().extract(input)).containsExactly(12, 617);
    }

    @Test
    void test_input() {
        List<String> input = List.of("467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..");

        assertThat(new Parser().extract(input).stream().mapToInt(Integer::intValue).sum()).isEqualTo(4361);
    }

    @Test
    void name() {
        List<String> input = List.of("12.......*..",
                "+.........34",
                ".......-12..",
                "..78........",
                "..*....60...",
                "78.........9",
                ".5.....23..$",
                "8...90*12...",
                "............",
                "2.2......12.",
                ".*.........*",
                "1.1..503+.56");

        assertThat(new Parser().extract(input).stream().mapToInt(Integer::intValue).sum()).isEqualTo(925);

    }

    @Test
    void name2() {
        List<String> input = List.of("12.......*..",
                "+.........34",
                ".......-12..",
                "..78........",
                "..*....60...",
                "78..........",
                ".......23...",
                "....90*12...",
                "............",
                "2.2......12.",
                ".*.........*",
                "1.1.......56");

        assertThat(new Parser().extract(input).stream().mapToInt(Integer::intValue).sum()).isEqualTo(413);

    }
    @Test
    void name3() {
        List<String> input = List.of(
                ".......5......\n" +
                "..7*..*.....4*\n" +
                "...*13*......9\n" +
                ".......15.....\n" +
                "..............\n" +
                "..............\n" +
                "..............\n" +
                "..............\n" +
                "..............\n" +
                "..............\n" +
                "21............\n" +
                "...*9.........");

        assertThat(new Parser().extract(input)).containsExactly(5,7,4,13,9,15,9);

        assertThat(new Parser().extract(input).stream().mapToInt(Integer::intValue).sum()).isEqualTo(62);

    }
}
