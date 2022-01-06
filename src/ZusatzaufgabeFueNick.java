import java.util.Random;
public class ZusatzaufgabeFueNick {
   public static void main(String[] args) {
      Random rd = new Random(); // creating Random object
      int[] arr = new int[50];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rd.nextInt(); // storing random integers in an array
      }
}
}
