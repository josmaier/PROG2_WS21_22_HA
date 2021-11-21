public class MyStackTest {
    public static void main(String[] args){

        MyStack<Integer> intStack = new MyStack();
        MyStack<String>  stringStack = new MyStack(14);
        MyStack<Boolean> boolStack   = new MyStack(1);

        intStack.push(13);
        System.out.println(intStack.peek());
        System.out.println();
        stringStack.push("Cheese");
        System.out.println(stringStack.pop());
        System.out.println();
        System.out.println(stringStack.getSize());
        System.out.println(intStack.getSize());
        System.out.println();
        System.out.println(stringStack.isEmpty());
        System.out.println(stringStack.isFull());
        System.out.println();
        System.out.println(boolStack.isEmpty());
        boolStack.push(true);
        System.out.println();
        System.out.println(boolStack.isEmpty());
        if(boolStack.peek()){
            System.out.println("YES IT IS TRUE");
        } else {
            System.out.println("IT IS A LIE");
        }
        System.out.println();
        System.out.println(stringStack.toString());
        stringStack.push("Hey I am not empty anymore");
        System.out.println(stringStack.toString());
        System.out.println();
        System.out.println(boolStack.push(false));
        System.out.println(boolStack.toString());

    }
}
