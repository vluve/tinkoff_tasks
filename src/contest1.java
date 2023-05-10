import java.util.Scanner;

public class contest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // кол-во работ на проверку
        int m = sc.nextInt(); // кол-во проверяющих
        int k = sc.nextInt(); // кол-во необходимых проверок
        int res = (int)Math.ceil((float)(k * n) / (float)m);
        System.out.println(res);
    }
}

/*
* 3 2 2
*i t1 t2 t3
*0 2  2  2
*1 1  1  2
*2 0  1  1
*3 0  0  0
*
* 4 2 2
*i t1 t2 t3 t4
*0 2  2  2  2
*1 1 1 2 2
* 1 1 1 1
* 0 0 1 1
* 0 0 0 0
*2
*3 0  0  0
*
* 7 3 2
* i | 1 2 3 4 5 6 7
* -----------------
* 0 | 2 2 2 2 2 2 2
* 1 | 1 1 1 2 2 2 2
* 2 | 1 1 1 1 1 1 2
* 3 | 0 0 1 1 1 1 1
* 4 | 0 0 0 0 0 1 1
* 5 | 0 0 0 0 0 0 0
* */
