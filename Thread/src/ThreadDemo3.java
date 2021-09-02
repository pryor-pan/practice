/**
 * @Name: ThreadDemo3
 * @Description:        加锁解决懒汉线程不安全
 * @Author: panlai
 * @Date: 2021/8/10 10:33
 */

public class ThreadDemo3 {
    //懒汉模式的实现
    //创建实例的时机是第一次使用getInstance方法的时候，就比饿汉模式更晚
    static class Singleton {
        private static Singleton instance = null;
        //完全可以吧synchronized关键字加到getinstance方法前，但是这样不太好，过于粗暴
        public static Singleton getInstance(){
            //如果把关键字写在内部，就减少了串行的代码，提高了效率
            if (instance == null){
                synchronized(Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
        private Singleton(){}
    }
}
