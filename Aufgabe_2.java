import java.util.*;

public class Aufgabe_2 {
    public static void main(String[] args) {
        
        int choice = 0;
        while (choice != 8) {

            System.out.println("\nYou can now choose what you want to do with your array.");

            System.out.println("1) Print current array");
            System.out.println("2) Print array metrics");
            System.out.println("3) Search for element by value");
            System.out.println("4) Remove an element by index");
            System.out.println("5) Add an element at index");
            System.out.println("anything else) Exit program");
            choice = scn.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("Current array:");
                    System.out.println("OUT OF ORDER");
                    break;
                case 2:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.print("The biggest value is " + maxValue + "\n");
                    break;
                case 4:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.print("The smallest value is " + minValue + "\n");
                    break;
                case 5:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("\nYour array:\n" + Arrays.toString(passedArray));
                    System.out.println("Which index do you want to get the value for?");
                    int valueAtIndex = scn.nextInt();
                    while (valueAtIndex < 0 || valueAtIndex > arrayLength - 1) {
                        System.out.println("Please enter a valid index! ( 0 - " + (arrayLength - 1) + " )");
                        valueAtIndex = scn.nextInt();
                    }
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("The value at index " + valueAtIndex + " is " + passedArray[valueAtIndex]);
                    break;
                case 6:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("\nYour array:\n" + Arrays.toString(passedArray));
                    System.out.println("Which value do you want to remove?");
                    String toBeRemoved = scn.next();
                    for (int i = 0; i < arrayLength; i++) {
                        if (passedArray[i].equals(toBeRemoved))
                            passedArray[i] = "";
                    }
                    break;
                case 7:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("\nThe array you passed:\n" + Arrays.toString(passedArray));
                    System.out.println("What value do you want to add?");
                    String toBeAdded = scn.next();
                    System.out.println("At which index do you want to add this value?");
                    int toBeAddedAt = scn.nextInt();
                    passedArray[toBeAddedAt] = toBeAdded;
                    System.out.println();
                    break;
                case 8:
                    System.out.println("\033[H\033[2J"); // this clears the terminal
                    System.out.println("\nGoodbye!\n");
                    break;
                default:
                    System.out.println("Please enter a number between 1-8 to tell the program what to do!");
            }
        }
        scn.close();
    }
}
