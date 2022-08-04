package Aulas.LambdaAula2;

import java.util.Arrays;
import java.util.List;

public class JavaLambdaStream {
    
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        list.stream()
            //.skip(2)
            //.limit(2)
            //.distinct() hashcode equals
            //.filter(e -> e % 2 == 0)
            .map(e -> e * 2)
            .forEach(e -> System.out.println(e));
    }
}
