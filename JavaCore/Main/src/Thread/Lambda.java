package Thread;

public class Lambda {
    public static void main(String[] args) {
        // Tạo và bắt đầu luồng bằng cách sử dụng biểu thức lambda
        Thread thread1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread 1: " + i);
            }

        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for(int i =0;i<5;i++){
                System.out.println("Thread 2: " + i);
            }
        });
        thread2.start();
    }
}
