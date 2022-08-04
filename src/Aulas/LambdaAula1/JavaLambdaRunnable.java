package Aulas.LambdaAula1;

public class JavaLambdaRunnable {
    public static void main(String[] args) throws Exception {
        
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Olá mundo");
            }
        }).run();

        new Thread(() -> System.out.println("Olá mundo")).run();
    }
}
