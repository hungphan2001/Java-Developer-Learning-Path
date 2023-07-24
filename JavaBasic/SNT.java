import java.util.Scanner;

public class SNT {
    public static void main(String[] args) {
        System.out.print("Nhap n= ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean isPrime = isPrimeNumber(n);
            if (isPrime) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không là số nguyên tố.");
            }
    }

    public static boolean isPrimeNumber (int n){
        if(n<2){
            return false;
        }
        int squareRoot = (int)Math.sqrt(n);
        for(int i =2 ;i<=squareRoot;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
