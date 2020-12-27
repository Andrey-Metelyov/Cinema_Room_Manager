package cinema;

public class CinemaModel {
    private final String[][] seats;
    private final int rows;
    private final int seatsInRow;

    public CinemaModel(int rows, int seatsInRow) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        seats = new String[rows][seatsInRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                seats[i][j] = "S";
            }
        }
    }

    public void setSeatState(int row, int seatNumber, String state) {
        seats[row][seatNumber] = state;
    }

    public String getSeatState(int row, int seatNumber) {
        return seats[row][seatNumber];
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }
}
