package Part1;

import java.util.ArrayList;


public class Praktikum {
    public static void main(String[] args) {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(190.23);
        expenses.add(290.32);
        expenses.add(420.03);
        if(expenses.isEmpty()){
            System.out.println("Нет сохраненных трат");
        }else{
            System.out.println("Трат в списке - "+ expenses.size());
        }
        if(expenses.contains(120.23)==false){
            expenses.add(120.23);

        }else{
            System.out.println("Все расходы учтены");
        }
    }
}
class MetalBand{
    short year;
    String name;
}

