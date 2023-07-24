package Thread;

public class RunnableThread {
    public static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                RunnableThread.counter++;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 1; i <= 1000; i++) {
                        RunnableThread.counter++;
                    }
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        System.out.println(RunnableThread.counter);
    }
}
