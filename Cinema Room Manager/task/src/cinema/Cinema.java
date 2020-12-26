package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        String[][] seats = new String[][] {
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"},
                {"S", "S", "S", "S", "S", "S", "S", "S"}};
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