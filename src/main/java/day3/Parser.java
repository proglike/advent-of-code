package day3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class Parser {

    public List<Integer> extract(List<String> input) {

        String inlined = join("\n", input);

        int currentLine = 0;
        int currentColumn = 0;
        boolean isNumberPending = false;
        int currentNumber = 0;
        int firstDigitColumn = 0;
        List<Nombre> nombres = new ArrayList<>();
        List<Coordonnees> specialChars = new ArrayList<>();

        for (int i = 0; i < inlined.length(); i++) {
            char currentCharacter = inlined.charAt(i);
            if (currentCharacter == '\n') {
                if (isNumberPending) {
                    nombres.add(new Nombre(currentNumber, currentLine, firstDigitColumn, currentColumn-1));
                    isNumberPending = false;
                }
                currentLine += 1;
                currentColumn = 0;
            } else if (currentCharacter == '.') {
                if (isNumberPending) {
                    nombres.add(new Nombre(currentNumber, currentLine, firstDigitColumn, currentColumn-1));
                    isNumberPending = false;
                }
                currentColumn += 1;
            } else if (Character.isDigit(currentCharacter)) {
                if (!isNumberPending){
                    currentNumber = 0;
                    firstDigitColumn = currentColumn;
                    isNumberPending = true;
                }
                currentNumber = currentNumber*10 + (currentCharacter - '0');
                currentColumn += 1;
            } else {
                if (isNumberPending) {
                    nombres.add(new Nombre(currentNumber, currentLine, firstDigitColumn, currentColumn-1));
                    isNumberPending = false;
                }
                specialChars.add(new Coordonnees(currentLine, currentColumn));
                currentColumn += 1;
            }
        }
        if (isNumberPending) {
            nombres.add(new Nombre(currentNumber, currentLine, firstDigitColumn, currentColumn-1));
        }

        return nombres.stream()
                .filter(number -> isNearSpecialCharacters(number, specialChars))
                .map(Nombre::value)
                .toList();
    }

    private boolean isNearSpecialCharacters(Nombre number, List<Coordonnees> specialChars) {
        return number.surroundingCases().stream()
                .anyMatch(specialChars::contains);
    }
}
