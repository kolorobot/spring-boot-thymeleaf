package pl.codeleak.selenium.support;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CaseFormat {

    public static String toLowerUnderscore(String upperCamel) {
        return Stream
                .of(upperCamel.split("(?=[A-Z])"))
                .map(s -> s.toLowerCase())
                .collect(Collectors.joining("_"));
    }

}
