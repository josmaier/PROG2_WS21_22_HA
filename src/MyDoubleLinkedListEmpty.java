
public class MyDoubleLinkedListEmpty<T> {

  /**
   * Private Klasse für Knoten der doppelt verketteten Liste
   */
  private static class Node<T> {
    T element;      // Referenz auf Datenelement
    Node<T> previous;
    Node<T> next;
    Boolean hasNext;
    // TODO: Ergänzen!

    public Node(T el) {
      element = el;
    }

    public Node<T> getPrevious() {
      return previous;
    }

    public void setPrevious(Node<T> previous) {
      this.previous = previous;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public Boolean getHasNext() {
      if(this.next != null){
        return true;
      }
      return false;
    }
  }
  
  /**
   * Anzahl der Elemente in Liste
   */
  private int size = 0;
  
  /**
   * Referenz auf erstes Element (oder null) 
   */
  private Node<T> start = null;
  
  /**
   * Liefert Node-Objekt an Position pos
   */
  private Node<T> getNodeAt(int pos) {
    if (pos >= size) throw new IllegalArgumentException();

    Node<T> n = start;

    for (;pos>0; pos--) {
      n = n.next;
    }

    return n;
  }
  
  /**
   * Liefert Node-Objekt mit Element el.
   * Falls Element el nicht in Liste: Rueckgabewert null
   */
  private Node<T> getNodeWithElement(T el) {
    Node<T> n = start;

    do {
      if (n.element == el) return n;
      n = n.next;
    } while (n != null);

    return null;
  }

/*
    What this does
    make new node<t>
    take last element in list (element with next = null)
    make next = new node that was created
    make nodes previous element
    node next = null --> intialize next as null by default
     */
  /**
   * Fuege Element an Ende der Liste an
   */
  public void add(T element) {
    // TODO
    Node<T> node = new Node<>(element);

    if(size == 0){
      start = node;
      node.setPrevious(null);
      node.setNext(null);
    } else {
      Node<T> prev = start;
      while(prev.getHasNext()){
        prev = prev.next;
      }
      prev.setNext(node);
      node.setPrevious(prev);
    }
  }

  /**
   * Fuege Element an Position pos (als 1. Element = Position 0) in Liste ein
   */
  public void add(int pos, T element) {
    // TODO
    /*
    Issue
    big issue
    als erstes neue node erstellen
    dann node finden die an dem place ist
    dann deren prev als neues prev von neuer node setzen
    Next von neuer node als node an der pos setzen
    prev von der node an pos changen auf neue node
    easy peasy sobald ich die get node at verstehe, dann sollte das gehen vielleicht unsure
     */
    Node<T> node = new Node<>(element);

   if(size == 0){

   }

  }

  /**
   * Loesche Liste
   */
  public void clear() {
    // TODO
    /*
    remove next value from node start
     */
  }

  /**
   * Gibt true zurueck, wenn Liste das Element enthält
   */
  public boolean contains(T element) {
    return false; // TODO
    /*
    liste durchgehen bis node.data = element
     */
  }

  /**
   * Gibt Element an Position pos zurück. Die Liste bleibt unveraendert.
   */
  public T get(int pos) {
    return null; // TODO
    /*
    get node at pos aber returned node.data
     */
  }

  /**
   * Ist die Liste leer?
   */
  public boolean isEmpty() {
    return false; // TODO
    /*
    schauen ob node start ein next hat
     */
  }
  
  /**
   * Entfernt Knoten n aus Liste
   */
  private T removeNode(Node<T> n) {
    return null; // TODO
    /*
    same as  remove, muss nur duch die liste bis node.next = node n und dann wie in remove verfahren
     */
  }

  /**
   * Entfernt Element element aus Liste. Falls Element in Liste gewesen: Rückgabewert true
   */  
  public boolean remove(T element) {
    return false;   // TODO
    /*
    First find element with node.getnodeatelement thingy, then get prev and next, then change
    prev and next for those to be linked with each other
     */
  }

  /**
   * Entfernt Element an Position pos aus Liste. Gibt Referenz auf entferntes Element zurück
   */  
  public T remove(int pos) {
    return null;   // TODO
    /*
    tbh kein plan wirklich, wrsch wie add at pos
     */
  }

  /**
   * Anzahl der Elemente in Liste
   */
  public int size() {
    return 0;   // TODO
    /*
    In the end just want to count up till I hit a node that has node.next = null
     */
  }

}
