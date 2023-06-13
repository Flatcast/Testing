import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Expression Exp = new Expression(10, 5, 12);
        double S = Exp.getA() + Exp.getB() + Exp.getC();
        System.out.println(Exp.getOut() + S);
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        for (Integer x:arrayList) System.out.println(x);

        arrayList.remove(5);
        System.out.println(arrayList);
    }
}

