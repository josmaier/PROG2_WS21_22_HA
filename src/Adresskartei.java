import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Adresskartei {

    /**
     * Initializing Scanner needed for class
     */
    Scanner input = new Scanner(System.in);


    /**
     * Protected class managing nodes in the list
     */
    protected static class Node {
        /**
         * Variables needed for Node class
         */
        String   firstname;
        String   surahme;
        Adress1  adressNormal;
        Adress2  adressBox;
        Adress3  freeAdress;
        String   companyName;
        String[] phoneNumber = new String[1];
        int      adressType;

        /**
         * Variables needed to determine node positon in the double linked list
         */
        Node previous;
        Node next;

        /**
         * Constructor one for a new Node, the constructors differ in the adresstype that they take in
         *
         * @param fname  String
         * @param sName  String
         * @param cName  String
         * @param adress Adress1
         */
        public Node(String fname, String sName, String cName, Adress1 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.adressNormal = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 1;
        }

        /**
         * Constructor for adresses of type 2
         *
         * @param fname  String
         * @param sName  String
         * @param cName  String
         * @param adress Adress2
         */
        public Node(String fname, String sName, String cName, Adress2 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.adressBox = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 2;
        }

        /**
         * Constructor for adresses of type 3
         *
         * @param fname  String
         * @param sName  String
         * @param cName  String
         * @param adress Adress3
         */
        public Node(String fname, String sName, String cName, Adress3 adress) {
            this.firstname = fname;
            this.surahme = sName;
            this.companyName = cName;
            this.freeAdress = adress;
            this.setPrevious(null);
            this.setNext(null);
            this.adressType = 3;
        }

        /**
         * Leftover Funtion for resetting a node from the original double linked list class
         */
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

        /**
         * Getters for the first name
         *
         * @return String
         */
        public String getFirstname() {
            return firstname;
        }

        public String getCompanyName() {
            return companyName;
        }

        /**
         * Getter for the surname
         *
         * @return String
         */
        public String getSurahme() {
            return surahme;
        }

        /**
         * Setter for the surname
         *
         * @param surahme String
         */
        public void setSurahme(String surahme) {
            this.surahme = surahme;
        }

        public int getAdressType() {
            return adressType;
        }

        /**
         * Leftover function for removing a node from the list
         */
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

        /**
         * Getter for the previous node
         *
         * @return Node
         */
        public Node getPrevious() {
            return previous;
        }

        /**
         * Setter for previous node
         *
         * @param previous Node
         */
        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        /**
         * Getter for the next node
         *
         * @return Node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Setter for next node
         *
         * @param next Node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Funktion to determine if a node is has a next node or is the end of the list
         *
         * @return boolean
         */
        public Boolean getHasNext() {
            return this.next != null;
        }


        /**
         * Protected class for the first adress type
         */
        protected static class Adress1 {
            /**
             * Variables needed for Adresses of type 1, including street name, city name, zip code and a house number
             */
            String   street;
            String   city;
            String   zipCode;
            String   houseNumber;
            String[] outputHelp = new String[4];

            public String getStreet() {
                return street;
            }

            public String getCity() {
                return city;
            }

            public String getZipCode() {
                return zipCode;
            }

            public String getHouseNumber() {
                return houseNumber;
            }


            /**
             * Constructor for a Adress of type 1
             *
             * @param str     String
             * @param cty     String
             * @param zCode   String
             * @param hNumber String
             */
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

        /**
         * Protected class for the second adress type
         */
        protected static class Adress2 {
            public String getBoxNumber() {
                return boxNumber;
            }

            public String getZipCode() {
                return zipCode;
            }

            public String getCity() {
                return city;
            }

            /**
             * Variables needed for adress type 2, including P.O. Box number, zip code and cirty
             */
            String   boxNumber;
            String   zipCode;
            String   city;
            String[] outputHelp = new String[3];

            /**
             * Constructor for a adress of type 2
             *
             * @param bNumber String
             * @param zCode   String
             * @param cty     String
             */
            public Adress2(String bNumber, String zCode, String cty) {
                this.boxNumber = bNumber;
                this.zipCode = zCode;
                this.city = cty;
                this.outputHelp[0] = "Zip Code: " + zCode;
                this.outputHelp[1] = "City: " + cty;
                this.outputHelp[2] = "P.O. Number: " + bNumber;
            }


        }

        /**
         * Protected class for the third adress type
         */
        protected static class Adress3 {
            /**
             * This adress type uses a free adress, meaning that the user can input any String they want
             */
            String adress;

            /**
             * Construcor for adress type 3
             *
             * @param adress String
             */
            public Adress3(String adress) {
                this.adress = adress;
            }

            /**
             * Getter for the adress of type 3
             *
             * @return String
             */
            public String getAdress() {
                return this.adress;
            }
        }


    }

    //---------------------------------------------------------------------------------------------------------------


    /**
     * Amount of entries in the list
     */
    private int size = 0;

    /**
     * Refrence to the first element in the list
     */
    private Node start = null;

    /**
     * Method for adding a new node into the list, the user chooses the adress type they want to use in the console,
     * depending on adress type the methord calls for one of three adding methords. Has a catch block if the user tries
     * to input anything that isn't a integer
     */
    public void add() {

        int i;

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


    /**
     * Adding function for the first adress type
     */
    public void addAdress1() {
        /*
         * Temporary variables used to pass inputs to the constructor
         */
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
            if(companyName == null){
                companyName = "c";
            }
            Node.Adress1 adress = new Node.Adress1(street, City, zipCode, houseNumber);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 1;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            /*
            This block adds phone numbers to the node specific array, using a temporary array and gives the user
            the option to end typing adresses
             */
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        System.arraycopy(node.phoneNumber, 0, temp, 0, node.phoneNumber.length);
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
            /*
            This block determines if the node added will be the first one in the list, or if it has to be added to the
            end of the list
             */
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
            }
            size++;
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }

    }

    /**
     * Adding function for the second adress type
     */
    public void addAdress2() {
        /*
         * Temporary variables used to pass inputs to the constructor
         */
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
            if(companyName == null){
                companyName = "c";
            }
            Node.Adress2 adress = new Node.Adress2(boxNumber, City, zipCode);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 2;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            /*
            This block adds phone numbers to the node specific array, using a temporary array and gives the user
            the option to end typing adresses
             */
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        System.arraycopy(node.phoneNumber, 0, temp, 0, node.phoneNumber.length);
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
            /*
            This block determines if the node added will be the first one in the list, or if it has to be added to the
            end of the list
             */
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
            }
            size++;
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }
    }

    /**
     * Adding function for the third adress type
     */
    public void addAdress3() {
        /*
         * Temporary variables used to pass inputs to the constructor
         */
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
            if(companyName == null){
                companyName = "c";
            }
            Node.Adress3 adress = new Node.Adress3(adr);
            Node         node   = new Node(firstname, surahme, companyName, adress);
            node.adressType = 3;
            System.out.println("You can now input as many phone numbers as you wish, hitting enter after every input. " +
                    "If there are no more numbers you want to enter just type ´leave´.");
            /*
            This block adds phone numbers to the node specific array, using a temporary array and gives the user
            the option to end typing adresses
             */
            String hope = "i";
            int    x    = 1;
            while (!hope.contains("leave")) {
                hope = input.nextLine();
                if (!hope.contains("leave")) {
                    String[] temp = new String[node.phoneNumber.length + 1];
                    if (node.phoneNumber[0] != null) {
                        System.arraycopy(node.phoneNumber, 0, temp, 0, node.phoneNumber.length);
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
            /*
            This block determines if the node added will be the first one in the list, or if it has to be added to the
            end of the list
             */
            if (size == 0) {
                start = node;
                node.setPrevious(null);
                node.setNext(null);
            } else {
                Node prev = start;
                while (prev.getHasNext()) {
                    prev = prev.next;
                }
                prev.setNext(node);
                node.setPrevious(prev);
            }
            size++;
        } catch (NullPointerException e) {
            System.out.println("ERROR THE ELEMENTS OF THE ENTRY CAN NOT BE NULL");
        }
    }

    /**
     * Leftover method from original double linked list class
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

    /**
     * Function outpurs the list in a short variant, only giving the first and lastname of a entry
     */
    public void outputListShort() {
        Node node = start;
        while (node.getHasNext()) {
            System.out.println(node.getFirstname() + " " + node.getSurahme());
            node = node.next;
            System.out.println();
        }
        if (node.getSurahme() != null) {
            System.out.println(node.getFirstname() + " " + node.getSurahme());
        }
    }

    /**
     * This function outputs a more detailed list of all entries, including adresses and phone numbers
     */
    public void outputListLong() {
        Node node = start;
        while (node.getHasNext()) {
            System.out.println();
            switch (node.adressType) {
                case 1:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    for (String out : node.adressNormal.outputHelp) {
                        System.out.print(out + " ");
                    }
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    node = node.next;
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    for (String out : node.adressBox.outputHelp) {
                        System.out.print(out + " ");
                    }
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    node = node.next;
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    System.out.println("Adress: " + node.freeAdress.getAdress());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    node = node.next;
                    break;
            }
        }
        if (node.getNext() == null) {
            System.out.println();
            switch (node.adressType) {
                case 1:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    for (String out : node.adressNormal.outputHelp) {
                        System.out.print(out + " ");
                    }
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    for (String out : node.adressBox.outputHelp) {
                        System.out.print(out + " ");
                    }
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Name: " + node.getFirstname() + " " + node.getSurahme());
                    if(!Objects.equals(node.companyName, "c")){
                        System.out.println("Company Name:" + node.getCompanyName());
                    }
                    System.out.println("Adress: " + node.freeAdress.getAdress());
                    System.out.println("Saved phone numbers: ");
                    for (String s : node.phoneNumber) {
                        System.out.print(s + "  ");
                    }
                    break;
            }
        }
    }

    /**
     * This method searches the list for entries, that have a surname that contains a search string
     *
     * @param sNamePart String
     * @return Node[]
     */
    public Node[] outputSearchResultArray(String sNamePart) {

        int    i       = 0;
        Node[] results = new Node[size];
        Node   node    = start;
        if (node.getSurahme().contains(sNamePart)) {
            results[0] = node;
            i++;
        }
        node.setSurahme(sNamePart);
        while (node.getHasNext()) {
            if (node.next.getSurahme().contains(node.getSurahme())) {
                node = node.next;
                results[i] = node;
                i++;
                node.setSurahme(sNamePart);
            } else {
                node = node.next;
            }
        }
        return results;
    }

    /**
     * This function outputs the results of the search function
     *
     * @param r Node[]
     */
    public void outputListResult(Node[] r) {
        for (Node node : r) {
            System.out.println(node.getFirstname() + " " + node.getSurahme());
        }

    }

    /**
     * This methord creates a array of all the nodes in the list
     * @return Node[]
     */
    public Node[] listToArray() {
        if (size != 0) {
            Node   node   = start;
            int    i      = 0;
            Node[] output = new Node[size];
            while (node.getHasNext()) {
                output[i] = node;
                node = node.next;
                i++;
            }
            if (node.next == null) {
                output[i] = node;
            }
            return output;
        }
        return null;
    }

    /**
     * This function exports the array of nodes from listToArray (or any given Node[] array) into a textfile in the
     * project directory
     * @param list  Node[]
     */
    public void exportNode(Node[] list) {
        String       firstname;
        String       surahme;
        String       freeAdres;
        String       companyName;
        String       street;
        String       city;
        String       zipCode;
        String       houseNumber;
        String       boNum;
        Node         node;

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
         * Every node gets written into the textfile seperated by "STOP"
         * The writer overwrites the textfile every time the list is exported
         */
        for (Node value : list) {
            node = value;
            if (node != null) {
                firstname = node.getFirstname();
                surahme = node.getSurahme();
                companyName = node.getCompanyName();
                switch (node.getAdressType()) {
                    case 1:
                        zipCode = node.adressNormal.getZipCode();
                        street = node.adressNormal.getStreet();
                        houseNumber = node.adressNormal.getHouseNumber();
                        city = node.adressNormal.getCity();
                        try {
                            writer.write(node.adressType + "\n" + firstname + "\n" + surahme + "\n" + companyName + "\n" + zipCode + "\n" +
                                    city + "\n" + street + "\n" + houseNumber + "\n" + "NUM" + "\n");
                            for (int y = 0; y < node.phoneNumber.length; y++) {
                                writer.write(node.phoneNumber[y] + "\n");
                            }
                            writer.write("STOP" + "\n");
                            writer.flush();
                        } catch (IOException e) {
                            break;
                        }

                        break;
                    case 2:
                        boNum = node.adressBox.getBoxNumber();
                        city = node.adressBox.getCity();
                        zipCode = node.adressBox.getZipCode();
                        try {
                            writer.write(node.adressType + "\n" + firstname + "\n" + surahme + "\n" + companyName + "\n" + zipCode + "\n" +
                                    city + "\n" + boNum + "\n" + "NUM" + "\n");
                            for (int y = 0; y < node.phoneNumber.length; y++) {
                                writer.write(node.phoneNumber[y] + "\n");
                            }
                            writer.write("STOP" + "\n");
                            writer.flush();
                        } catch (IOException e) {
                            break;
                        }
                        break;
                    case 3:
                        freeAdres = node.freeAdress.getAdress();
                        try {
                            writer.write(node.adressType + "\n" + firstname + "\n" + surahme + "\n" + companyName + "\n" + freeAdres
                                    + "\n" + "NUM" + "\n");
                            for (int y = 0; y < node.phoneNumber.length; y++) {
                                writer.write(node.phoneNumber[y] + "\n");
                            }
                            writer.write("STOP" + "\n");
                            writer.flush();
                        } catch (IOException e) {
                            break;
                        }
                }
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Succesfully exported list");
    }

    /**
     * This function imports the nodes from the textfile and puts them in the list, if there are no nodes in the list
     * it will create a new one and add them to the front, if there are alread nodes present in the list it will
     * add the new imported ones to the back.
     */
    public void importNode() {
        String         line;
        String[]       inputRead = new String[1];
        Node           node;
        BufferedReader reader;
        int x = 1;
        int c;

        /*
         * The textfile gets read by the buffered reader and then saved in a array to be used later
         */
        try {
            reader = new BufferedReader(new FileReader("output.txt"));
            while ((line = reader.readLine()) != null) {
                String[] temp = new String[inputRead.length + 1];
                if (inputRead[0] != null) {
                    System.arraycopy(inputRead, 0, temp, 0, inputRead.length);
                    if (x == inputRead.length) {
                        temp[x] = line;
                        inputRead = temp;
                        x = x + 1;
                    }
                } else {
                    inputRead[0] = line;
                }
            }
            reader.close();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }

        /*
         * This for loop goes through the array, adding the nodes depending on the adress type. It then deletes the
         * freshly created node out of the array read from the textfile and continues doing this untill there are no
         * entries left in the textfile
         */
        for(int i = 0; i < inputRead.length; i++){
            switch(inputRead[0]){
                case "1":
                    Node.Adress1 adress = new Node.Adress1(inputRead[6], inputRead[5], inputRead[4], inputRead[7]);
                    node = new Node(inputRead[1], inputRead[2], inputRead[3], adress);
                    c = 9;
                    while(!inputRead[c].contains("STOP")){
                        c++;
                    }
                    String[] temp2 = new String[c - 9];
                    System.arraycopy(inputRead, 9, temp2, 0, temp2.length);
                    node.phoneNumber = temp2;
                    if (size == 0) {
                        start = node;
                        node.setPrevious(null);
                        node.setNext(null);
                    } else {
                        Node prev = start;
                        while (prev.getHasNext()) {
                            prev = prev.next;
                        }
                        prev.setNext(node);
                        node.setPrevious(prev);
                    }
                    size++;
                    c++;
                    String[] temp3 = new String[inputRead.length - c];
                    System.arraycopy(inputRead, c, temp3, 0, temp3.length);
                    inputRead = temp3;
                    break;
                case "2":
                    Node.Adress2 adress2 = new Node.Adress2(inputRead[6], inputRead[5], inputRead[4]);
                    node = new Node(inputRead[1], inputRead[2], inputRead[3], adress2);
                    c = 8;
                    while(!inputRead[c].contains("STOP")){
                        c++;
                    }
                    temp2 = new String[c - 8];
                    System.arraycopy(inputRead, 8, temp2, 0, temp2.length);
                    node.phoneNumber = temp2;
                    if (size == 0) {
                        start = node;
                        node.setPrevious(null);
                        node.setNext(null);
                    } else {
                        Node prev = start;
                        while (prev.getHasNext()) {
                            prev = prev.next;
                        }
                        prev.setNext(node);
                        node.setPrevious(prev);
                    }
                    size++;
                    c++;
                    temp3 = new String[inputRead.length - c];
                    System.arraycopy(inputRead, c, temp3, 0, temp3.length);
                    inputRead = temp3;
                    break;
                case "3":
                    Node.Adress3 adress3 = new Node.Adress3(inputRead[4]);
                    node = new Node(inputRead[1], inputRead[2], inputRead[3], adress3);
                    c = 6;
                    while(!inputRead[c].contains("STOP")){
                        c++;
                    }
                    temp2 = new String[c - 6];
                    System.arraycopy(inputRead, 6, temp2, 0, temp2.length);
                    node.phoneNumber = temp2;
                    if (size == 0) {
                        start = node;
                        node.setPrevious(null);
                        node.setNext(null);
                    } else {
                        Node prev = start;
                        while (prev.getHasNext()) {
                            prev = prev.next;
                        }
                        prev.setNext(node);
                        node.setPrevious(prev);
                    }
                    size++;
                    c++;
                    temp3 = new String[inputRead.length - c];
                    System.arraycopy(inputRead, c, temp3, 0, temp3.length);
                    inputRead = temp3;
                    break;
            }
        }
        System.out.println("Succesfully imported list");

    }

    /**
     * Amount of node elements in the list
     */
    public int size() {
        return this.size;
    }

}


