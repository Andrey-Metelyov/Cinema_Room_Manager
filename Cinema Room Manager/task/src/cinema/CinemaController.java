package cinema;

import java.util.Scanner;

public class CinemaController {
    CinemaModel cinemaModel;
    Scanner scanner = new Scanner(System.in);

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
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        if (cinemaModel.getSeatState(row - 1, seat - 1).equals("S")) {
            cinemaModel.setSeatState(row - 1, seat - 1, "B");
            int price = getPrice(row, seat);
            System.out.println(System.lineSeparator() + "Ticket price: $" + price);
            return;
        }
        System.out.println("invalid seat");
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
}
