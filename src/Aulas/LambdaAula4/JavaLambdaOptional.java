package Aulas.LambdaAula4;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class JavaLambdaOptional {
    
    public static void main(String[] args) {
        
        String string = "1";
        //String string = "texto";

        /*Optional<Integer> numero = converteEmNumero(string);
        numero.ifPresent(n -> System.out.println(n));*/
        converteEmNumero(string)
            .ifPresent(n -> System.out.println(n));

        Integer orElse = converteEmNumero(string).orElse(2);
        System.out.println(orElse);

        Integer orElseGet = converteEmNumero(string).orElseGet(() -> 3);
        System.out.println(orElseGet);

        Integer orElseThrow = converteEmNumero(string)
            .orElseThrow(() -> new NullPointerException("Valor invalido"));
        System.out.println(orElseThrow);

        Stream.of(1,2,3)
        .findFirst()
        .ifPresent(n -> System.out.println(n));

        int numero = converteEmNumeroInt(string)
        .orElse(2);
        System.out.println(numero);
    }

    public static Optional<Integer> converteEmNumero(String numetoStr){

        try{
            Integer integer = Integer.valueOf(numetoStr);
            return Optional.of(integer);

        }catch(Exception e){
            return Optional.empty();
        }
    }

    public static OptionalInt converteEmNumeroInt(String numetoStr){

        try{
            int integer = Integer.parseInt(numetoStr);
            return OptionalInt.of(integer);

        }catch(Exception e){
            return OptionalInt.empty();
        }
    }
}
