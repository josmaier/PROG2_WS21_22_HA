import java.util.Arrays;

public class StringStack {

    public String[] Stack;
    int fix;

    public StringStack(int length) {
        this.Stack = new String[length];
        this.fix = 0;
    }

    public StringStack() {
        this.Stack = new String[100];
        this.fix = 0;
    }

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

    public String pop() {
        String mem;
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                mem = this.Stack[i];
                this.Stack[i] = null;
                return mem;
            }
        }
        return null;
    }

    public String peek(){
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                return this.Stack[i];
            }
        }
        return null;
    }

    public int getSize(){
        int size = 0;
        for (int i = 0; i < this.Stack.length; i++) {
            if (this.Stack[i] != null) {
                size++;
            }
        }
        return size;
    }

    public boolean isEmpty(){
        boolean emptyness = true;
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                emptyness = false;
            }
        }
        return emptyness;
    }

    public boolean isFull(){
        boolean fullness = false;
            if (this.Stack[this.Stack.length - 1] != null) {
                fullness = true;
            }
        return fullness;
    }

    public String toString(){
        String mem = "The size of the stack is: " + this.Stack.length + " and it currently contains "
                + this.getSize() + " elements." + Arrays.toString(this.Stack);
        return mem;
    }
}
