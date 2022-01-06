import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class VoynichDateiausgabe1 {
    public static void main(String[] args)
         throws FileNotFoundException{
       File file = new File("D:\\Nick\\Studium\\IntelliJ IDEA Community Edition 2021.2.2\\projects\\src\\voynich");
        Scanner scan = new Scanner(file);
        System.out.println(scan.nextLine());


    }
}

