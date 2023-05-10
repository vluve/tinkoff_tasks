import java.util.Scanner;

public class contest2 {
    static void task2() {
        int firstDelta, deltaT, tSum, maxT0, minT0, n;
        // флажки для исключительных случаев
        boolean areAllNegative = true;
        boolean areAllPositive = true;
        String resSign;
        maxT0 = 10000; // правая граница интервала, в котором могла быть начальная температура (входит)!!
        minT0 = -10000; // левая граница интервала, в котором могла быть начальная температура (не входит!!!)
        tSum = 0;
        firstDelta = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            deltaT = sc.nextInt();
            // сохранение первого элемента
            if (i == 0)
                firstDelta = deltaT;
            tSum += deltaT;
            // ветвление на отрицательность изменения
            resSign = sc.next();
            if (resSign.equals("-")) {
                areAllPositive = false;
                // сдвиг правой границы
                if (maxT0 > (-tSum))
                    maxT0 = (-tSum);
            }
            else {
                areAllNegative = false;
                // сдвиг левой границы
                if (minT0 < (-tSum))
                    minT0 = (-tSum);
            }
        }
        // если все измерения были неотрицательными
        if (areAllPositive) {
            System.out.println("inf");
            return;
        }
        // если все измерения были отрицательными
        if (areAllNegative) {
            // если сумма изменений была неотрицательной (сложений больше чем вычитаний)
            if (tSum >= 0) {
                System.out.println("-1");
                return;
            }
            // если сумма изменений была отрицательной (вычитаний больше чем сложений)
            else {
                // если первым было вычитание - заменяем это вычитание на -1
                if (firstDelta < 0) {
                    tSum -= firstDelta;
                    tSum += -1;
                    System.out.println(tSum);
                    return;
                }
                // если первым было сложение - берём начальной точкой (-первое_изменение - 1)
                else {
                    tSum += (-firstDelta - 1);
                    System.out.println(tSum);
                    return;
                }
            }
        }
        System.out.println(maxT0 - 1 + tSum);
    }

    public static void main(String[] args) {
        task2();
    }
}
