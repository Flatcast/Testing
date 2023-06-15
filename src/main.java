import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split("");
        System.out.println();
        for (String s : arr) {
            System.out.print(s+" ");
        }
    }
}
