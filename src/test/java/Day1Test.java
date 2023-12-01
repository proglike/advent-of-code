import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    //1abc2
    //pqr3stu8vwx
    //a1b2c3d4e5f
    //treb7uchet

    // uniquement 2 chiffres sans lettres : "12"
    // 2 chiffres => "1c2" on concatène en ignorant les lettres
    // plus de chiffres => on concatène uniquement le 1er et le dernier
    // un seul chiffre => on le concatène avec lui même

    @Test
    void dfsgsdfg() {
        int result = day1Line("12");
        assertThat(result).isEqualTo(12);
    }

    @Test
    void dsfhgqhjfdsj() {
        int result = day1Line("1abc3");
        assertThat(result).isEqualTo(13);
    }

    private int day1Line(String number) {
        var stringNumber = number.chars()
                .mapToObj((int c) -> Character.valueOf((char) c))
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        return Integer.valueOf(stringNumber);
    }


    @Test
    void character_is_a_digit() {
        assertThat(Character.isDigit('1')).isTrue();
    }
}
