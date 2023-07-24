package JoinOverview;

public class Main {
    public int counter = 0;
    public static void main(String[] args) {
        Main main = new Main();

        Thread thread1 = new Thread(()->{
           for(int i =0;i<1000;i++){
               main.counter++;
           }
        });
        thread1.start();
        Thread thread2 = new Thread(()->{
            try {
                thread1.join(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i =0;i<1000;i++){
                main.counter++;
            }
        });
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The value of counter:"+main.counter);
    }
}
