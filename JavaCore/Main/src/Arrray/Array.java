package Arrray;

import java.util.ArrayList;

public class Array {
    static ArrayList <String> list = new ArrayList<>();
    public static void main(String[] args) {
        list.add("A");
        list.add("B");
        list.add("C");
        Array app = new Array();
        app.displayList(list);
        int position = app.search("B");
        if(position != -1){
            app.modifyName(position,"D");
        }else {
            System.out.println("Invalid Entry");
        }
    }
     void displayList(ArrayList<String> names) {
        for(String name :names){
            System.out.println(name);
        }
    }
    void modifyName(int position,String newName){
        list.set(position,newName);
    }
    int search(String name){
        return list.indexOf(name);
    }
}
