import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * created by Administrator on 2021/5/2
 */

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("callable   "+Thread.currentThread().getName());
//        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());

        Thread t1 = new Thread(futureTask,"aa");
        t1.start();

        int result1 = 20;
        int result2 = futureTask.get();

        System.out.println("******* result = " + (result1 + result2));

    }


}
