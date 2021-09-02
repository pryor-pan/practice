/**
 * @Name: ThreadDemo2
 * @Description:        懒汉模式
 * @Author: panlai
 * @Date: 2021/8/10 10:07
 */

public class ThreadDemo2 {
    //懒汉模式的实现
    //创建实例的时机是第一次使用getInstance方法的时候，就比饿汉模式更晚
    static class Singleton {
        private static Singleton instance = null;
        public static Singleton getInstance(){
            //只有当使用instance实例的时候才创建，并非一开始就创建好。
            if (instance == null){
                instance = new Singleton();
            }
            return instance;
        }
        private Singleton(){}
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }

}
