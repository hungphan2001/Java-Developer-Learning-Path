package Exception;

import java.io.FileNotFoundException;

public class UserDefinedException extends Throwable {
    public static void main(String[] args) {
        try{
            someMethod();
        } catch (FileNotFoundException e){
            System.out.println("Catch block of main method(FileNotFoundException)");
        } catch (UserDefinedException e){
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Catch block of main method(Exception)");
        }
    }

    private static void someMethod() throws Exception,FileNotFoundException,UserDefinedException {
        int x =3;
        switch (x){
            case 1:
                throw new FileNotFoundException();
            case 2:
                throw new Exception();
            default:
                throw new UserDefinedException();
        }
    }
}
