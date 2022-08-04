package Aulas.LambdaAula12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaLambdaCollections {
    public static void main(String[] args) {

        // List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(n -> System.out.println(n));
        list.removeIf(n -> n % 2 == 0);
        list.forEach(n -> System.out.println(n));
        list.replaceAll(n -> n * 2);
        list.forEach(n -> System.out.println(n));

        System.out.println("---------------------------------------");

        // Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Lorem");
        map.put(1, "ipsum");
        map.put(2, "dolor");
        map.put(3, "sit");
        map.put(4, "amet");

        // forEach
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        // compute
        map.compute(1, (k, v) -> v + " Agora");
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        // merge
        map.merge(3, "!", (vOld, vNew) -> vOld + vNew);
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        // replaceAll
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
    }
    
}
