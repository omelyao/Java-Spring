package firstwork;

import java.util.ArrayList;
import java.util.List;

public class firstwork {
    public static void main(String[] args) {
        ArrayList<Integer> listnumbers = new ArrayList<>();

        int sumofnumbers = 0;
        for (int i = 0; i < 1000; i++){
            if ((i % 3 == 0) || (i % 5 == 0)){
                listnumbers.add(i);
                sumofnumbers +=i;
            }
        }
        System.out.println(listnumbers);
        System.out.println("Сумма всех чисел в диапазоне до 1000 кратных 3 или 5: " + sumofnumbers);

    }
}
