package test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a","bb","ccccccc","d");
        System.out.println(test(givenList));
    }

    private static List<String> test(List<String> list){

        List<String> result = list.stream()
                .collect(Collectors.toList()); // a bb ccc
        System.out.println(result);

        List<String> result1 = list.stream()
                .collect(Collectors.toUnmodifiableList()); // a bb ccc
        System.out.println(result1);

        Set<String> result2 = list.stream()
                .collect(toSet()); // bb , a , ccc
        System.out.println(result2);

        Double result3 = list.stream()
                .collect(Collectors.averagingDouble(String::length)); // a bb ccccccc 10 / 3
        System.out.println(result3);

        Double result4 = list.stream()
                .collect(Collectors.summingDouble(String::length)); // a bb ccccccc 10
        System.out.println(result4);


        Optional<String> result5 = list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder())); // Optional[]
        System.out.println(result5.orElse("빈 Optional 객체"));
        System.out.println(result5.orElseGet(String::new));



        list = new ArrayList<>(Arrays.asList("a","bb","ccccccc","d","eee","ff","ggggggg","aaa","･"));
        Map<Integer, Set<String>> result6 = list.stream()
                .collect(groupingBy(String::length, toSet()));
        System.out.println(result6);

        Map<Boolean, List<String>> result7 = list.stream()
                .collect(partitioningBy(s -> s.length() > 10));
        System.out.println(result7);

        List<Integer> numbers = Arrays.asList(40, 20 ,2, 3, 1, 43, 2004, 321);
        Optional<Integer> min = numbers.stream()
                .collect(minBy(Integer::compareTo));
        Optional<Integer> max = numbers.stream()
                .collect(maxBy(Integer::compareTo));

        if(min.isPresent()){
            System.out.println("min="+min.get());
        }else{
            System.out.println("min="+min); // optional[data]
        }
        if(min.isPresent()){
            System.out.println("max="+max.get());
        }else{
            System.out.println("max="+max); // optional[data]
        }

        Optional<String> firstElement = list.stream()
                .filter(s -> s.startsWith("aa")).findFirst();
        System.out.println(firstElement.orElse("empty Optional"));

        Optional<String> anyElement = list.stream()
                .filter(s -> s.startsWith("a")).findAny();
        System.out.println(anyElement.orElse("empty Optional"));



        return result;
    }


}
