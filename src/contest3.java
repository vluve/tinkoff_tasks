import java.util.Scanner;

public class contest3 {
    public static void main(String[] args) {
        var countOfChars = new Scanner(System.in).nextInt();
        var charArray = new Scanner(System.in).nextLine();

        System.out.println(findMinCorrectStr(charArray));
    }

    public static Integer findMinCorrectStr(String charArray) {
        int minVal = Integer.MAX_VALUE;
        for (int startPos = 0; startPos <= charArray.length() - 4; startPos++) {
            for (int endPos = startPos + 3; endPos <= charArray.length(); endPos++) {
                var charArr = charArray.substring(startPos, endPos).toCharArray();
                if (minVal > charArr.length && isCorrectStr(charArr)) {
                    minVal = charArr.length;
                }
            }
        }
        if (minVal == Integer.MAX_VALUE)
            return -1;
        else
            return minVal;
    }

    private static boolean isCorrectStr(char[] charArr) {
        boolean[] charAvalible = new boolean[4];
        for (var ch : charArr) {
            switch (ch) {
                case 'a' -> charAvalible[0] = true;
                case 'b' -> charAvalible[1] = true;
                case 'c' -> charAvalible[2] = true;
                case 'd' -> charAvalible[3] = true;
            }
        }

        for (var ch : charAvalible) {
            if (ch == false) return false;
        }
        return true;
    }


}