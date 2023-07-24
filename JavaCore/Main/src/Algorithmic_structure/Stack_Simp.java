package Algorithmic_structure;

import java.util.Stack;

public class Stack_Simp {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //Đẩy phần tử vào stack
        stack.push(5);
        stack.push(2);
        stack.push(8);

        System.out.println("Phan tu tren dinh "+stack.peek());

        // search an element
        int position = stack.search(2);
        System.out.println("Postion "+position);

        //Loai bo va in
        while (!stack.isEmpty()){
            int element = stack.pop();
            System.out.println("Loai bo "+element);
        }

        //check stack
        boolean isEmpty = stack.isEmpty();
        System.out.println("Stack rong "+isEmpty);

    }
}
