
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsPerRow = scanner.nextInt();
        int rowBusy = 0;
        int seatBusy = 0;
        int[][] busySeats = new int[rows + 1][seatsPerRow + 1];
        boolean menuCond = true;
        boolean purchCond = true;
        while (menuCond) {
            menu();
            int menuChoise = scanner.nextInt();
            switch (menuChoise) {
                case 1:
                    printCinema(rows, seatsPerRow, rowBusy, seatBusy, busySeats);
                    System.out.println();
                    break;//print map of Cinema hall
                case 2:
                    while (purchCond) {
                        System.out.println("Enter a row number: ");
                        rowBusy = scanner.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        seatBusy = scanner.nextInt();
                        System.out.println();
                        if (rowBusy >= 10 || seatBusy >= 10 || rowBusy <= 0 || seatBusy <= 0) {
                            System.out.println("Wrong input!\n");
                        } else if (busySeats[rowBusy][seatBusy] == 1) {
                            System.out.println("That ticket has already been purchased!\n");
                        } else break;
                    }
                    printCinemaBusy(rows, seatsPerRow, rowBusy, seatBusy, busySeats);
                    break;
                case 3:
                    getStatistics(busySeats, rows, seatsPerRow);
                    break;
                case 0:
                    menuCond = false;
                    break;
            }
        }
    }

    public static void getStatistics(int[][] busySeats, int rows, int seatsPerRow) {
        int purchasedTickets = 0;
        double percentage = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seatsPerRow; j++) {
                purchasedTickets += busySeats[i][j];
            }
        }
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        percentage = (double) purchasedTickets / (rows * seatsPerRow) * 100;
        System.out.println("Current income: $"+currentIncome(rows, seatsPerRow, busySeats));
        System.out.printf("Percentage: %.2f%%\n", percentage);
        calculateIncome(rows, seatsPerRow);
        System.out.println();
    }

    public static void menu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void printCinema(int rows, int seatsPerRow, int rowBusy, int seatBusy, int[][] busySeats) {

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
            for (int j = 1; j <= seatsPerRow; j++) {
                System.out.print(busySeats[i][j] == 1 ? "B " : "S ");
            }
            System.out.println();
        }
    }

    public static void printCinemaBusy(int rows, int seatsPerRow, int rowBusy, int seatBusy, int[][] busySeats) {
        System.out.println();
        if (rows * seatsPerRow >= 60) {
            if (rowBusy >= 1 && rowBusy <= rows / 2) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        } else {
            System.out.println("Ticket price: $10");
        }
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
            for (int j = 1; j <= seatsPerRow; j++) {
                System.out.print(busySeats[i][j] == 1 ? "B " : "S ");
            }
            System.out.println();
        }
    }

    public static void calculateIncome(int rows, int seatsPerRow) {
        int totalSeats = rows * seatsPerRow;
        int ticketPrice = 0;
        int income = 0;
        if (totalSeats <= 60) {
            ticketPrice = 10;
            income = ticketPrice * totalSeats;
            System.out.printf("Total income: $%d\n", income);
        } else {
            if (rows % 2 == 0) {
                income = totalSeats / 2 * 10 + totalSeats / 2 * 8;
                System.out.printf("Total income: $%d\n", income);
            } else {
                income = (rows / 2) * 10 * seatsPerRow + ((rows / 2) + 1) * 8 * seatsPerRow;
                System.out.printf("Total income: $%d\n", income);
            }
        }

    }

    public static int currentIncome(int rows, int seatsPerRow, int[][] busySeats) {
        int totalSeats = rows * seatsPerRow;
        int income = 0;
        if (totalSeats <= 60) {
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= seatsPerRow; j++) {
                    income += busySeats[i][j]*10;
                }
            }
        }else{
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= seatsPerRow; j++) {
                    if(i<=rows/2){
                        income += busySeats[i][j]*10;
                    }else{
                        income += busySeats[i][j]*8;
                    }
                }
            }
        }
        return income;
    }
}