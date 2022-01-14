import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Benchmark ergebnisse gibt es in LineCounterRunnable!

public class LineCounterSequentiell {


    Scanner input = new Scanner(System.in); // Scanner used to get path from user

    HashMap<String, Integer> m = new HashMap<String, Integer>(); //Hashmap used to save the values

    /**
     * Reads the path to the file from the console and then returns it 
     * @return  String
     */
    public String readPath() {
        String path;
        System.out.println("Please input the path of the folder you want the program to process: ");
        path = input.nextLine(); 
        return path;
    }

    /**
     * Puts all the files which are in the directory the user pointed it too into a Array
     * @param path  String, path to the directory
     * @return  File[]
     */
    public File[] getarrayFiles(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    /**
     * Gets the filename and then uses it and a array of line numbers to put values into the hashmap
     * and then print them out
     * @param listOfFiles   File[] from getArrayFiles
     * @param numberOfLinesFiles    int[] from countLines
     */
    public void doCounting(File[] listOfFiles, int[] numberOfLinesFiles) {
        String name = "";
        String[] names = new String[listOfFiles.length]; //String array to save the names of the files
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) { //Checks if the file is a .txt file
                name = file.getName();
            }
            //Alter ansatz mit LineNumberReader
            //Zeit mit LNR = 4873ms
            //Zeit mit funktion countLinesNew = 1936ms
            /* int numberLines = 0;
            try{
                LineNumberReader LNR = new LineNumberReader(new FileReader(file));
                while(LNR.readLine() != null){
                    numberLines = LNR.getLineNumber();
                }
                LNR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            m.put(name, numberLines);  */
            m.put(name, numberOfLinesFiles[i]);
            names[i] = name;
        }

        System.out.println();

        int totalLines = 0;
        int totalFiles = 0;
        for(String n : names){
            System.out.println("The File: " + n + " contains " + (m.get(n) + 1) + " lines");
            totalFiles++;
            totalLines += m.get(n);
        }

        System.out.println("The total number of files processed was: " + totalFiles + 
        " and they contained a total of " + totalLines + " lines of text");
        

    }

    /**
     * Faster version to count the lines
     * This counts the amount of times the \n new line character appears in the file, also counts
     * empty lines between text
     * Source: https://stackoverflow.com/a/453067
     * @param LOF Array of Files in directory
     * @return int[]
     * @throws IOException
     */
    public int[] countLinesNew(File[] LOF) throws IOException {
        int[] counts = new int[LOF.length]; //Array to save the values
        for(int y = 0; y < LOF.length; y++){
        InputStream is = new BufferedInputStream(new FileInputStream(LOF[y]));
        try {
            byte[] c = new byte[1024];
    
            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return null;
            }
    
            // make it easy for the optimizer to tune this loop
            int count = 0;
            while (readChars == 1024) {
                for (int i=0; i<1024;) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
    
            // count remaining characters
            while (readChars != -1) {
                for (int i=0; i<readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
    
            counts[y] = count == 0 ? 1 : count;
            count = 0;
        } finally {
            is.close();
        }
    }
    return counts;
    }
    public static void main(String[] args) {
        LineCounterSequentiell LNC = new LineCounterSequentiell();
        File[] files = LNC.getarrayFiles(LNC.readPath());
        long startZeit = System.currentTimeMillis();
        try {
        LNC.doCounting(files, LNC.countLinesNew(files));;
        } catch (IOException e){
            e.printStackTrace();
        }
        long dauerInMS = System.currentTimeMillis() - startZeit;
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(dauerInMS) + "s");
        System.out.println(dauerInMS + "ms");
    }
}
