import java.util.Arrays;

public class StringStack {

    /**
     * Initializing variables for class, this includes a array and a fix variable for putting in the first
     * object of the stack
     */
    public String[] Stack;
    private int fix;

    /**
     * Constructor for the StringStack which sets the length of the array to the user specified amount.
     * @param length    int
     */
    public StringStack(int length) {
        this.Stack = new String[length];
        this.fix = 0;
    }

    /**
     * Constructor for the StringStack which sets the length of the array to 100
     */
    public StringStack() {
        this.Stack = new String[100];
        this.fix = 0;
    }

    /**
     * Methord for pushing a new element into the Stack, this methord first searches the stack for the next empty
     * place, then puts the new element in. Of there is no more room left it returns false
     * @param element   String
     * @return          boolean
     */
    public boolean push(String element) {
        if (fix != 0) {
            for (int i = 0; i < this.Stack.length; i++) {
                if (i <= (this.Stack.length - 1))
                    try {
                        if (this.Stack[i + 1] == null) {
                            this.Stack[i + 1] = element;
                            return true;
                        }
                    } catch (Exception e) {
                        return false;
                    }
            }
        } else {
            this.Stack[0] = element;
            this.fix++;
            return true;
        }
        return false;
    }

    /**
     * This method first returns the object in the top spot (counted from the top of the stack, so from max index to 0.
     * If the object it deletes it resets the help variable so that the next push will put it into the first spot in
     * the array with the index 0 again.
     * @return String
     */
    public String pop() {
        String mem;
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                mem = this.Stack[i];
                this.Stack[i] = null;
                if(i == 0){
                    this.fix = 0;
                }
                return mem;
            }
        }
        return null;
    }

    /**
     * This method returns the first object found in the array counting from the top
     * @return  String
     */
    public String peek(){
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                return this.Stack[i];
            }
        }
        return null;
    }

    /**
     * This method returns the size of the Stack
     * @return  int
     */
    public int getSize(){
        int size = 0;
        for (String s : this.Stack) {
            if (s != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * This method checks if there is any entry in the array, if this is the case it returns false, if there is
     * nothing in the array it returns true
     * @return  boolean
     */
    public boolean isEmpty(){
        boolean emptyness = true;
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                emptyness = false;
            }
        }
        return emptyness;
    }

    /**
     * This method checks if there are any empty spaces in the Stack, if that is the case it returns true, if all
     * spaces in the array are filled with elements it returns true
     * @return  boolean
     */
    public boolean isFull(){
        return this.Stack[this.Stack.length - 1] != null;
    }

    /**
     * This Method returns a String with the size of the Stack and all of its contents
     * @return  String
     */
    public String toString(){
        String mem = "The size of the stack is: " + this.Stack.length + " and it currently contains "
                + this.getSize() + " element(s)." + Arrays.toString(this.Stack);
        return mem;
    }
}
