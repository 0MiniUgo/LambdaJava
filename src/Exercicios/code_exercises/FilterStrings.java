package Exercicios.code_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class FilterStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alex", "Ale", "Bruno");

        System.out.println(search(list));
    }

    /**
     * Given a list of strings, 
     * write a method that returns a list of all strings 
     * that start with the letter 'a' (lower case) 
     * and have exactly 3 letters. TIP: Use Java 8 Lambdas and Streams API's.
     */
    
    public static List<String> search(List<String> list){
        return list.stream()
            .filter(name -> name.length() == 3)
            .filter(name -> name.toLowerCase().charAt(0) == 'a')
            .collect(Collectors.toList());

    }
}
