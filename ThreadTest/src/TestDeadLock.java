import java.util.concurrent.TimeUnit;

/**
 * created by Administrator on 2021/5/2
 */

class MyResource implements  Runnable{

    private String lockA;
    private String lockB;

    public MyResource(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"持有A，想要获取B");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"持有B，想要获取B");
            }

        }

    }
}

public class TestDeadLock {

    public static void main(String[] args) {
        new Thread(new MyResource("LOCKA","LOCKB"),"aa").start();
        new Thread(new MyResource("LOCKB","LOCKA"),"bb").start();


    }



}
