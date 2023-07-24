package Synchronized;

public class Wait {
    static public int balance = 0;
    public void withdraw(int amount){
        synchronized (this){
            if(balance<=0){
                try {
                    System.out.println("Waiting for balance...");
                    wait(); //wait when have content
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        balance = balance -amount;
        System.out.println("Withdrawal successful and the current balance: "+balance);
    }
    public void deposit(int amount){
        System.out.println("We are deposting...");
        balance =balance+amount;
        synchronized (this){
            notify(); // Thức tỉnh luồng đang chờ
        }
    }
    public static void main(String[] args) {
        Wait wait = new Wait();
        Thread thread1 = new Thread(() -> {
            wait.withdraw(1000);
        });
        thread1.setName("Thread 1");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wait.deposit(3000);
        });
        thread2.setName("Thread 2");
        thread2.start();
    }
}
