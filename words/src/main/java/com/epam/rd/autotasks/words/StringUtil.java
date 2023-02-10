package com.epam.rd.autotasks.words;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || sample == null) {
            return 0;
        }

        int count = 0;

        for (String word : words) {
            if (sample.trim().toLowerCase().equals(word.trim().toLowerCase()))
                count++;
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null||text.equals("")) return null;
        if (!text.contains("[A-Za-z]") && text.contains("^[0-9]+$"))
            return null;
        String[] res = text.trim().split("\\,|\\!|\\.|\\:|\\;|\\?|\\ ");


        ArrayList<String> temp = new ArrayList<>();
    for (int i=0; i< res.length;i++)
    if(!res[i].equals(""))
        temp.add(res[i]);

    String[]res2 = new String[temp.size()];
    for(int i=0; i<temp.size();i++)
        res2[i] = temp.get(i).strip();

    if(res2.length==0)
        return null;
        return res2;

    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals(""))
            return null;
        String res = null;
        String c = "C:";
        String a = "/";
        Path pathNew = Paths.get("C:", "User");
        String patternPath = "(?<!fil)[A-Za-z]:\\\\+[\\S\\s]*";
         if (path.indexOf(a) ==-1&& !path.contains("~"))
                  return path;

        if(path.contains("~")&& toWin==true) {

           //String test = pathNew.toString();
            String temp2 = path.replace("~", pathNew.toString());
           return temp2;
        }


        if (toWin==true && !path.contains("~")) {

            Pattern pattern = Pattern.compile(patternPath);
            Matcher m = pattern.matcher(path);
            String temp = path.replace("/", "\\");

            res = c + temp.replaceAll("@\"(?<=file:\\\\?)[^\\\\].+\"", path);
           // String res2 = temp2.replaceAll("@\"(?<=file:\\\\?)[^\\\\].+\"", path);

            return res;
        }else
            return path;

    }

    public static String joinWords(String[] words) {

        if (words == null||words.length==0)
            return null;
        int count=0;
        for(String word:words) {
            if (word.equals(""))
                count++;
        }
        if(count== words.length)
            return null;

        String res = null;
        StringBuilder sb = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("")) {
                    //i++;
                } else if (i == words.length-1) {
                    sb.append(words[i]);
                } else {
                    sb.append(words[i]).append(", ");
                }
            }
            res = "[" + sb.toString() + "]";

        return res;
    }


    public static void main(String[] args) {
//        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
//        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
//        String sample = "words   ";
//        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
//        System.out.println("Result: " + countResult);
//        int expectedCount = 2;
//        System.out.println("Must be: " + expectedCount);
//
//        System.out.println("Test 2: splitWords");
//      String text = "   ,, first, second!!!! third";
//        String[] splitResult = splitWords(text);
//        System.out.println("Result : " + Arrays.toString(splitResult));
//        String[] expectedSplit = new String[]{"first", "second", "third"};
//        System.out.println("Must be: " + Arrays.toString(expectedSplit));
//
        System.out.println("Test 3: convertPath");
   //     String unixPath = "/some/unix/path";
        String unixPath =  "~/";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

//        System.out.println("Test 4: joinWords");
//        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
//        String joinResult = joinWords(toJoin);
//        System.out.println("Result: " + joinResult);
//        String expectedJoin = "[go, with, the, FLOW]";
//        System.out.println("Must be: " + expectedJoin);
    }
}