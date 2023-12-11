package day3;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Nombre(int value, int line, int firstColumn, int lastColumn) {
    public List<Coordonnees> surroundingCases() {
        return IntStream.rangeClosed(firstColumn - 1, lastColumn + 1)
                .mapToObj(column -> new Coordonnees(line, column))
                .flatMap(xy -> Stream.of(
                        new Coordonnees(xy.line() - 1, xy.column()),
                        new Coordonnees(xy.line(), xy.column()),
                        new Coordonnees(xy.line() + 1, xy.column())))
                .toList();
    }
}
