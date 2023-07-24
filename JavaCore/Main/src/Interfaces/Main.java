package Interfaces;

public class Main {
    public static void main(String[] args) {
       Phone phone = new PocoF3();
       String process = phone.process();
       String OS = phone.OS();
       int space = phone.Space();
       System.out.print(process +" "+OS +" "+ space);

    }
}