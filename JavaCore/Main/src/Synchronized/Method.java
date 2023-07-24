package Synchronized;

class Brakets{
    private Object lock ="lock";
     public void generate() {
         synchronized (lock){
         for (int i = 1; i <= 10; i++) {
             try {
                 Thread.sleep(10);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             if (i <= 5) {
                 System.out.print("[");
             } else {
                 System.out.print("]");
             }
         }
         System.out.println();
     }
        for(int j =0 ;j<=10;j++){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Method {
    public static void main(String[] args) {
        Brakets brakets =new Brakets();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i =1;i<=5;i++){
                brakets.generate();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time requried for thread 1: "+(endTime-startTime));
        }).start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i =1;i<=5;i++){
                brakets.generate();
            }
            long endTime = System.currentTimeMillis();
            System.out.print("Time requried for thread 2 : "+(endTime-startTime));
        }).start();
    }
}
