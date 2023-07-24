package Algorithmic_structure;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // Tạo một Deque bằng ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Thêm phần tử vào đầu trước của hàng đợi kép
        deque.addFirst("apple");
        deque.addFirst("banana");

        // Thêm phần tử vào đầu sau của hàng đợi kép
        deque.addLast("orange");

        // Hiển thị hàng đợi kép
        System.out.println("Deque: " + deque);

        // Truy cập phần tử đầu tiên trong hàng đợi kép
        String firstElement = deque.peekFirst();
        System.out.println("First element: " + firstElement);

        // Truy cập phần tử cuối cùng trong hàng đợi kép
        String lastElement = deque.peekLast();
        System.out.println("Last element: " + lastElement);

        // Xóa phần tử đầu tiên khỏi hàng đợi kép
        String removedFirst = deque.removeFirst();
        System.out.println("Removed first element: " + removedFirst);

        // Xóa phần tử cuối cùng khỏi hàng đợi kép
        String removedLast = deque.removeLast();
        System.out.println("Removed last element: " + removedLast);

        // Hiển thị lại hàng đợi kép sau khi xóa
        System.out.println("Deque after removal: " + deque);
    }
}