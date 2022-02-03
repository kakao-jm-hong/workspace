package thread;

public class RunnableInterface implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        RunnableInterface runnableInterface = new RunnableInterface();

        Thread thread = new Thread(runnableInterface);
        thread.setPriority(10);
        thread.start();
    }
}
