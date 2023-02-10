package com.efimchick.ifmo;


import com.efimchick.ifmo.util.CourseResult;
import com.efimchick.ifmo.util.Person;
import com.efimchick.ifmo.util.Table;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collecting {

    public int sum(IntStream intStream) {
        List<Integer> listOfnumbers = intStream
                .boxed()
                .collect(Collectors.toList());

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer res = acc + x;
            return res;
        };

        Integer sum = listOfnumbers
                .stream()
                .reduce(0, getSum);
        return sum;
    }

    public int production(IntStream intStream) {
        List<Integer> listOfnumbers = intStream
                .boxed()
                .collect(Collectors.toList());

        BinaryOperator<Integer> getProd = (acc, x) -> {
            Integer res = acc * x;
            return res;
        };
        Integer product = listOfnumbers
                .stream()
                .reduce(1, getProd);
        return product;
    }

    public int oddSum(IntStream intStream) {
        List<Integer> listOfnumbers = intStream
                .boxed()
                .collect(Collectors.toList());

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer res = acc + x;
            return res;
        };

        Integer sum = listOfnumbers
                .stream()
                .filter((x)->x%2!=0)
                .reduce(0, getSum);
        return sum;
    }

    public Map<Integer, Integer> sumByRemainder(int divider, IntStream intStream) {

        return intStream.boxed().collect(Collectors.groupingBy(s -> s % divider,
                Collectors.summingInt(x -> x)));
    }

    public Map<Person, Double> totalScores(Stream<CourseResult> results) {
        List<CourseResult> courseResultList = results.collect(Collectors.toList());
        List<Double> averageValues = getAverageValues(courseResultList);
        AtomicInteger index = new AtomicInteger(0);
        return courseResultList.stream()
                .collect(Collectors.toMap(CourseResult::getPerson,
                        course -> averageValues.get(index.getAndIncrement())));
    }
    private List<Double> getAverageValues(List<CourseResult> courseResultList) {
        double amountTasks = getAmountTasks(courseResultList);
        return courseResultList.stream()
                .map(courseResult1 -> courseResult1.getTaskResults().values()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum())
                .map(integer -> integer / amountTasks)
                .collect(Collectors.toList());
    }

    public double averageTotalScore(Stream<CourseResult> results) {
        List<CourseResult> courseResultList = results.collect(Collectors.toList());
        double amountTasks = getAmountTasks(courseResultList);
        int totalSumScores = getTotalSumScores(courseResultList);
        return totalSumScores / (getAmountPersons(courseResultList) * amountTasks);
    }
    private int getTotalSumScores(List<CourseResult> courseResults) {
        return courseResults.stream()
                .map(courseResult -> courseResult.getTaskResults().values())
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private long getAmountPersons(List<CourseResult> courseResultList) {
        return courseResultList.stream()
                .map(CourseResult::getPerson)
                .count();
    }

    public Map<String, Double> averageScoresPerTask(Stream<CourseResult> results) {

        List<CourseResult> courseResultList = results.collect(Collectors.toList());
        double amountPersons = getAmountPersons(courseResultList);
        return courseResultList.stream()
                .flatMap(courseResult1 -> courseResult1.getTaskResults()
                        .entrySet()
                        .stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.summingDouble(value -> (value.getValue() / amountPersons))));

    }
    private int getAmountTasks(List<CourseResult> courseResults) {
        return (int) courseResults.stream()
                .flatMap(courseResult -> courseResult
                        .getTaskResults()
                        .keySet()
                        .stream())
                .distinct()
                .count();
    }

    public Map<Person, String> defineMarks(Stream<CourseResult> results) {
        return results.collect(
                Collectors.toMap(
                        CourseResult::getPerson,
                        x -> {
                            boolean areProgramTasks = x.getTaskResults().keySet().stream().allMatch(key -> key.startsWith("Lab "));
                            double avg;
                            if(areProgramTasks){
                                avg = x.getTaskResults().values().stream().collect(Collectors.summarizingInt(Integer::intValue)).getAverage();
                            }
                            else {
                                avg = Stream.concat(Stream.of(0), x.getTaskResults().values().stream()).collect(Collectors.summarizingInt(Integer::intValue)).getAverage();
                            }
                            if(avg >  90) return "A";
                            if(avg >= 83) return "B";
                            if(avg >= 75) return "C";
                            if(avg >= 68) return "D";
                            if(avg >= 60) return "E";
                            else return "F";
                        }
                ));
    }


    public String easiestTask(Stream<CourseResult> results) {

        Map<String, Double> map = averageScoresPerTask(results);
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .stream()
                .collect(Collectors.joining());
    }

    public Collector<CourseResult, ?, String> printableStringCollector() {
        return Collector.of(
                Table::new,
                Table::addCourseResult,
                (table, table2) -> {
                    throw new UnsupportedOperationException("Cannot be performed in parallel");
                },
                table -> {
                    StringBuilder builder = new StringBuilder();
                    table.createTable(builder);
                    return builder.toString();
                }
        );

    }
}

