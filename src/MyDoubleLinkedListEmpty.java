public class MyDoubleLinkedListEmpty {

  /**
   * Private Klasse für Knoten der doppelt verketteten Liste
   */
  private static class Node {
    String firstname;// Referenz auf Datenelement
    String surahme;
    Adress1 adressNormal;
    Adress2 adressBox;
    Adress3 freeAdress;
    String companyName;
    String[] phoneNumber = new String[1];

    Node previous;
    Node next;
    Boolean hasNext;

    public Node(String fname, String sName, String cName, Adress1 adress) {
      this.setFirstname(fname);
      this.setSurahme(sName);
      this.setCompanyName(cName);
      this.setAdressNormal(adress);
      this.setPrevious(null);
      this.setNext(null);
    }

    public Node(String fname, String sName, String cName, Adress2 adress) {
      this.setFirstname(fname);
      this.setSurahme(sName);
      this.setCompanyName(cName);
      this.setAdressBox(adress);
      this.setPrevious(null);
      this.setNext(null);
    }

    public Node(String fname, String sName, String cName, Adress3 adress) {
      this.setFirstname(fname);
      this.setSurahme(sName);
      this.setCompanyName(cName);
      this.setFreeAdress(adress);
      this.setPrevious(null);
      this.setNext(null);
    }

    public void resetNode(){
      this.setFirstname(null);
      this.setSurahme(null);
      this.setCompanyName(null);
      this.setAdressBox(null);
      this.setFreeAdress(null);
      this.setAdressNormal(null);
      this.setPrevious(null);
      this.setNext(null);
    }

    public String getFirstname() {
      return firstname;
    }


    public String getSurahme() {
      return surahme;
    }


    public Adress1 getAdressNormal() {
      return adressNormal;
    }

    public Adress2 getAdressBox() {
      return adressBox;
    }

    public Adress3 getFreeAdress() {
      return freeAdress;
    }


    public String getCompanyName() {
      return companyName;
    }


    public void addPhoneNumber(String number){
      if(this.phoneNumber.length == 1){
        this.phoneNumber[0] = number;
      } else {
        String[] ntemp = new String[(this.phoneNumber.length + 1)];
        ntemp = phoneNumber;
        ntemp[ntemp.length] = number;
        this.phoneNumber = ntemp;
      }
    }

    public String getPhoneNumber(){
      if(this.phoneNumber[0] != null) {
        for (String s : this.phoneNumber) {
          return s;
        }
      }
      return null;
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




    private static class Adress1{
      String street;
      String City;
      String zipCode;
      String houseNumber;

      public void Adress1(String str,String cty,String zCode,String hNumber){
        this.street = str;
        this.City = cty;
        this.houseNumber = hNumber;
        this.zipCode = zCode;
      }

   }
   private static class Adress2{
      String boxNumber;
      String zipCode;
      String City;

      public void Adress2(String bNumber, String zCode, String cty){
        this.boxNumber = bNumber;
        this.zipCode = zCode;
        this.City = cty;
      }

   }
   private static class Adress3{
      String adress;

      public void Adress3(String adress){
        this.adress = adress;
      }
   }





    public Node getPrevious() {
      return previous;
    }

    public void setPrevious(Node previous) {
      this.previous = previous;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
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
  private Node start = null;
  
  /**
   * Liefert Node-Objekt an Position pos
   */
  private Node getNodeAt(int pos) {
    if (pos >= size) throw new IllegalArgumentException();

    Node n = start;

    for (;pos>0; pos--) {
      n = n.next;
    }

    return n;
  }
  
  /**
   * Liefert Node-Objekt mit Element el.
   * Falls Element el nicht in Liste: Rueckgabewert null
   */
  private Node getNodeWithElement(T el) {
    Node n = start;

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
