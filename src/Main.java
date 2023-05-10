import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        task2();

    }
    static void task1() {
        Scanner conin = new Scanner(System.in);
        String sequence = conin.nextLine();
        boolean res = isCodedMessage(sequence);
        System.out.println(res);
    }

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
        Scanner conin = new Scanner(System.in);
        n = conin.nextInt();
        for (int i = 0; i < n; i++) {
            deltaT = conin.nextInt();
            // сохранение первого элемента
            if (i == 0)
                firstDelta = deltaT;
            tSum += deltaT;
            // ветвление на отрицательность изменения
            resSign = conin.next();
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

    static boolean isCodedMessage(String sequence) {
        char[] charSequence = sequence.toCharArray();
        byte[] symbolCounters = new byte[11];
        byte i = 0;
        // считываем первые 10 символов
        for (i = 0; i < 10; i++) {
            char currSymb = charSequence[i];
            if (currSymb == '?')
                symbolCounters[10] += 1;
            else
                symbolCounters[currSymb - '0'] += 1;
        }
        // проверяем, можно ли в этих символах найти шифр
        byte tempCounter = symbolCounters[10];
        byte j = 0;
        for (j = 0; j < 10; j++) {
            if (symbolCounters[j] > 1)
                break;
            if (symbolCounters[j] < 1) {
                if (tempCounter < 1)
                    break;
                tempCounter -= 1;
            }
        }
        if (j == 10)
            return true;
        while (i < charSequence.length) {
            if ((charSequence[i]) == '?')
                symbolCounters[10] += 1;
            else
                symbolCounters[(charSequence[i] - '0')] += 1;
            if ((charSequence[i - 10]) == '?')
                symbolCounters[10] += 1;
            else
                symbolCounters[(charSequence[i - 10] - '0')] -= 1;
            System.out.println(charSequence[i]);
            // проверяем, можно ли в этих символах найти шифр
            tempCounter = symbolCounters[10];
            for (j = 0; j < 10; j++) {
                if (symbolCounters[j] > 1)
                    break;
                if (symbolCounters[j] < 1) {
                    if (tempCounter < 1)
                        break;
                    tempCounter -= 1;
                }
            }
            if (j == 10)
                return true;
            i++;
        }
        return false;
    }

}