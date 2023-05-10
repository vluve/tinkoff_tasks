import java.util.Scanner;

public class contest1 {
    public static void main(String[] args) {
        System.out.println(check());


    }

    public static String check() {
        Scanner scanner = new Scanner(System.in);
        var firstNum = scanner.nextInt();
        var thecondNum = scanner.nextInt();

        if (firstNum < thecondNum){
            var therdNum = scanner.nextInt();
            if (thecondNum > therdNum)return "NO";

            var fourthNum = scanner.nextInt();
            if (therdNum > fourthNum) return "NO";
        } else {
            var therdNum = scanner.nextInt();
            if (thecondNum < therdNum)return "NO";

            var fourthNum = scanner.nextInt();
            if (therdNum < fourthNum) return "NO";
        }

        return "YES";
    }
}