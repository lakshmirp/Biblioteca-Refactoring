package main;


public class DisplayLibraryNumberCommand implements Command{
    Boolean loggedIn;
    String savedLibraryNumber;
    DisplayLibraryNumberCommand(Boolean loggedIn,String savedLibraryNumber){
        this.loggedIn = loggedIn;
        this.savedLibraryNumber = savedLibraryNumber;
    }
    @Override
    public void execute() {

        if (loggedIn) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
        }
        else {
            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }
}
