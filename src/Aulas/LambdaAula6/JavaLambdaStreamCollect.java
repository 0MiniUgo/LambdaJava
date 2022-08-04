package Aulas.LambdaAula6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaLambdaStreamCollect {
    
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list);

        // fornecedor - acumulação - combinação 
        Set<String> collect = list.stream()
            .collect(
                () -> new HashSet<>(), 
                (l, e) -> l.add(e.toString()), 
                (l1, l2) -> l1.addAll(l2)
            );
        System.out.println(collect);

        // toList
        List<Integer> collect2 = list.stream()
        .filter((n) -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println(collect2);

        // joining
        String collect3 = list.stream()
            .map(n -> n.toString())
            .collect(Collectors.joining(","));
        System.out.println(collect3);

        // averaging
        Double media = list.stream()
            .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        // summing
        Integer soma = list.stream()
            .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(soma);

        // summarizing
        IntSummaryStatistics stats = list.stream()
            .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println("\nIntSummaryStatistics");
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getSum());

        // counting
        Long count = list.stream()
        .filter(n -> n % 2 == 1)
            .collect(Collectors.counting());
        System.out.println(count);

        // min/max
        list.stream()
            .collect(Collectors.minBy(Comparator.naturalOrder()))
            .ifPresent(System.out::println);
        list.stream()
            .collect(Collectors.maxBy(Comparator.naturalOrder()))
            .ifPresent(System.out::println);

        // groupingBy
        Map<Integer, List<Integer>> groupingByMod3 = list.stream()
            .collect(Collectors.groupingBy(n -> n % 3));
        Map<Boolean, List<Integer>> groupingByMod2 = list.stream()
            .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println(groupingByMod3);
        System.out.println(groupingByMod2);

        // partitioningBy
        Map<Boolean, List<Integer>> partitioningByMod2 = list.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioningByMod2);

        // toMap
        Map<Integer, Double> toMap = list.stream()
            .collect(Collectors.toMap(
                n -> n, n -> Math.pow(n.doubleValue(), 
                n.doubleValue())
            ));
        System.out.println(toMap);
    }
}
