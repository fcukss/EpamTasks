package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

private static String EMAIL_PATTERN
           = "(\\w+)(\\_)(\\w+|\\d)@(epam)\\.(com)";


    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);



    public static boolean validateEpamEmail(String email) {
        if(email !=null) {

            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        else{
            return false;
        }

    }
}





