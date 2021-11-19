public class StringStackTest {

    public static void main(String[] args) {


        StringStack x = new StringStack(3);
        System.out.println(x.isEmpty());
        System.out.println(x.push("Cheese"));
        System.out.println(x.peek());
        System.out.println(x.push("Bread"));
        System.out.println(x.peek());
        System.out.println(x.push("mayo"));
        System.out.println(x.isEmpty());
        System.out.println(x.pop());
        System.out.println(x.peek());
        System.out.println();
        System.out.println(x.getSize());
        System.out.println(x.isFull());
        System.out.println(x.toString());
    }
}
