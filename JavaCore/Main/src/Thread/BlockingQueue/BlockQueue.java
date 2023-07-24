package Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;
    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue =queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                queue.put(BlockQueue.counter++);
                System.out.println("Value added in the queue: "+BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Comsumer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;
    public Comsumer(ArrayBlockingQueue<Integer> queue){
        this.queue =queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                queue.take();
                BlockQueue.counter--;
                System.out.println("Value removed in the queue: "+BlockQueue.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class BlockQueue {
    static int counter =0;
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Thread producerThread = new Thread(producer);
        Comsumer comsumer = new Comsumer(queue);
        Thread comsumerThread = new Thread(comsumer);
        producerThread.start();
        comsumerThread.start();
    }
}
