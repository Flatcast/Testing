import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int fixed = 0;
        int reject = 0;
        int shipped = 0;
        for (int i : array) {
            i = scanner.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 1:
                    fixed += 1;
                    break;
                case -1:
                    reject += 1;
                    break;
                case 0:
                    shipped += 1;
                    break;
            }
        }
        System.out.println(shipped+" "+fixed+" "+reject);

    }

}