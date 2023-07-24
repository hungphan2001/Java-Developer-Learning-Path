package Exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            int x=0;
            // Một mã chứa lỗi potentional
            int result = x/1; // Gây ra ArithmeticException

        } catch (Exception e) {
            System.out.println("Runtime exception");
        }
        finally {
            System.out.println("Done");
        }
        }
}