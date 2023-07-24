package Synchronized;

class Braket{
    synchronized static public void generate(String threadCode) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
        }
        System.out.println("Gen by thread: "+threadCode);
    }
}
public class Static {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i =1;i<=5;i++){
                Braket.generate("Thread 1");
            }
        }).start();
        new Thread(() -> {
            for (int i =1;i<=5;i++){
                Braket.generate("Thread 2");
            }
        }).start();
    }
}
