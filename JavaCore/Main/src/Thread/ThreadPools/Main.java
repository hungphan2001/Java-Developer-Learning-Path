package Thread.ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SomeThread extends Thread {
   private String name;

    public SomeThread(String name){
    this.name = name;
   }

    @Override
    public void run() {
        System.out.println("Starting thread: "+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread ended: "+name);
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SomeThread thread1 = new SomeThread("Thread 1");
        SomeThread thread2 = new SomeThread("Thread 2");
        SomeThread thread3 = new SomeThread("Thread 3");
        SomeThread thread4 = new SomeThread("Thread 4");
        SomeThread thread5 = new SomeThread("Thread 5");
        SomeThread thread6 = new SomeThread("Thread 6");
        SomeThread thread7 = new SomeThread("Thread 7");
        SomeThread thread8 = new SomeThread("Thread 8");
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        executorService.execute(thread6);
        executorService.execute(thread7);
        executorService.execute(thread8);

        executorService.shutdown();
    }

}
