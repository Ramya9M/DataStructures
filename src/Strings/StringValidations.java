package Strings;

import java.util.regex.*;
public class StringValidations {

    public static boolean containsNumbersStream(String input) {
        return input.chars().anyMatch(Character::isDigit);
    }

    public static boolean containsUpperCaseLetter(String input){
        return input.chars().anyMatch(Character::isUpperCase);
    }

    public static boolean containsLowerCaseLetter(String input){
        return input.chars().anyMatch(Character::isLowerCase);
    }

    public static boolean containsSpecialCharacter(String input){
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher("fd@d");
        return hasSpecial.find();
    }

    public static boolean containsWhiteSpace(String input){
        return input.chars().anyMatch(Character::isWhitespace);
    }

}
