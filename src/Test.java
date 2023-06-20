import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arrayIn = {1, 5, -3, 8, 7, -5, 8, 13};
        sortOf(arrayIn);
        sumOf(arrayIn);
        System.out.println(averageOf(arrayIn));
        System.out.println(containsOf(arrayIn, 6));
    }

    public static void sumOf(int[] arrayIn) {
        int sum = 0;
        for (int el : arrayIn) {
            sum += el;
        }
        System.out.println(sum);
    }

    public static void sortOf(int[] arrayIn) {
        int count = 1;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < arrayIn.length - 1; i++) {
                if (arrayIn[i] > arrayIn[i + 1]) {
                    count++;
                    int temp = arrayIn[i];
                    arrayIn[i] = arrayIn[i + 1];
                    arrayIn[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayIn));
    }

    public static double averageOf(int[] arrayIn) {
        int count = 0;
        double sum = 0;
        for (int el : arrayIn) {
            sum += el;
            count++;
        }
        return sum / count;
    }

    public static boolean containsOf(int[] arrayIn, int sv) {
        int count = 0;
        for (int i = 0; i < arrayIn.length - 1; i++) {
            if (sv == arrayIn[i]) {
                count++;
            }
        }
        return (count > 0);

    }
}
