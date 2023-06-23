import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int rows = 7;
        int seatsPerRow = 7;
        int rowBusy = 3;
        int seatBusy = 4;
        int[][] busySeats = new int[rows +1][seatsPerRow +1];
        busyPlaces(rows, seatsPerRow, rowBusy, seatBusy, busySeats);
        rowBusy = 5;
        seatBusy = 7;
        busyPlaces(rows, seatsPerRow, rowBusy, seatBusy, busySeats);
    }

    public static void busyPlaces(int rows, int seatsPerRow, int rowBusy, int seatBusy,int[][] busySeats) {
        busySeats[rowBusy][seatBusy] = 1;
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seatsPerRow; j++){
                System.out.print(busySeats[i][j]+" ");
            }
            System.out.println();
        }
    }
}