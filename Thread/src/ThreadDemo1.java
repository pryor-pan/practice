/**
 * @Name: ThreadDemo1
 * @Description:     饿汉模式
 * @Author: panlai
 * @Date: 2021/8/10 10:00
 */

public class ThreadDemo1 {
    //Singleton类是一个单例类，只有一个实例
    static class Singleton{
        //创建一个成员，保存唯一的一个Singleton实例
        private static Singleton instance = new Singleton();
        //通过public方法来获取到这个实例
        public static Singleton getInstance(){
            return instance;
        }
        //再将类的构造方法设为私有的，以避免其他成员构建类的实例
        private Singleton(){};
    }


    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }

}
