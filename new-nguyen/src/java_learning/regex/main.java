package java_learning.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        String str = "Nguyen Duc Nguyen, 24-10-2003";
        String regex_name = "^[\\w\\s+]+";
        String regex_date = "\\d{2}[/\\_-]\\d{2}[/\\_-]\\d{4}$";
        Pattern pt = Pattern.compile(regex_name);
        Matcher name = pt.matcher(str);
        Pattern pt2 = Pattern.compile(regex_date);
        Matcher date = pt2.matcher(str);
        while(name.find())
        {
            System.out.println(str.substring(name.start(), name.end()));
        }
        while(date.find())
        {
            System.out.println(str.substring(date.start(), date.end()));
        }
    }
}
