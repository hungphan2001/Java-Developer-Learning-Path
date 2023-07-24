package Algorithmic_structure;

import java.util.ArrayList;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        ArrayList<Integer>numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);
        System.out.println("Before sorting: " + numbers);
        Collections.reverse(numbers);
        System.out.println("After sorting: " + numbers);
    }
}
