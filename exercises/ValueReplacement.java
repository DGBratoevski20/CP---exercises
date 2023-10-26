import java.util.concurrent.TimeUnit;

public class ValueReplacement {
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;

        System.out.println("Текущи стойности: a = " + a + ", b = " + b);

        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        a = 30;
        b = 40;

        System.out.println("Нови стойности: a = " + a + ", b = " + b);
    }
}