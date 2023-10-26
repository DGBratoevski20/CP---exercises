import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RestaurantSimulation {
    public static void main(String[] args) {
        int бройМаси = 5;
        ExecutorService executor = Executors.newFixedThreadPool(бройМаси);

        for (int номерНаМасата = 1; номерНаМасата <= бройМаси; номерНаМасата++) {
            executor.execute(new Customer(номерНаМасата));
        }

        executor.shutdown();
    }

    static class Customer implements Runnable {
        private int номерНаМасата;

        public Customer(int номерНаМасата) {
            this.номерНаМасата = номерНаМасата;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Клиент на маса " + номерНаМасата + " идва.");

                try {
                    TimeUnit.SECONDS.sleep(2); // Време за обслужване
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Клиент на маса " + номерНаМасата + " напуска.");

                try {
                    TimeUnit.SECONDS.sleep(1); // Време за почистване на масата
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
