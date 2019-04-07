package punchTheClock;

public class ThreadTest1 extends Object implements Runnable {
    public  ThreadTest1(){
        int count = 10;
        while (true){
            System.out.print(count+" ");
            if (--count == 0){
                break;
            }
        }
    }
    @Override
    public void run() {
    }
    public static void main(String[] args) {
        ThreadTest1 test = new ThreadTest1();
        test.run();
    }
}
