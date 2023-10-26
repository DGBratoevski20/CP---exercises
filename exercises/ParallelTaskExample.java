import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelTaskExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> System.out.println("Задача 1"));
        executor.execute(() -> System.out.println("Задача 2"));
        executor.execute(() -> System.out.println("Задача 3"));

        executor.shutdown();
    }
}