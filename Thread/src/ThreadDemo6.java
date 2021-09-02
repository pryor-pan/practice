import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Name: ThreadDemo6
 * @Description:        线程池
 * @Author: panlai
 * @Date: 2021/8/13 11:37
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        //创建线程池方法有很多种
        //创建一个包含10个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建一个线程数量不断变化的线程池
        ExecutorService pool2 = Executors.newCachedThreadPool();

        //创建好后往里边放任务
        for (int i = 0; i < 100; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }

    }
}
