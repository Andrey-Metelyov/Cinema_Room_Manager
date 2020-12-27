package cinema;

import java.util.Scanner;

public class CinemaController {
    private CinemaModel cinemaModel;
    private Scanner scanner = new Scanner(System.in);
    private int soldTickets = 0;
    private int currentIncome = 0;

    CinemaController() {
        createCinemaModel();
    }

    private void createCinemaModel() {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        cinemaModel = new CinemaModel(rows, seatsInRow);
    }

    public void buyTicket() {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            if (row > cinemaModel.getRows()) {
                System.out.println("Wrong input!");
                return;
            }
            System.out.println("Enter a seat number in that row:");

            int seat = scanner.nextInt();
            if (seat > cinemaModel.getSeatsInRow()) {
                System.out.println("Wrong input!");
                return;
            }
            if (cinemaModel.getSeatState(row - 1, seat - 1).equals("S")) {
                cinemaModel.setSeatState(row - 1, seat - 1, "B");
                int price = getPrice(row, seat);
                System.out.println(System.lineSeparator() + "Ticket price: $" + price);
                soldTickets++;
                currentIncome += price;
                return;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }
    }

    private int getPrice(int row, int seat) {
        int rows = cinemaModel.getRows();
        int seatsInRow = cinemaModel.getSeatsInRow();
        int totalNumberOfSeats = rows * seatsInRow;
        if (totalNumberOfSeats <= 60) {
            return 10;
        }
        return (row <= (rows / 2)) ? 10 : 8;
    }

    public void showPlan() {
        System.out.println(System.lineSeparator() + "Cinema:");
        System.out.print(" ");
        int rows = cinemaModel.getRows();
        int seatsInRow = cinemaModel.getSeatsInRow();
        for (int i = 0; i < seatsInRow; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print(System.lineSeparator());
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatsInRow; j++) {
                System.out.print(" " + cinemaModel.getSeatState(i, j));
            }
            System.out.print(System.lineSeparator());
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println(System.lineSeparator() +
                    "1. Show the seats\n" +
                            "2. Buy a ticket\n" +
                            "3. Statistics\n" +
                            "0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    showPlan();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                default:
                    System.out.println("Wrong input!");
                    continue;
            }
        }
    }

    private void showStatistics() {
        int totalNumberOfSeats = cinemaModel.getRows() * cinemaModel.getSeatsInRow();
        System.out.println("soldTickets=" + soldTickets);
        System.out.println("totalNumberOfSeats=" + totalNumberOfSeats);
        float percentage = 100.0f * soldTickets / totalNumberOfSeats;
        System.out.println(percentage);
        String strPercentage = String.format("%.2f", percentage);
        System.out.println(strPercentage);
        System.out.println("\n" +
                "Number of purchased tickets: " + soldTickets + "\n" +
                "Percentage: " + strPercentage + "%\n" +
                "Current income: $" + currentIncome + "\n" +
                "Total income: $" + getTotalIncome() + "");
    }

    private int getTotalIncome() {
        int rows = cinemaModel.getRows();
        int seatsInRow = cinemaModel.getSeatsInRow();
        if (rows * seatsInRow <= 60) {
            return 10 * rows * seatsInRow;
        }
        return rows / 2 * seatsInRow * 10 + (rows - rows / 2) * seatsInRow * 8;
    }
}
