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
        Matcher hasSpecial = special.matcher(input);
        return hasSpecial.find();
    }

    public static boolean containsVowels(String input){
        Pattern special = Pattern.compile ("[aeiouAEIOU]");
        Matcher hasSpecial = special.matcher(input);
        return hasSpecial.find();
    }

    public static boolean containsConsonants(String input){
        Pattern special = Pattern.compile ("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]");
        Matcher hasSpecial = special.matcher(input);
        return hasSpecial.find();
    }

    public static boolean containsWhiteSpace(String input){
        return input.chars().anyMatch(Character::isWhitespace);
    }

    public static void main(String[] args){
        System.out.println(containsConsonants("aaa"));
    }
}
