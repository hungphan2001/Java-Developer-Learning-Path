import java.util.HashSet;
import java.util.Set;

public class SetSimple {
    public static void main(String[] args) {
        // Tạo một HashSet
        Set<String> set = new HashSet<>();

        // Thêm phần tử vào set
        set.add("apple");
        set.add("banana");
        set.add("orange");

        // In ra các phần tử trong set
        for (String element : set) {
            System.out.println(element);
        }

        // Kiểm tra xem set có chứa một phần tử hay không
        boolean containsApple = set.contains("apple");
        System.out.println("Set contains 'apple': " + containsApple);

        // Xóa một phần tử từ set
        set.remove("banana");

        // Kiểm tra kích thước của set
        int size = set.size();
        System.out.println("Size of set: " + size);

        // Xóa tất cả các phần tử từ set
        set.clear();

        // Kiểm tra xem set có rỗng hay không
        boolean isEmpty = set.isEmpty();
        System.out.println("Set is empty: " + isEmpty);
    }
}
