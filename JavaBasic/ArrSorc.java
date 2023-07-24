import java.util.Scanner;

public class ArrSorc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n =");
        int n = scanner.nextInt();
        int [] arr =new int[n];
        for(int i =0;i<n;i++){
            System.out.printf("a[%d]=",i);
            arr[i]=scanner.nextInt();
        }
        sortASC(arr);
        System.out.println("Dãy số được sắp xếp tăng dần: ");
        show(arr);
        sortDESC(arr);
        System.out.println("\nDãy số được sắp xếp giảm dần: ");
        show(arr);
    }
    public static void sortASC (int [] arr){
        int temp = arr[0];
        for(int i =0 ;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }

    public static  void sortDESC (int [] arr){
        int temp = arr[0];
        for(int i =0 ;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
    public static void show(int []arr){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
