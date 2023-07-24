package File;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            //Create folder
            File directory = new File("Study");
            directory.mkdirs();
            System.out.println("Directory created");
            //Create new file
            File file = new File("Study.txt");
            try{
                file.createNewFile();
                System.out.println("File created");
            } catch (IOException e){
                System.out.println("Error occured, can created before");
            }

            //Delete files
            if(file.delete()){
                System.out.println("Deletion is successful");
            }else{
                System.out.println("Error while deleting");
            }

            //Write in file
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
                bw.write("Meomeo");
                bw.newLine();
                bw.write("Meomeo");
                System.out.println("Writing onto the file completed");
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            //Read files BufferedReader
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line=br.readLine())!=null){
                    System.out.println(line);
                }
            } catch (FileNotFoundException e){
                System.out.println("File not found!");
            }
            catch (IOException e){
                System.out.println("IOException while reading file");
            }
            //Read file with scanner
            try{
                Scanner scanner = new Scanner(new File("Study.txt"));
                String line;
                while (scanner.hasNext()){
                    line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e){
                System.out.println("Error while reading file");
            }
        }
    }
}
