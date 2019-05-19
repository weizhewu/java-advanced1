package punchTheClock;

public class Singleton {
    //创建SingLeton的一个对象
    private static Singleton instance = new Singleton();
    //让构造方法为private,这样该类就不会被实例化
    private Singleton(){

    }
    //静态方法获取唯一可以用的对象
    public static Singleton getInstance() {
        return instance;
    }
    //成员方法，显示消息
    public void showMessage(){
        System.out.println("Hello World!");
    }
}
