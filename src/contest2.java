import java.util.Scanner;

public class contest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // кол-во работ на проверку
        int m = sc.nextInt(); // кол-во проверяющих
        int k = sc.nextInt(); // кол-во необходимых проверок
        int res = (int)Math.ceil((float)(k * n) / (float)m);
        System.out.println(res);
    }
}