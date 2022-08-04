package Aulas.LambdaAula13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaLambdaStreamsParalelos {
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // Usar quando precisar de performance 

        // forEach x forEachOrdered
        list.parallelStream()
            .forEach(System.out::println);
        System.out.println("--------");
        list.parallelStream()
            .forEachOrdered(System.out::println);

        System.out.println("-------------------------------");

        list.parallelStream()
            .findAny()
            .ifPresent(System.out::println);
        System.out.println("--------");
        list.stream()
            .findAny()
            .ifPresent(System.out::println);

        System.out.println("-------------------------------");

        // unorded
        list.parallelStream()
            .unordered()
            .skip(1)
            .limit(2)
            .forEach(System.out::println);

        System.out.println("-------------------------------");

        // reduce
        // 1 + 2 + 3 + 4 = (1 + 2) + (3 + 4) <- associativa
        // 1 - 2 - 3 - 4 != (1 - 2) - (3 - 4) <- não associativa
        list.parallelStream()
            .reduce((n1, n2) -> n1 + n2)
            .ifPresent(System.out::println);

        // toMap
        Map<Integer, Boolean> map = 
            list.parallelStream()
            .collect(
                Collectors
                .toConcurrentMap(n -> n, n-> n % 2 == 0)
            );
        System.out.println(map);
        System.out.println("--------");

        // toMap
        Map<Boolean, List<Integer>> groupingBy = 
            list.parallelStream()
            .collect(
                Collectors
                .groupingByConcurrent(n-> n % 2 == 0)
            );
        System.out.println(groupingBy);
    }
}
