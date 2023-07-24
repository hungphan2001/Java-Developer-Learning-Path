package Algorithmic_structure;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Tạo một Map bằng HashMap
        Map<String, Integer> map = new HashMap<>();

        // Thêm cặp khóa-giá trị vào Map
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("orange", 8);

        // Truy cập giá trị dựa trên khóa
        int appleCount = map.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // Kiểm tra xem Map có chứa một khóa nào đó hay không
        boolean containsBanana = map.containsKey("banana");
        System.out.println("Map contains 'banana': " + containsBanana);

        // Xóa một cặp khóa-giá trị khỏi Map
        map.remove("orange");

        // Hiển thị tất cả các cặp khóa-giá trị trong Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        // Kiểm tra kích thước của Map
        int size = map.size();
        System.out.println("Size of map: " + size);

        // Kiểm tra xem Map có rỗng hay không
        boolean isEmpty = map.isEmpty();
        System.out.println("Map is empty: " + isEmpty);
    }
}