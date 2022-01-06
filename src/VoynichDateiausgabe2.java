import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class VoynichDateiausgabe2 {

    public static void main(String[] args) {
    
        ausgabeHaeufigkeiten(outpuVoynich());



    }

    public static char[] outpuVoynich(){
        try {

    
            Scanner input = new Scanner(new File("C:\\Users\\josch\\Desktop\\WF1 Stuff\\PROG2_WS21_22_HA\\src\\voynich.txt"));
        
            String heyheyhelloString = "";

            while(input.hasNext()){
                String inputText = input.nextLine();
                System.out.println(inputText);
                heyheyhelloString += inputText;
            }

            char[] characters = heyheyhelloString.toCharArray();
            

            return characters;



    } catch (FileNotFoundException e){
        e.printStackTrace();
    }

        return null;
    }

    public static void ausgabeHaeufigkeiten(char[] zeichen){
        int[] anzahlZeichen = new int[65536];
        int alleZeichen = 0;

        System.out.println();

        for(char character : zeichen){
            anzahlZeichen[character] += 1;
            alleZeichen += 1;
        }

        for(char c = 'a'; c <= 'z'; c++){
            System.out.print(c + ": ");
            System.out.format("%3d%n", anzahlZeichen[c]);
        
        }

        System.out.println();

        double[] relativeHaeufigkeit = berechneRelativeHaeufigkeit(anzahlZeichen, alleZeichen);

        for(char c = 'a'; c <= 'z'; c++){
            System.out.print(c + ": ");
            System.out.format("%4f%n", relativeHaeufigkeit[c]);
        
        }

        char mostOften = (char) relativeHaeufigkeit[1];
        System.out.println(mostOften + ": " + relativeHaeufigkeit[0]);
        


    }

    public static double[] berechneRelativeHaeufigkeit(int[] absoluteHaeuf, int number){
        double[] relHaeuf = new double[65536];
        
        for(char c = 'a'; c <= 'z'; c++){
            Double banana = (double)absoluteHaeuf[c] / (double)number;
            relHaeuf[c] = banana * 100;
        }

        for(int i = 33; i < absoluteHaeuf.length; i++){

            if(relHaeuf[0] < absoluteHaeuf[i]){
                relHaeuf[0] = absoluteHaeuf[i];
                relHaeuf[1] = i;
            }
        }


        return relHaeuf;
    }








}

