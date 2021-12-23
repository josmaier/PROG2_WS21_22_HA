import java.util.InputMismatchException;
import java.util.Scanner;
public class AdresskarteiInterface {

    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    int y = 0;
    Adresskartei adr;
    boolean isRunning = true;
    public void startKartei(){
        this.adr = new Adresskartei();
        running();
    }

    public void running(){
        if (isRunning){
            this.mainMenu();
        }

    }

    public void mainMenu(){
        if(isRunning) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Menu");
            System.out.println();
            System.out.println("Please select what you want to do:");
            System.out.println("Enter 1 if you want to add a new entry to the list");
            System.out.println("Enter 2 if you want to output the list");
            System.out.println("Enter 3 if you want to search the list for entries");
            System.out.println("Enter 4 if you want to export your list to a text file");
            System.out.println("Enter 5 if you want to import a list from a previously exported list");
            System.out.println("Enter 6 if you want to leave the program");
            int y = 0;
            try {
                y = input.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("ERROR YOU NEED TO INPUT A INTEGER");
                y = input2.nextInt();
            }
            switch (y) {
                case 1:
                    chooseAdd();
                    this.mainMenu();
                    break;
                case 2:
                    chooseOutput();
                    this.mainMenu();
                    break;
                case 3:
                    chooseSearch();
                    this.mainMenu();
                    break;
                case 4:
                    chooseExport();
                    this.mainMenu();
                    break;
                case 5:
                    chooseImport();
                    this.mainMenu();
                    break;
                case 6:
                    chooseLeave();
                    this.mainMenu();
                    break;
            }
        }
    }

    public void chooseAdd(){
        this.adr.add();
    }
    public void chooseOutput(){
        System.out.println("Please choose if you want the list outputted in a short form, or in a detailed view.");
        System.out.println("Type 1 for the short output variant");
        System.out.println("Type 2 for the detailed view");
        int i = 1;
        if(this.adr.size() != 0) {
            try {
                i = input.nextInt();
                if (i == 1) {
                    this.adr.outputListShort();
                } else if (i == 2) {
                    this.adr.outputListLong();
                }
            } catch (Exception e) {
                System.out.println("Error, please put in a number");
                i = input2.nextInt();
                if (i == 1) {
                    this.adr.outputListShort();
                } else if (i == 2) {
                    this.adr.outputListLong();
                }
            }

        } else {
            System.out.println("Your list is empty, no entries to display!");
        }
    }
    public void chooseSearch(){
        Scanner inputTemp = new Scanner(System.in);
        System.out.println("Please input the name, or part of a name, that you are searching for: ");
        String h;
        input.reset();
        try {
            inputTemp.nextLine();
            h = inputTemp.nextLine();
            if (this.adr.size() != 0) {
                this.adr.outputListResult(this.adr.outputSearchResultArray(h));
            } else {
                System.out.println("Your list is empty, there are no entries to search");
            }
        } catch (NullPointerException e){
            System.out.println("the search text can not be null");
        }
        inputTemp.close();
    }

    public void chooseExport(){
        this.adr.exportNode(this.adr.listToArray());
    }

    public void chooseImport(){
        this.adr.importNode();
    }

    public void chooseLeave(){
        System.out.println("Are you sure that you want to leave the program? If you are please type ´yes´");
        String h = input.nextLine();
        h = input.nextLine();
        if(h.contains("yes")){
            isRunning = false;
            this.input.close();
            this.input2.close();
            
        }
    }
}
