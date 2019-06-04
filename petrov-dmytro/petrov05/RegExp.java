package ua.lpnuai.oop.petrov05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static boolean isBirthDate(String BirthDate){
        Pattern pattern = Pattern.compile("^([0-2]?\\d|3[01])-(0?\\d|1[0-2])-\\d+");
        Matcher matcher = pattern.matcher(BirthDate);
        return matcher.matches();
    }

    public static boolean isNumber(String number){
        Pattern pattern = Pattern.compile("\\+?\\d{5,12}");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
