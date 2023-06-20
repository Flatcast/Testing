import java.util.Scanner;

public class Fuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fuel price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter a fuel expenses per dist: ");
        double mpg = scanner.nextDouble();
        System.out.print("Enter a dist in mi: ");
        double dist = scanner.nextDouble();

        double fexp = (3.78*dist*price)/mpg;

        System.out.printf("Денех: %.2f",fexp);
    }
}
