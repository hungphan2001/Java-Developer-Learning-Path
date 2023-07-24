package Synchronized;

public class Interrupt {
    static public int balance = 1000;
    public void withdraw(int amount){
        synchronized (this){
            if(balance<=0){
                try {
                    System.out.println("Waiting for balance  updation...");
                    wait(); //wait when have content
                } catch (InterruptedException e) {
                    System.out.println("Original balance "+balance);
                    System.out.println("Withdraw amount "+amount);
                    balance = balance -amount;
                    System.out.println("Withdrawal successful and the current balance: "+balance);
                }
            } else {
                System.out.println("We are inside else");
            }
        }
    }
    public void deposit(int amount){
        System.out.println("We are deposting the amount: "+amount);
        balance =balance+amount;
    }
    public static void main(String[] args) {
        Interrupt wait = new Interrupt();
        Thread thread1 = new Thread(() -> {
            wait.withdraw(1000);
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wait.deposit(2000);
            thread1.interrupt();
        });
        thread2.start();
    }
}

