package firstwork;

public class secondwork {
    public static void main(String[] args) {
        int mini = 10000;
        int[][] x = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };
        for(int i=0; i <x.length; i++){
            for(int j=0; j < x.length; j++){
                mini = Math.min(x[i][j], mini);
            }
        }
        System.out.println("Минимальный элемент в массиве: " + mini);
    }
}
