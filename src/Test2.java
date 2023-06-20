import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {


        System.out.println();
        int rows = 7;
        int rowBusy = 2;
        if (rows %2==0){
            System.out.println(((rows / 2) < rowBusy) ? "Ticket price: $10" : "Ticket price: $8");
        }else
        System.out.println((((rows -1)/ 2) < rowBusy) ? "Ticket price: $10" : "Ticket price: $8");

    }
}