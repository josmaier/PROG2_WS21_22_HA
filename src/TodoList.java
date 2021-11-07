import java.util.Arrays;

public class TodoList {
    /**
     * Initializing variables for class
     */
    private static String[]  list;
    private static boolean[] done;
    private static int       size;

    /**
     * Constructor fot TodoList
     * @param todos Array with ToDos
     */
    public TodoList(String[] todos) {
        this.list = todos;
        this.size = todos.length;
        this.done = new boolean[size];
    }

    /**
     * Marks an object in the array as done
     * @param i Index of the array
     */
    public void done(int i) {
        this.done[i] = true;
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
        TodoList.UndoneIterator why = new TodoList.UndoneIterator();
        return why;
    }

    /**
     * Internal Class Undone Interator
     */
    public static class UndoneIterator {

        private int index = 0;



        /**
         * This function outputs the next entry of the list that is marked undone
         */
        /*
        Ich bin mir nicht sicher was in der Aufgabe mit der Exception gemeint ist, da ich sie noch nie ausgelöset habe.
        Die Funktion enthält einen catch für die Exception falls sie aus irgendeinem Grund auftreten sollte
         */
        public void getNext() {
            try {
                for (int i = 0; i < list.length; i++) {
                    if (list[i] != null) {
                        if (!done[i]) {
                            System.out.println(list[i]);
                            index = i;
                        }
                    }
                }
            } catch (Exception NoSuchElementException) {
                System.out.println("This is a exception, i do not think that it will ever be thrown");
            }
        }

        /**
         * Checks if there is a next entry in the list
         * @return boolean
         */
        public boolean hasNext(){
            return (index < list.length - 1);
        }

    }
}
