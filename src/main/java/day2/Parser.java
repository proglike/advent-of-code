package day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {


    public static Game parse(String line) {
        String[] enteteAndContent = line.split(":");
        String entete = enteteAndContent[0];
        String content = enteteAndContent[1];

        List<Grabs> grabs = Arrays.stream(content.split(";")).map(Parser::parseGrab).collect(Collectors.toList());

        return new Game(parsId(entete), grabs);
    }

    private static Grabs parseGrab(String grabString) {
        return new Grabs(parseRed(grabString), parseGreen(grabString), parseBlue(grabString));
    }

    private static int parseBlue(String grabString) {
        return parse("blue", grabString);
    }

    private static int parse(String color, String grabString) {
        Pattern colorPattern = Pattern.compile("(\\d*) "+color);
        Matcher matcher = colorPattern.matcher(grabString);
        if(matcher.find()){
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private static int parseRed(String grabString) {
        return parse("red", grabString);
    }

    private static int parseGreen(String grabString) {
        return parse("green", grabString);
    }

    private static int parsId(String entete) {
        Pattern idPattern = Pattern.compile("Game (\\d*)");
        Matcher matcher = idPattern.matcher(entete);
        if(matcher.matches()){
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
