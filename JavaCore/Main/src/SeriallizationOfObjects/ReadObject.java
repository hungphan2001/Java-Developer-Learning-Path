package SeriallizationOfObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("test.dat")){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                Vehicle v1 = (Vehicle) objectInputStream.readObject();
                Vehicle v2 = (Vehicle) objectInputStream.readObject();
                System.out.println("Object 1: "+v1);
                System.out.println("Object 2: "+v2);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
