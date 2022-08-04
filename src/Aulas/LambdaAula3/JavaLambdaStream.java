package Aulas.LambdaAula3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaLambdaStream {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        list.stream()
            //.skip(2)
            //.limit(2)
            //.distinct() hashcode equals
            //.filter(e -> e % 2 == 0)
            //.map(e -> e * 2)
            .forEach(e -> System.out.println(e));
            //.count();

        Optional<Integer> min = list.stream()
        .min(Comparator.naturalOrder());
        System.out.println("\n" + min.get());

        Map<Boolean, List<Integer>> collectParImpar = list.stream()
        .collect(Collectors.groupingBy(e -> e % 2 == 0));
        System.out.println("\n" + collectParImpar);

        Map<Integer, List<Integer>> collectRestoPor3 = list.stream()
        .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println("\n" + collectRestoPor3);

        String collectJoining1 = list.stream()
        .map(e -> String.valueOf(e))
        .collect(Collectors.joining());
        System.out.println("\n" + collectJoining1);

        String collectJoining2 = list.stream()
        .map(e -> String.valueOf(e))
        .collect(Collectors.joining(","));
        System.out.println("\n" + collectJoining2);

        //stream - loops implícitos
        // for - while - do...while - loops explícitos
    }
}
