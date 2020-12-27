package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        CinemaController cinemaController = new CinemaController();
        cinemaController.showPlan();
        cinemaController.buyTicket();
        cinemaController.showPlan();
    }

}