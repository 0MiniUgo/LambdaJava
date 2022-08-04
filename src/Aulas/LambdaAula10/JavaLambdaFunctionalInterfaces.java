package Aulas.LambdaAula10;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class JavaLambdaFunctionalInterfaces {
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        
        Stream.generate(() -> new Random().nextInt()) // <- Supplier - Fornece
            .limit(6)
            .forEach(n -> System.out.println(n)); // <- Consumer - Consome 

        list.stream()
            .filter(e -> e % 2 == 0) // <- Predicate - Compara
            .map(n -> n + 1) // <- Function - Recebe um valor e retorna outro podendo ser diferente
            .reduce((n1, n2) -> n1 + n2) // <- BinaryOperator - extends BiFunction e o valor retornado é do mesmo tipo que o recebido
            .ifPresent(System.out::println);
    }
}
