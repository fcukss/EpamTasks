package com.epam.rd.autotasks;


import java.util.*;

import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {


        Map<String, Integer> map;

   List<String> words = new ArrayList<>();

        lines.stream().map(Scanner::new).forEach(scanner -> {

            scanner.useDelimiter("[-.,:;()?!\"\\s–]+");
            while (scanner.hasNext())
                words.add(scanner.next());
            scanner.close();
        });

        Set<String> set = new HashSet<>(words);
        map = set.stream().filter(key -> key.length() >= 4).collect(Collectors.toMap(String::toLowerCase, key -> Collections.frequency(words, key), (a, b) -> b));

        StringBuilder sb = new StringBuilder();

        List<Map.Entry<String, Integer>> listToSort = new ArrayList<>();
        listToSort.addAll(map.entrySet());
        listToSort.sort(Map.Entry.comparingByKey());
        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        toSort.addAll(listToSort);
        toSort.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        toSort.stream().filter(x -> x.getValue() >= 10).forEach(x -> sb.append(x).append("\n"));


        sb.setLength(sb.length() - 1);
        String str = sb.toString();
        String res = str.replace("=", " - ");
        return res;

    }
}
