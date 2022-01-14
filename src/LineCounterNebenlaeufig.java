import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

//Benchmark ergebnisse gibt es in LineCounterRunnable!

public class LineCounterNebenlaeufig {

    /*
     * Largely the same as LineCounterSequentiell, just without the countLines
     * function as it is
     * integrated into doCounting
     */
    Scanner input = new Scanner(System.in);
    File[] listOfFiles;
    int numThreads;

    HashMap<String, Integer> m = new HashMap<String, Integer>();

    /**
     * Reads the path to the file from the console and then returns it
     * 
     * @return String
     */
    public String readPath() {
        String path;
        System.out.println("Please input the path of the folder you want the program to process: ");
        path = input.nextLine();
        return path;
    }

    /**
     * Puts all the files which are in the directory the user pointed it too into a
     * Array
     * 
     * @param path String, path to the directory
     * @return File[]
     */
    public File[] getarrayFiles(String path) {
        File folder = new File(path);
        listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    /**
     * Takes in the file presented by the constructor, checks if is indeed a .txt file and then 
     * counts the lines, gets the name of the file and finally outputs it to the console
     * For a more detailed comment on the line counting function refrence countLinesNew 
     * in LineCounterSequentiell
     * 
     * @param file  File to be handled by the function
     * @throws IOException
     */
    public synchronized void doCounting(File file) throws IOException {
        String name = "";
        if (file.isFile() && file.getName().endsWith(".txt")) {
            name = file.getName();
            /*
             * try {
             * Scanner counter = new Scanner(file);
             * while (counter.hasNext()) {
             * number++;
             * }
             * counter.close();
             * } catch (FileNotFoundException e) {
             * e.printStackTrace();
             * }
             */
            int counts = 0;
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] c = new byte[1024];

                int readChars = is.read(c);
                if (readChars == -1) {
                    // bail out if nothing to read
                    counts = 1;
                }

                // make it easy for the optimizer to tune this loop
                int count = 0;
                while (readChars == 1024) {
                    for (int i = 0; i < 1024;) {
                        if (c[i++] == '\n') {
                            ++count;
                        }
                    }
                    readChars = is.read(c);
                }

                // count remaining characters
                while (readChars != -1) {
                    for (int i = 0; i < readChars; ++i) {
                        if (c[i] == '\n') {
                            ++count;
                        }
                    }
                    readChars = is.read(c);
                }

                count = count == 0 ? 1 : count;

            } finally {
                is.close();
            }
            m.put(name, counts);

            System.out.println("The File: " + name + " contains " + (m.get(name) + 1) + " lines");
            counts = 0;
        }
    }
}
