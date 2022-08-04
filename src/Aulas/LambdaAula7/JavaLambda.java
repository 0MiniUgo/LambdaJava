package Aulas.LambdaAula7;

import java.util.stream.IntStream;

public class JavaLambda {
    
    public static void main(String[] args) {

        // Usar parenteses quando: declarar tipo, mais de um arg e sem arg

        Runnable runnable = () -> System.out.println("Olá");
        
        IntStream.range(0, 5)
            .filter((int n) -> n % 2 == 0)
            .reduce((n1, n2) -> n1 + n2)
            .ifPresent(System.out::println);

        // Chaves (return + ;) pode ter mais de 1 linha
        
        IntStream.range(0, 5)
            .filter(n -> { 
                System.out.println("Dentro da função");
                return n % 2 == 0; })
            .forEach(System.out::println);
    }
}
