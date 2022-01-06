import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class VoynichDateiausgabe2 {

    public static void main(String[] args) {

        ausgabeHaeufigkeiten(outpuVoynich());

    }

    /**
     * Function to output the text to the console.
     * It also saves the text in a string which is then converted into a char array
     * for
     * further processing
     * 
     * @return char[]
     */
    // ANCHOR Voynich
    public static char[] outpuVoynich() {
        try {

            Scanner input = new Scanner(
                    new File("C:\\Users\\josch\\Desktop\\WF1 Stuff\\PROG2_WS21_22_HA\\src\\voynich.txt"));

            String heyheyhelloString = "";

            while (input.hasNext()) {
                String inputText = input.nextLine();
                System.out.println(inputText);
                heyheyhelloString += inputText;
            }

            char[] characters = heyheyhelloString.toCharArray();

            return characters;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method outputs the amount of times a character appears in the text, once
     * as a number
     * and then as a percentage. It also outputs the most appearing character
     * 
     * @param zeichen char[] created in outputVoynich
     */
    // ANCHOR outputProbability
    public static void ausgabeHaeufigkeiten(char[] zeichen) {
        int[] anzahlZeichen = new int[255];
        int alleZeichen = 0;

        System.out.println();

        for (char character : zeichen) {
            anzahlZeichen[character] += 1;
            alleZeichen += 1;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + ": ");
            System.out.format("%3d%n", anzahlZeichen[c]);

        }

        System.out.println();

        double[] relativeHaeufigkeit = berechneRelativeHaeufigkeit(anzahlZeichen, alleZeichen);

        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + ": ");
            System.out.format("%.2f%% %n", relativeHaeufigkeit[c]);

        }

        System.out.println("\n" + "The character that appeared the most is: \n");
        System.out.println((char) relativeHaeufigkeit[1] + ": " + relativeHaeufigkeit[0]);

    }

    /**
     * Calculates the relative probability of the appearing characters and finds the
     * character
     * with the most appearances
     * 
     * @param absoluteHaeuf int[] contains absolute probability numnbers
     * @param number        int total number of characters in the text
     * @return double[]
     */
    //ANCHOR calculate probability
    public static double[] berechneRelativeHaeufigkeit(int[] absoluteHaeuf, int number) {
        double[] relHaeuf = new double[255];

        for (char c = 'a'; c <= 'z'; c++) {
            Double banana = (double) absoluteHaeuf[c] / (double) number;
            relHaeuf[c] = banana * 100;
        }

        for (int i = 33; i < absoluteHaeuf.length; i++) {
            if (relHaeuf[0] < absoluteHaeuf[i]) {
                relHaeuf[0] = absoluteHaeuf[i];
                relHaeuf[1] = i;
            }
        }

        return relHaeuf;
    }

}
