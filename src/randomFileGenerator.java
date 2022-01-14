import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Benchmark ergebnisse gibt es in LineCounterRunnable!

public class randomFileGenerator {

    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {
            for(int i = 0; i < 10000; i++){
                writer = new BufferedWriter(new FileWriter("Output" + i + ".txt"));
                for(int y = 0; y < (int)(Math.random() * 150000) + 9000; y++){
                    writer.write((char)(Math.random() * 254) + 32 + "\n");
                }
                writer.flush();
                writer.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
