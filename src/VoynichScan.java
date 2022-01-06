public class VoynichScan {
    public static void main(String[] args) {
             int maxindex = 256;
             int[] count = new int[maxindex];

             String spell = "Abrakadabra";
             for (int i = 0; i < spell.length(); i++) {
                 char zeichen = spell.charAt(i);
                 if (zeichen < maxindex) {
                    count[zeichen]++;
                     }
                 }

            for (char c = 'a'; c < 'c' ; c++) {
                System.out.format("%d", count[c]);
                 }
             }

    }

