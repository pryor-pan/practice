import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Name: ThreadDemo5
 * @Description:        实现一个生产者消费者模型
 * @Author: panlai
 * @Date: 2021/8/10 11:51
 */

public class ThreadDemo5 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        //创建生产者线程
        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        System.out.println("producer生产了Str：" + i);
                        queue.put("str:" + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        //消费者线程
        Thread customer = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        String elem = queue.take();
                        System.out.println("customer获取到：" + elem);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        customer.start();

        try{
            producer.join();
            customer.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
