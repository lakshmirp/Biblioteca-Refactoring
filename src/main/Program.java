package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";


    public static void main(String[] args) {
        while (true) {
            printWelcome();
            printMenu();

            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStream);
            int menuOption = getInput(reader);

            if (menuOption == 1) {
               new PrintBookListCommand().execute();
            }
            else if (menuOption == 2) {
                System.out.println(" Please enter the number of the book you wish to checkout: ");
                int selectedBookNumber = getInput(reader);

                switch (selectedBookNumber) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Sorry we don't have that book yet.");
                }
            }
            else if (menuOption == 3) {

                if (loggedIn) {
                    System.out.println("\n");
                    System.out.println("Your library number is " + savedLibraryNumber);
                }
                else {
                    System.out.println("\n");
                    System.out.println("Please talk to Librarian. Thank you.");
                }
            }
            else if (menuOption == 4) {
                System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
                System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
                System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
                System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
                System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
                System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
                System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
                System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
                System.out.println(createMovie("Inception", "Frank Darabont", "10"));
                System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
            }
            else if (menuOption == 5) {
                clearLogin();
                System.out.println("Enter your library number");
                try {
                    String libraryNumber = reader.readLine();
                    if (validLibraryNumber(libraryNumber)) {
                        try {
                            System.out.println("Enter your Password: ");
                            String password = reader.readLine();
                            if (validPassword(password)) {
                                loggedIn = true;
                                savedLibraryNumber = libraryNumber;
                            }
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }

            }
            else if (menuOption == 9) {
                System.out.println("Quitting...");
                break;
            }
            else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }


    private static int getInput(BufferedReader reader) {
        int i = 0;
        try {
            String value = reader.readLine();
            i = Integer.parseInt(value);
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
        }
        return i;
    }

    private static void printMenu() {
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static void printWelcome() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
    }

    private static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

