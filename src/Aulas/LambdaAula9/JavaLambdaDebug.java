package Aulas.LambdaAula9;

import java.util.Arrays;
import java.util.List;

public class JavaLambdaDebug {
    
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        list.stream()
        .peek(n -> System.out.println(n + " <- Here"))
        .map(n -> {
            StringBuilder builder = new StringBuilder();
            builder.append(n);
            builder.append("s");
            builder.append("a");
            return builder;
        })
        .peek(n -> System.out.println(n + "<- Builder"))
        .forEach(System.out::println);
    }
}
