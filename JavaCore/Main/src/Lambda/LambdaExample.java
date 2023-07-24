package Lambda;

interface Lambda {
    public void demo();
}
public class LambdaExample {
    public static void main(String[] args) {
        String x="100";
        int y =-5;
        Lambda lambda = (()->{
            System.out.println("Hello Lambda! "+(x+y));
        });
        lambda.demo();
    }
}
