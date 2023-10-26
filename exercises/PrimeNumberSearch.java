import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeNumberSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете началото на интервала: ");
        int start = scanner.nextInt();

        System.out.print("Въведете края на интервала: ");
        int end = scanner.nextInt();

        System.out.print("Въведете брой нишки (потребители): ");
        int numThreads = scanner.nextInt();

        int intervalSize = (end - start + 1) / numThreads;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            int threadStart = start + i * intervalSize;
            int threadEnd = threadStart + intervalSize - 1;
            if (i == numThreads - 1) {
                // Последната нишка може да включва остатъка от интервала
                threadEnd = end;
            }

            Runnable task = new PrimeFinder(threadStart, threadEnd);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}



class PrimeFinder implements Runnable {
    private int start;
    private int end;

    public PrimeFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.println(num + " е просто число.");
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}