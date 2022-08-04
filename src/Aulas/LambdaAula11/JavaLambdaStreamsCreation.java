package Aulas.LambdaAula11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaLambdaStreamsCreation {
    public static void main(String[] args) {
        
        // Collection
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list.stream()
            .forEach(System.out::println);

        // Arrays
        Integer[] intArray = new Integer[] {1,2,3,4,5};
        Arrays.stream(intArray)
            .forEach(System.out::println);

        // Stream.of
        Stream
            .of("Olá", "tudo", "bem", "?")
            .forEach(System.out::println);

        // IntStream.range
        IntStream
            .range(0, 5)
            .forEach(System.out::println);

        // Stream.iterate
        Stream.iterate(2, n -> n * 2)
        .limit(10)
        .forEach(System.out::println);

        // BufferedReader - lines

        File file = new File("src/LambdaAula11/streams.txt");
        try (FileReader in = new FileReader(file)) {

            BufferedReader br = new BufferedReader(in);
            br.lines()
            .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Files
        Path p = Paths.get("");
        try(Stream<Path> files = Files.list(p);) {
            
            files
            .forEach(System.out::println);

        } catch (IOException e) {
            
            System.out.println(e.getMessage());
        }

        // Random
        new Random().ints()
            .limit(10)
            .forEach(System.out::println);

        // Pattern
        String s = "Lorem ipsum dolor sit amet consectetur adipiscing elit";
        Pattern pa = Pattern.compile(" ");
        pa.splitAsStream(s)
        .forEach(System.out::println);
    }
}
