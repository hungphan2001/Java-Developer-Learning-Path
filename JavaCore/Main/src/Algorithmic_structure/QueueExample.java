package Algorithmic_structure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Tạo một Queue bằng LinkedList
        Queue<String> queue = new LinkedList<>();

        // Thêm phần tử vào hàng đợi
        queue.add("apple");
        queue.add("banana");
        queue.add("orange");

        // Hiển thị hàng đợi
        System.out.println("Queue: " + queue);

        // Truy cập phần tử đầu tiên trong hàng đợi
        String firstElement = queue.peek();
        System.out.println("First element: " + firstElement);

        // Xóa phần tử đầu tiên khỏi hàng đợi
        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement);

        // Hiển thị lại hàng đợi sau khi xóa
        System.out.println("Queue after poll: " + queue);

        // Kiểm tra xem hàng đợi có trống hay không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty);
    }
}

