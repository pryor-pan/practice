import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Name: ThreadDemo4
 * @Description: 阻塞队列
 * @Author: panlai
 * @Date: 2021/8/10 11:45
 */

public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        // BlockingQueue本身是一个接口，不能直接实例化,就类似map
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        //queue.put("hello");
        String elem = queue.take();
        System.out.println("hello");

        //也支持普通的队列的功能，但是不支持阻塞效果
        queue.offer("hello1");
        queue.poll();
        queue.element();
    }

    /**
     * 实现一个阻塞队列
     */
    //先基于数组方式实现一个普通队列
    //再改进成阻塞队列
    static class BlockingQueue1 {
        private int[] items = new int[1000];
        //head队头
        //tail队尾
        private int head = 0;
        private int tail = 0;
        private int size = 0;       //表示队列中元素个数
        //引入一个锁对象,也可以用一this直接使用来作为锁对象
        private Object locker = new Object();

        //入队列
        public void put(int value) throws InterruptedException {
            synchronized (locker){      //在此处加锁
                //队列满了，阻塞等待
                while (size == items.length) {  //如果多个线程同时被唤醒竞争锁，需要一个一个来，
                    locker.wait();
                }
                //队列没满插入到tail位置
                items[tail] = value;
                tail++;
                //处理tail超出边界
                if (tail >= items.length) {
                    tail = 0;
                }
                size++;
                locker.notifyAll();
            }

        }

        //出队列
        public Integer take() throws InterruptedException {
            int ret = 0;
            synchronized (locker){
                //对列为空，进入阻塞等待
                while (size == 0) {
                    locker.wait();
                }
                ret = items[head];
                head++;
                if (head >= items.length) {
                    head = 0;
                }
                size--;
                locker.notifyAll();
            }
            return ret;
        }

//        public static void main1(String[] args) {
//            BlockingQueue1 blockingQueue1 = new BlockingQueue1();
//
//            try {
//                blockingQueue1.put(1);
//                blockingQueue1.put(2);
//                blockingQueue1.put(3);
//                blockingQueue1.put(4);
//                blockingQueue1.put(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            System.out.println(blockingQueue1.take());
//            System.out.println(blockingQueue1.take());
//            System.out.println(blockingQueue1.take());
//            System.out.println(blockingQueue1.take());
//            System.out.println(blockingQueue1.take());
//            System.out.println(blockingQueue1.take());
//        }

        public static void main(String[] args) {
            BlockingQueue1 queue1 = new BlockingQueue1();
            Thread producer = new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {

                        try {
                            System.out.println("produce: " + i);
                            queue1.put(i);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            producer.start();
            Thread customer = new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        try {
                            System.out.println("xiaofeile: " + i);
                            queue1.take();

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

}
