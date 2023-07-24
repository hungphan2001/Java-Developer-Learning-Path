package SeriallizationOfObjects;

import java.io.*;

public class WriteObject {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle("bike",9888);
        Vehicle car = new Vehicle("car",7779);
        try(FileOutputStream fos = new FileOutputStream("test.dat")) {
            try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
           obj.writeObject(bike);
           obj.writeObject(car);
           System.out.println("Object written onto the file");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
        //System.out.println(bike);
    }
}
