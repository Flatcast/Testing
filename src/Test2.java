import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        String lastName = scanner.next();
        scanner.close();
        System.out.println(createFullName(firstName,lastName));
    }
    public static String createFullName(String firstName,String lastName){
        return firstName+" "+lastName;
    }
}
