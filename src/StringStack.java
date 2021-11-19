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
        }
        return false;
    }

    public String pop() {

        for (int i = (this.Stack.length - 1); i >= 0; i--) {
            String mem;
            if (this.Stack[i] != null) {
                mem = this.Stack[i];
                this.Stack[i] = null;
                return mem;
            }
        }
        return null;
    }


}