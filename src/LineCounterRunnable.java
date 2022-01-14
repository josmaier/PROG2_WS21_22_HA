import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LineCounterRunnable implements Runnable {

    LineCounterNebenlaeufig LCN = new LineCounterNebenlaeufig();

    private File file;
    public int numberOfThreads;

    /**
     * Constructor 
     * @param f File to be processed by this object
     */ 
    public LineCounterRunnable(File f){
        this.file = f;
    }


    /**
     * Run method
     */
    public void run(){
        numberOfThreads++;
        try {
            LCN.doCounting(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        numberOfThreads--;
    }


    /**
     * Function to return the File Array, uses LineCounterNebenlaeufig to call the functions
     * (could have also used LineCounterSequentiell)
     * @return  File[]
     */
    public File[] getArray(){
        return LCN.getarrayFiles(LCN.readPath());
    }


    public static void main(String[] args) {
        
        // New LineCounterRunnable object to call the get array Function
        LineCounterRunnable LCR = new LineCounterRunnable(null);

        File[] filesInFolder = LCR.getArray();

        int number = 0;

        long startZeit = System.currentTimeMillis();
        for(int i = 0; i < filesInFolder.length; i++){
            if(filesInFolder[i] != null && LCR.numberOfThreads < 16){
                LineCounterRunnable myThing = new LineCounterRunnable(filesInFolder[i]);
                Thread myThread = new Thread(myThing);
                number++;
                myThread.start();
            }else if(filesInFolder[i] != null && LCR.numberOfThreads >= 16){
                i--;
            }
        }
        long dauerInMS = System.currentTimeMillis() - startZeit;
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(dauerInMS) + "s");
        System.out.println(dauerInMS + "ms");
        System.out.println(number);
        System.out.println(dauerInMS + "ms");
        System.out.println(dauerInMS + "ms");
    }

    /*
    *   Getested wurde mit einem Ordner welcher 10016 .txt dateien enthält, welche alle mindestens
    *   9000 Zeilen haben, insgesamt enthält der ordner 94827627 Zeilen an text
    *   Sequentiell brauchte das program zum einlesen und ausgeben der daten 4873 Millisekunden 
    *   Mit der Nutzung des LineNumberReaders und 1936 Millisekunden mit der in der Klasse erwähnten
    *   Funktion. Obwohl eine limitierung für die Menge an Threads existiert, nutzt das Programm 
    *   alle verfügbaren (in meinem fall 16)
    *   Das Programm brauchte 1293 Millisekunden um alle Dateien zu verarbeiten
    */
    

}
