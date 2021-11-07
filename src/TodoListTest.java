public class TodoListTest {
    public static void main(String[] args){
        String[] entries = {
                "Clean dishes",
                "Exercise Java",
                "Workout",
                "Watch TV"
        };

        TodoList todo = new TodoList(entries);
        todo.done(1);

        System.out.println("*Complete List*");
        System.out.println(todo);


        System.out.println("*Open Items*");

        TodoList.UndoneIterator i = new TodoList.UndoneIterator();

        while (i.hasNext()) {
            i.getNext();
        }
    }
}
