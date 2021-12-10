import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Adresskartei {

    Scanner input = new Scanner(System.in);


    /**
     * Private Klasse für Knoten der doppelt verketteten Liste
     */
    private static class Node {
        String   firstname;// Referenz auf Datenelement
        String   surahme;
        Adress1  adressNormal;
        Adress2  adressBox;
        Adress3  freeAdress;
        String   companyName;
        String[] phoneNumber = new String[1];
        int adressType;

        Node    previous;
        Node    next;
        Boolean hasNext;

        public Node(String fname, String sName, String cName, Adress1 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.adressNormal = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 1;
        }

        public Node(String fname, String sName, String cName, Adress2 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.adressBox = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 2;
        }

        public Node(String fname, String sName, String cName, Adress3 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.freeAdress = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 3;
        }

        public void resetNode() {
            this.firstname = null;
            this.surahme = null;
            this.companyName = null;
            this.freeAdress = null;
            this.adressBox = null;
            this.adressNormal = null;
            this.setPrevious(null);
            this.setNext(null);
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setSurahme(String surahme) {
            this.surahme = surahme;
        }

        public void setAdressNormal(Adress1 adressNormal) {
            this.adressNormal = adressNormal;
        }

        public void setAdressBox(Adress2 adressBox) {
            this.adressBox = adressBox;
        }

        public void setFreeAdress(Adress3 freeAdress) {
            this.freeAdress = freeAdress;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
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



        public String getPhoneNumber() {
                return Arrays.toString(this.phoneNumber);
        }

        public void removeNode() {
            if (this.getPrevious() != null) {
                if (this.getHasNext()) {
                    this.previous.setNext(this.getNext());
                }
            }
            if (this.getHasNext()) {
                if (this.getPrevious() != null) {
                    this.next.setPrevious(this.getPrevious());
                }
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
            return this.next != null;
        }


        private static class Adress1 {
            String street;
            String city;
            String zipCode;
            String houseNumber;
            String[] outputHelp = new String[4];

            public Adress1(String str, String cty, String zCode, String hNumber) {
                this.street = str;
                this.city = cty;
                this.houseNumber = hNumber;
                this.zipCode = zCode;
                this.outputHelp[0] = "Zip Code: " + zCode;
                this.outputHelp[1] = "City: " + cty;
                this.outputHelp[2] = "Street: " + str;
                this.outputHelp[3] = "House number: " + hNumber;
            }

        }

        private static class Adress2 {
            String boxNumber;
            String zipCode;
            String city;
            String[] outputHelp = new String[3];

            public Adress2(String bNumber, String zCode, String cty) {
                this.boxNumber = bNumber;
                this.zipCode = zCode;
                this.city = cty;
                this.outputHelp[0] = "Zip Code: " + zCode;
                this.outputHelp[1] = "City: " + cty;
                this.outputHelp[2] = "P.O. Number: " + bNumber;
            }


        }

        private static class Adress3 {
            String adress;

            public Adress3(String adress) {
                this.adress = "Adress: " + adress;
            }

            public String getAdress(){
                return this.adress;
            }
        }


    }

    //---------------------------------------------------------------------------------------------------------------

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

        for (; pos > 0; pos--) {
            n = n.next;
        }

        return n;
    }


    /**
     * Fuege Element an Ende der Liste an
     */
    public void add() {

        int i = 0;

        System.out.println("Please input which adress type you would like to use, 0 for a normal adress, 1 for a " +
                "P.O. Box and 2 to use a international Adress");

        try {
           i = input.nextInt();

        switch (i) {
            case 0:
                addAdress1();
                break;
            case 1:
                addAdress2();
                break;
            case 2:
                addAdress3();
                break;
        }
        } catch (InputMismatchException e) {
            System.out.println("ERROR YOU NEED TO INPUT A INTEGER");
        }

    }


    public void addAdress1() {
        String firstname;
        String surahme;
        String street;
        String City;
        String zipCode;
        String houseNumber;
        String companyName;

        try {
            System.out.println("Please input the surname of the person you wish to enter: ");
            surahme = input.nextLine();
            surahme = input.nextLine();
            System.out.println("Please input the firstname of the person you wish to enter: ");
            firstname = input.nextLine();
            System.out.println("Please input the zip code of the city they live in: ");
            zipCode = input.nextLine();
            System.out.println("Please input the name of the city they live in: ");
            City = input.nextLine();
            System.out.println("Please input the streetname: ");
            street = input.nextLine();
            System.out.println("Please input their housenumber: ");
            houseNumber = input.nextLine();
            System.out.println("Please input their company name, if not applicable hit enter: ");
            companyName = input.nextLine();
            Node.Adress1 adress = new Node.Adress1(street, City, zipCode, houseNumber);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 1;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        for (int i = 0; i < node.phoneNumber.length; i++) {
                            temp[i] = node.phoneNumber[i];
                        }
                        if (x == node.phoneNumber.length) {
                            temp[x] = hope;
                            node.phoneNumber = temp;
                            x++;
                        }
                    } else {
                        node.phoneNumber[0] = hope;
                    }
                    System.out.println("Please input the next phone number or type leave if you want to stop inputting"
                            + " new numbers");
                    input.reset();
                }
            }
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
                size++;
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
                size++;
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }

    }

    public void addAdress2() {
        String firstname;
        String surahme;
        String boxNumber;
        String zipCode;
        String City;
        String companyName;
        try {
            System.out.println("Please input the surname of the person you wish to enter: ");
            surahme = input.nextLine();
            surahme = input.nextLine();
            System.out.println("Please input the firstname of the person you wish to enter: ");
            firstname = input.nextLine();
            System.out.println("Please input the zip code of the city they live in: ");
            zipCode = input.nextLine();
            System.out.println("Please input the name of the city they live in: ");
            City = input.nextLine();
            System.out.println("Please input the P.O. Box number: ");
            boxNumber = input.nextLine();
            System.out.println("Please input their company name, if not applicable hit enter: ");
            companyName = input.nextLine();
            Node.Adress2 adress = new Node.Adress2(boxNumber, City, zipCode);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 2;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        for (int i = 0; i < node.phoneNumber.length; i++) {
                            temp[i] = node.phoneNumber[i];
                        }
                        if (x == node.phoneNumber.length) {
                            temp[x] = hope;
                            node.phoneNumber = temp;
                            x++;
                        }
                    } else {
                        node.phoneNumber[0] = hope;
                    }
                    System.out.println("Please input the next phone number or type leave if you want to stop inputting"
                            + " new numbers");
                    input.reset();
                }
            }
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
                size++;
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
                size++;
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }
    }

    public void addAdress3() {
        String firstname;
        String surahme;
        String adr;
        String companyName;
        try {

            System.out.println("Please input the surname of the person you wish to enter: ");
            surahme = input.nextLine();
            surahme = input.nextLine();
            System.out.println("Please input the firstname of the person you wish to enter: ");
            firstname = input.nextLine();
            System.out.println("Please input the adress you wish to save in the entry in one line: ");
            adr = input.nextLine();
            System.out.println("Please input their company name, if not applicable hit enter: ");
            companyName = input.nextLine();
            Node.Adress3 adress = new Node.Adress3(adr);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 3;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        for (int i = 0; i < node.phoneNumber.length; i++) {
                            temp[i] = node.phoneNumber[i];
                        }
                        if (x == node.phoneNumber.length) {
                            temp[x] = hope;
                            node.phoneNumber = temp;
                            x++;
                        }
                    } else {
                        node.phoneNumber[0] = hope;
                    }
                    System.out.println("Please input the next phone number or type leave if you want to stop inputting"
                            + " new numbers");
                    input.reset();
                }
            }
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
                size++;
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
                size++;
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }
    }

    /**
     * Loesche Liste
     */
    public void clear() {

        Node node = start;
        while (node.getHasNext()) {
            node = node.next;
            node.previous.resetNode();
        }
        if (!node.getHasNext()) {
            node.resetNode();
        }

    }

    public void outputListShort(){
        Node node = start;
        while (node.getHasNext()){
            System.out.println(node.getFirstname() + " " + node.getSurahme());
            node = node.next;
            System.out.println();
        }
        if(node.getSurahme() != null){
            System.out.println(node.getFirstname() + " " + node.getSurahme());
        }
    }
    
    public void outputListResult(Node[] r){
        for (Node node : r){
            System.out.println(node.getFirstname() + " " + node.getSurahme());
        }

    }

    public void outputListLong(){
        Node node = start;
        while (node.getHasNext()){
            switch (node.adressType){
                case 1:
                    for (String out : node.adressNormal.outputHelp){
                        System.out.print(out + " ");
                    }
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }
                    node = node.next;
                    break;
                case 2:
                    for (String out : node.adressBox.outputHelp){
                        System.out.print(out + " ");
                    }
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }                  node = node.next;
                    break;
                case 3:
                    System.out.println(node.freeAdress.getAdress());
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }                   node = node.next;
                    break;
            }
        }
        if (node.getNext() == null){
            switch (node.adressType){
                case 1:
                    for (String out : node.adressNormal.outputHelp){
                        System.out.print(out + " ");
                    }
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }
                    break;
                case 2:
                    for (String out : node.adressBox.outputHelp){
                        System.out.print(out + " ");
                    }
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }
                    break;
                case 3:
                    System.out.println(node.freeAdress.getAdress());
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber){
                        System.out.print(s + " ");
                    }
                    break;
            }
        }
    }


    public Node[] outputSearchResultArray(String sNamePart) {

        Node[] results = new Node[size];
        Node   node    = start;
        node.setSurahme(sNamePart);
        int i = 0;
        while (node.getHasNext()) {
            if (node.next.getSurahme().contains(node.getSurahme())) {
                results[i] = node;
                i++;
                node = node.next;
                node.setSurahme(sNamePart);
            }
        }
        return results;
    }

    /**
     * Ist die Liste leer?
     */
    public boolean isEmpty() {
        return start == null;
    }

    /**
     * Anzahl der Elemente in Liste
     */
    public int size() {
        return this.size;
    }

}

