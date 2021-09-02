import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Name: ThreadDemo
 * @Description:            实现一个自己线程池
 * @Author: panlai
 * @Date: 2021/8/13 11:50
 */

public class ThreadDemo {
    //1.描述一个任务任务，，使用runnable，不需要额外的类

    //2.组织若干个任务，使用阻塞队列
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    //3.描述一个线程用来进行工作，
    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true){
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //4.把线程组织起来
    private List<Worker> workers = new ArrayList<>();
    //线程池最大的线程数目
    private static final  int MAX_WORKERS_COUNT = 10;
    //核心接口Execute
    public void execute(Runnable command){
        try {
            if (workers.size()<MAX_WORKERS_COUNT){
                //池子里没有足够的线程,需要创建新的线程
                Worker worker = new Worker(queue);
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
