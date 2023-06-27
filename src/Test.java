import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] array = null;
        int index = -10;
        calculateSquare(array, index);
    }

    public static void calculateSquare(int[] array, int index) {
        if (array == null) {
            System.out.println("Exception!");
        } else if (index < 0) {
            System.out.println("Exception!");
        } else if (index > array.length) {
            System.out.println("Exception!");
        } else {
            System.out.println((int) Math.pow(array[index], 2));
        }
    }
}



