package cinema;

import java.util.Scanner;

public class Cinema {

    private static final String[][] seats = new String[][] {
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"},
            {"S", "S", "S", "S", "S", "S", "S", "S"}};

    public static void main(String[] args) {
        // Write your code here
//        showSeats();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        System.out.println("Total income:");
        System.out.println("$" + getTotalIncome(rows, seatsInRow));
    }

    private static int getTotalIncome(int rows, int seatsInRow) {
        int totalNumberOfSeats = rows * seatsInRow;
        if (totalNumberOfSeats <= 60) {
            return 10 * totalNumberOfSeats;
        }
        return (rows / 2) * seatsInRow * 10 +
                (rows - rows / 2) * seatsInRow * 8;
    }

    private static void showSeats() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print(System.lineSeparator());
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.print(System.lineSeparator());
        }
    }
}