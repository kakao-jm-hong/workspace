package thread;

public class ThreadExtendsExample extends Thread{

    @Override
    public void run() {
        System.out.println("ThreadExtendsExample.run");
    }

    public static void main(String[] args) {
        System.out.println("ThreadExtendsExample.main");
        ThreadExtendsExample threadExtendsExample = new ThreadExtendsExample();
        threadExtendsExample.start();
    }
}
