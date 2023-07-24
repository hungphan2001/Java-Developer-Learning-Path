package Throw;

public class Throw {
    public static void main(String[] args) {
        try {
            someMethod(2);
        } catch (ArithmeticException e) {
            System.out.println("Nó: " + e.getMessage());
        }
    }
    public static void someMethod(int n) throws ArithmeticException{
        if(n%2==1){
            throw new ArithmeticException("La so le");
        }
        System.out.println( n +" La so chan");
        int result = n/2;
        System.out.println("Kết quả sau khi chia 2= " + result );
    }
}
