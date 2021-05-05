import java.util.concurrent.*;

/**
 * created by Administrator on 2021/5/2
 */
public class TestThreadPool {


    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {

            for (int i = 0; i <15 ; i++) {
                threadPool.execute(()->{
                    System.out.println("办理业务"+Thread.currentThread().getName());

                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }


    public static void testThreadPool(){

        // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {

            for (int i = 0; i <10 ; i++) {
                threadPool.execute(()->{

                    System.out.println("办理业务"+Thread.currentThread().getName());

                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }

}
