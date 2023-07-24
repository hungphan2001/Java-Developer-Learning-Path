package Algorithmic_structure;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Tạo một TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();

        // Thêm cặp khóa-giá trị vào TreeMap
        treeMap.put("apple", 10);
        treeMap.put("banana", 5);
        treeMap.put("orange", 8);

        // Truy cập giá trị dựa trên khóa
        int appleCount = treeMap.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // Kiểm tra xem TreeMap có chứa một khóa nào đó hay không
        boolean containsBanana = treeMap.containsKey("banana");
        System.out.println("TreeMap contains 'banana': " + containsBanana);

        // Xóa một cặp khóa-giá trị khỏi TreeMap
        treeMap.remove("orange");

        // Hiển thị tất cả các cặp khóa-giá trị trong TreeMap
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        // Kiểm tra kích thước của TreeMap
        int size = treeMap.size();
        System.out.println("Size of TreeMap: " + size);

        // Kiểm tra xem TreeMap có rỗng hay không
        boolean isEmpty = treeMap.isEmpty();
        System.out.println("TreeMap is empty: " + isEmpty);
    }
}

