import java.util.Map;
import java.util.Scanner;

public class PTB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap he so bac 2 ,a=");
        float a = scanner.nextFloat();
        System.out.print("Nhap he so bac 1 ,b=");
        float b = scanner.nextFloat();
        System.out.print("Nhap he so tu do,c=");
        float c = scanner.nextFloat();
        giaiPTBac2(a,b,c);
    }
    public static void giaiPTBac2(float a,float b,float c){
        if(a==0){
            if(b==0){
                System.out.println("PT VO NO");
            } else {
                float x = -c/b;
                System.out.println("pt co 1 no"+"x="+x);
            }
            return;
        }
        float delta = b*b-4*a*c;
        float x1,x2;
        if(delta>0){
            x1=(float)((-b+ Math.sqrt(delta))/(2*a));
            x2=(float)((-b+ Math.sqrt(delta))/(2*a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if(delta==0){
            x1=-b/(2*a);
            System.out.println("Phương trình có 1 nghiệm là: "
                    +  "x1=x2 = " + x1);
        } else {
            System.out.println("pt co vo no");
        }
    }
}