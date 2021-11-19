public class StringStackTest {

    public static void main(String[] args) {


        StringStack x = new StringStack(3);
        System.out.println(x.push("Cheese"));
        System.out.println(x.push("Bread"));
        System.out.println(x.push("mayo"));
        System.out.println(x.push("wata"));
        System.out.println(x.pop());
    }
}
