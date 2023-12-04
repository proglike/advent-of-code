package day1;

import day1.Day1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    static final List<String> INPUT = Arrays.asList(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet");
    private static final List<String> INPUT_PART2 = List.of(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen");

    @Test
    void solve_part_1() {
        int result = Day1.solvePart(INPUT, Day1::identity);
        assertThat(result).isEqualTo(142);
    }


    @Test
    void solve_part_2() {
        int result = Day1.solvePart(INPUT_PART2, Day1::handleSpelledNumbers);
        assertThat(result).isEqualTo(281);
    }

    @ParameterizedTest
    @CsvSource({
            "12,12",
            "1abc3,13",
            "pqr3stu8vwx,38",
            "a1b2c3d4e5f,15",
            "treb7uchet,77",
    })
    void each_line_retuns_its_calibration_value(String line, int expectedCalibrationValue) {
        int result = Day1.calibrationValueFor(line, Day1::identity);
        assertThat(result).isEqualTo(expectedCalibrationValue);
    }

    @ParameterizedTest
    @CsvSource({
            "two1nine,29",
            "eightwothree,83",
            "abcone2threexyz,13",
            "xtwone3four,24",
            "4nineeightseven2,42",
            "zoneight234,14",
            "7pqrstsixteen,76",
    })
    void each_line_retuns_its_calibration_value_part_2(String line, int expectedCalibrationValue) {
        int result = Day1.calibrationValueFor(line, Day1::handleSpelledNumbers);
        assertThat(result).isEqualTo(expectedCalibrationValue);
    }

    @ParameterizedTest
    @CsvSource({
            "two,two2two",
            "eightwothree,eight8eightwo2twothree3three",
          /*  "1one2,11one2",
            "eightwo3,823", */
    })
    void each_line_retuns_its_calibration_value_part_2(String line, String expectedProcessedLine) {
        String result = Day1.handleSpelledNumbers(line);
        assertThat(result).isEqualTo(expectedProcessedLine);
    }

}
