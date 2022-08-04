package Aulas.LambdaAula8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JavaMethodReference {

    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // Com method reference
        list.stream()
            .forEach(System.out::println);
        // Sem method reference
        list.stream()
            .forEach(n -> System.out.println(n));


        pulaLinha();
        // métodos estáticos

        // Sem method reference
        list.stream()
        .map(n -> multiplicaPorDois(n))
            .forEach(System.out::println);
        // Com method reference
        list.stream()
            .map(JavaMethodReference::multiplicaPorDois)
                .forEach(System.out::println);


        pulaLinha();
        // Construtores

        // Sem method reference
        list.stream()
            .map(n -> new BigDecimal(n))
            .forEach(System.out::println);
        // Com method reference
        list.stream()
            .map(BigDecimal::new)
            .forEach(System.out::println);


        pulaLinha();
        // Vária Instâncias

        // Sem method reference
        list.stream()
            .map(n -> n.doubleValue())
            .forEach(System.out::println);
        // Com method reference
        list.stream()
            .map(Integer::doubleValue)
            .forEach(System.out::println);


        pulaLinha();
        // Única instância

        // Sem method reference
        BigDecimal dois = new BigDecimal(2);
        list.stream()
            .map(BigDecimal::new)
            .map(n -> dois.multiply(n))
            .forEach(System.out::println);
        // Com method reference
        list.stream()
            .map(BigDecimal::new)
            .map(dois::multiply)
            .forEach(System.out::println);

    }

    private static Integer multiplicaPorDois(Integer i){
        return i * 2;
    }

    private static void pulaLinha(){
        System.out.println("\n ------------------------------------ \n");
    }
    
}
