package Aulas.LambdaAula5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class JavaLambdaStreamReduce {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        List<Double> list2 = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0);

        String s = "Lorem ipsum dolor sit amet consectetur adipiscing elit";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        Optional<Integer> soma = list.stream()
            .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        Optional<Integer> multi = list.stream()
            .reduce((n1, n2) -> n1 * n2);
        System.out.println(multi.get());

        Optional<Double> div = list2.stream()
            .reduce((n1, n2) -> n1 / n2);
        System.out.println(div.get());

        // n1 - n2 =/= n2 - n1 
        //   -19          3
        // n1 - n2 = -3 .parallel()
        // Subtração não é associativa 
        // Não recomendado
        Optional<Integer> sub = list.stream()
            .reduce((n1, n2) -> n1 - n2);
        System.out.println(sub.get());

        Optional<String> concatena = listStr.stream()
            .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatena.get());

        //-----------------------------------------------------

        Integer soma1 = list.stream()
            .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(soma1);

        Integer multi1 = list.stream()
            .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multi1);

        String concatena1 = listStr.stream()
            .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concatena1);

        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
            .reduce(Double.POSITIVE_INFINITY ,(n1, n2) -> Math.min(n1, n2));
            System.out.println(menorValor);

        //---------------------------------------------------

        String soma2 = list.stream()
            .reduce("",
            //Função de acumulação
                (n1, n2) -> n1.toString().concat(n2.toString()),
            //Função de Combinação
                (n1, n2) -> n1.concat(n2));
        System.out.println(soma2);
    }
}
