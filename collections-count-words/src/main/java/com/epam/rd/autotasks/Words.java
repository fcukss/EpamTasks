package com.epam.rd.autotasks;


import java.util.*;
import java.util.function.Consumer;

public class Words {

    public String countWords(List<String> lines) {

        Map<String, Integer> map = new HashMap<>();
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("[-.,:;()?!\"\\s–]+");
            while (scanner.hasNext())
                words.add(scanner.next());
            scanner.close();
        }

        Set<String> set = new HashSet<String>(words);
        for (String key : set) {
            if (key.length() >= 4) {
                map.put(key.toLowerCase(), Collections.frequency(words, key));
            }
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(new Consumer<Map.Entry<String, Integer>>() {
                    @Override
                    public void accept(Map.Entry<String, Integer> x) {
                        if (x.getValue() >= 10) {
                            sb.append(x).append("\n");
                        }
                    }
                });


        sb.setLength(sb.length() - 1);
        String str = sb.toString();
        String res = str.replace("=", " - ");
        return res;

    }
}
