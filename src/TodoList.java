import java.util.Arrays;

public class TodoList {
    /**
     * Initializing variables for class
     */
    private static String[]  list;
    private static boolean[] done;
    private static int size;

    /**
     * Constructor fot TodoList
     * @param todos Array with ToDos
     */
    public TodoList(String[] todos) {
        list = todos;
        size = todos.length;
        done = new boolean[size];
    }

    /**
     * Marks an object in the array as done
     * @param i Index of the array
     */
    public void done(int i) {
        done[i] = true;
    }

    /**
     * Outputs the array as a list of strings
     * @return String
     */
    public String toString() {
        return Arrays.toString(list);
    }

    /**
     * THis methord returns a new object of the subclass UndoneIterator
     * @return  UndoneIterator Object
     */
    public UndoneIterator getIterator(){
        return new UndoneIterator();
    }

    /**
     * Internal Class Undone Interator
     */
    public static class UndoneIterator {

        private int index = 0;
        private boolean h = false;


        /**
         * This function outputs the next entry of the list that is marked undone
         */
        /*
        Ich bin mir nicht sicher was in der Aufgabe mit der Exception gemeint ist, da ich sie noch nie ausgelöset habe.
        Die Funktion enthält einen catch für die Exception falls sie aus irgendeinem Grund auftreten sollte
         */
        public String getNext() {
            try {
                for (int i = index; i < list.length; i++) {
                    if (list[i] != null) {
                        if (!done[i]) {
                            index = (i + 1);
                            break;
                        }
                    }
                }
            } catch (Exception NoSuchElementException) {
                System.out.println("This is a exception");
            }
            return list[index - 1];
        }

        /**
         * Checks if there is a next undone entry in the list
         * @return boolean
         */
        public boolean hasNext(){
            if(!h) {
                for (int i = 0; i < list.length; i++) {
                    if (!done[i]) {
                        h = true;
                    }
                }
            }
            if (index >= list.length){
                h = false;
            }
            return (index < list.length && h);
        }

    }
}
