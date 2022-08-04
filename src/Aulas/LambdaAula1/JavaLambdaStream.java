package Aulas.LambdaAula1;
import java.util.Arrays;
import java.util.List;

public class JavaLambdaStream {
    public static void main(String[] args) {

        //stream - fluxo de dados
        
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream()
        .filter(e -> e % 2 == 0)
        .forEach(e -> System.out.println(e));
    }
}
