
public class MyDoubleLinkedListTest {
  
  public static void assertTrue(boolean b) {
    if (!b) throw new AssertionError();
  }
  
  public static void main(String[] args) {
    MyDoubleLinkedListEmpty<String> l = new MyDoubleLinkedListEmpty<String>();
    assertTrue(l.size() == 0);
    assertTrue(l.isEmpty());
    String s = "Test";
    
    l.add("Hallo");
    assertTrue(l.size() == 1);
    l.add("wie");
    l.add("gehts");
    assertTrue(l.get(1).equals("wie"));
    
    assertTrue( l.remove(0).equals("Hallo"));
    l.add(1, "lala");
    assertTrue (l.remove(1).equals("lala"));
    assertTrue(!l.isEmpty());

    l.add(s);
    assertTrue(l.contains(s));
    assertTrue(l.size() == 3);
    assertTrue(l.remove(s) == true);
    
  }
}
