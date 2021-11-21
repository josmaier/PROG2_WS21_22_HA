import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack<E> {

    public  E[] Stack;
    private int fix;

    public MyStack(int length) {
        this.Stack = (E[]) new Object[length];
        this.fix = 0;
    }

    public MyStack() {
        this.Stack = (E[]) new Object[100];
        this.fix = 0;
    }

    public boolean push(E element) {
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

    public E pop() {
        E mem;
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

    public E peek() {
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                return this.Stack[i];
            }
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        for (E e : this.Stack) {
            if (e != null) {
                size++;
            }
        }
        return size;
    }

    public boolean isEmpty() {
        boolean emptyness = true;
        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            if (this.Stack[i] != null) {
                emptyness = false;
            }
        }
        return emptyness;
    }

    public boolean isFull() {
        boolean fullness = false;
        if (this.Stack[this.Stack.length - 1] != null) {
            fullness = true;
        }
        return fullness;
    }

    public String toString() {
        String mem = "The size of the stack is: " + this.Stack.length + " and it currently contains "
                + this.getSize() + " elements." + Arrays.toString(this.Stack);
        return mem;
    }
}