package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.thymeleaf.util.StringUtils.indexOf;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("tum")) {
            return "The most excellent technical Uni ever.";
        } else if (query.contains("garching") || query.contains("mensa")) {
            return "GOTO mensa Garching!";
        } else if (query.contains("plus") || query.contains("add")) {
            return handleAddition(query);
        } else if (query.contains("mul") || query.contains("times")) {
            return handleMul(query);
        } else if (query.contains("name")) {
           return "MyTeam";
        } else { // TODO extend the programm here

            return "";
        }
    }

    public static String handleMul(String query) {
        int n1 = getNumber(query);
        int mod = query.indexOf("" + n1);
        mod += ("" + n1).length();
        int n2 = getNumber(query.substring(mod));
        if (n1 > 0 || n2 > 0) {
            return "" + (n1 * n2);
        }

        return "invalid";
    }

    public static String handleAddition(String query) {
        int n1 = getNumber(query);
        int mod = query.indexOf("" + n1);
                mod += ("" + n1).length();
        int n2 = getNumber(query.substring(mod));
        if (n1 > 0 || n2 > 0) {
            return "" + (n1 + n2);
        }

        return "invalid";
    }

    public static int getNumber(String str) {
        Matcher matcher = Pattern.compile("\\d+").matcher(str);
        matcher.find();
        int i = Integer.valueOf(matcher.group());
        return i;
    }

    public static void main(String[] args) {
        System.out.println(handleAddition("one 11 plus 45"));
    }
}
