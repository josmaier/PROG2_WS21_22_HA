import java.util.Arrays;
import java.util.Random;
public class ZusatzaufgabeFueNick {
   public static void main(String[] args) {
      Random rd = new Random(); // creating Random object
      int[] arr = new int[10000];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rd.nextInt(); // storing random integers in an array
      }
      int ungerade = 0;
      int gerade = 0;
      int highestNumber = 0;
      int lowestNumber = 0;
      int thirdHighestNumber = 0;
      int fourthLowestNumber = 0;

      for (int num : arr){
          if(num%2 == 0){
              gerade++;
          } else {
              ungerade++;
          }
          if(num > highestNumber){
              highestNumber = num;
          } else if (num < lowestNumber){
              lowestNumber = num;
          }
      }

    
      Arrays.sort(arr);
      fourthLowestNumber = arr[4];
      thirdHighestNumber = arr[arr.length-1-2];
      System.out.println(thirdHighestNumber + " " + fourthLowestNumber + " " + highestNumber + " " +
      lowestNumber + " " + gerade + " " + ungerade);

      
    
    }
}
