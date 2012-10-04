package main;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReserveBookCommand implements Command{
    InputStreamReader inputStream = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStream);

    @Override
    public void execute() {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int selectedBookNumber = 0;
        try {
            String value = reader.readLine();
            selectedBookNumber = Integer.parseInt(value);
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
        }
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
}
