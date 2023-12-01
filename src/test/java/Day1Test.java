import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    static final List<String> INPUT = Arrays.asList(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet");

    @Test
    void solve_part_1() {
        int result = Day1.solvePart1(INPUT);
        assertThat(result).isEqualTo(142);
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
        int result = Day1.calibrationValueFor(line);
        assertThat(result).isEqualTo(expectedCalibrationValue);
    }

    @Test
    void name() throws URISyntaxException, IOException {
        URL inputFile = this.getClass().getClassLoader().getResource("src/main/day1.txt");

        assert inputFile != null;
        List<String> inputLines = Files.readAllLines(Path.of(inputFile.toURI()));

    }

}
