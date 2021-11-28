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
      this.setPrevious(null);
      this.setNext(null);
    }

    public void resetNode(){
      this.element = null;
      this.next = null;
      this.previous = null;
    }

    public void removeNode(){
        if (this.getPrevious() != null) {
          if(this.getHasNext()) {
            this.previous.setNext(this.getNext());
          }
        }
        if (this.getHasNext()) {
          if(this.getPrevious() != null){
            this.next.setPrevious(this.getPrevious());
          }
        }
    }

    public T getElement() {
      return element;
    }

    public void setElement(T element) {
      this.element = element;
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
      size++;
    } else {
      Node<T> prev = start;
      while(prev.getHasNext()){
        prev = prev.next;
      }
      prev.setNext(node);
      node.setPrevious(prev);
      size++;
    }
  }

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
  /**
   * Fuege Element an Position pos (als 1. Element = Position 0) in Liste ein
   */
  public void add(int pos, T element) {
    // TODO

    Node<T> node = new Node<>(element);

   if(size == 0){
      start = node;
   } else if (pos == size){
     this.add(element);
     size++;
   }else {
     Node<T> prev = this.getNodeAt(pos);
     if(prev.getPrevious() != null) {
       node.setPrevious(prev.getPrevious());
       prev.setPrevious(node);
       node.previous.setNext(node);
     }
     node.setNext(prev);



     size++;
   }

  }

/*
    remove next value from node start
    prev next
    start prev null next first -> next? yes then node = next
            first prev start next second -> now take this prev == start and reset; next? yes node = next
            second
                    third next? no -> reset this one and finish
     */
  /**
   * Loesche Liste
   */
  public void clear() {
    // TODO

    Node<T> node = start;
    while(node.getHasNext()){
      node = node.next;
      node.previous.resetNode();
    }
    if(!node.getHasNext()){
      node.resetNode();
    }

  }

/*
    liste durchgehen bis node.data = element
     */
  /**
   * Gibt true zurueck, wenn Liste das Element enthält
   */
  public boolean contains(T element) {
    // TODO

    Node<T> node = start;
    node.setElement(element);

    while (node.getHasNext()){
      if(node.getElement() == node.next.getElement()){
        return true;
      }
      node = node.next;
      node.setElement(element);
    }

    return false;
  }

  /*
    get node at pos aber returned node.data
     */
  /**
   * Gibt Element an Position pos zurück. Die Liste bleibt unveraendert.
   */
  public T get(int pos) {
    // TODO

    if(size > 0 && pos < size) {
      return this.getNodeAt(pos).getElement();
    } else {
      return null;
    }
  }

  /*
    schauen ob node start ein next hat
     */
  /**
   * Ist die Liste leer?
   */
  public boolean isEmpty() {
    // TODO
    if(start == null){
      return true;
    }
    return false;
  }

  /*
    same as  remove, muss nur duch die liste bis node.next = node n und dann wie in remove verfahren
     */
  /**
   * Entfernt Knoten n aus Liste
   */
  private void removeNode(Node<T> n) {
    // TODO
    if(n.getElement() != null) {
      n.removeNode();
      size--;
    }
  }

  /*
    First find element with node.getnodeatelement thingy, then get prev and next, then change
    prev and next for those to be linked with each other
     */
  /**
   * Entfernt Element element aus Liste. Falls Element in Liste gewesen: Rückgabewert true
   */  
  public boolean remove(T element) {
    // TODO
    if(this.contains(element)){
      this.getNodeWithElement(element).removeNode();
      size--;
      return true;
    } else  {
      return false;
    }
  }

  /*
    tbh kein plan wirklich, wrsch wie add at pos
     */
  /**
   * Entfernt Element an Position pos aus Liste. Gibt Referenz auf entferntes Element zurück
   */  
  public T remove(int pos) {
    // TODO

    if(pos < size) {
      Node<T> node = this.getNodeAt(pos);
      this.getNodeAt(pos).removeNode();
      size--;
      return node.getElement();
    }
    return null;
  }

  /*
    In the end just want to count up till I hit a node that has node.next = null
     */
  /**
   * Anzahl der Elemente in Liste
   */
  public int size() {
    // TODO
    return this.size;
  }

}
