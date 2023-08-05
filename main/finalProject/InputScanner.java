package finalProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    static Scanner scanner = new Scanner(System.in);

    static double inputDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Incorrect input." +
                        "\nPlease, write a number");
            }
        }
    }

    static int inputInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please, write an integer:");
            }
        }
    }

    static boolean isAnswerYes() {
        String answer = scanner.nextLine().strip();
        while (true) {
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Please, write correct answer(yes/no)");
                answer = scanner.nextLine().strip();
            }
        }
    }

    static String inputString() {
        return scanner.nextLine().strip();
    }

}
