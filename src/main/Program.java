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
                new ReserveBookCommand().execute();

            }
            else if (menuOption == 3) {
                new DisplayLibraryNumberCommand(loggedIn,savedLibraryNumber).execute();
            }
            else if (menuOption == 4) {
                new PrintMovieListCommand().execute();
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


}

