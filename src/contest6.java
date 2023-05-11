import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class contest6 {

    public static class DiposonOfPoints implements Comparable<DiposonOfPoints> {
        Integer minPoint;
        Integer maxPoin;

        public DiposonOfPoints(Integer minPoint, Integer maxPoin) {
            this.minPoint = minPoint;
            this.maxPoin = maxPoin;
        }

        @Override
        public int compareTo(DiposonOfPoints o) {
            var resOfCompare = o.maxPoin.compareTo(this.maxPoin);
            if (resOfCompare == 0) {
                return o.minPoint.compareTo(this.minPoint);
            }

            return resOfCompare;
        }

        public boolean canRudeceOne() {
            return maxPoin - 1 > minPoint;
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int countOfStudents = sc.nextInt();
        int sumOfPoints = sc.nextInt();

        List<DiposonOfPoints> diposonOfPoints = inmutDiaposonse(countOfStudents);

//        .sort();sort
        Collections.sort(diposonOfPoints);

        findOptimalPoints(sumOfPoints, diposonOfPoints);

        System.out.println(diposonOfPoints.get(diposonOfPoints.size() / 2).maxPoin);
    }

    private static void findOptimalPoints(int sumOfPoints, List<DiposonOfPoints> diposonOfPoints) {
        int tempSum, tempPoint;
        boolean f = false;
        while (true) {
            tempSum = sumOfPoints;
            // проходим по циклу
            for (int i = 0; i < diposonOfPoints.size(); i++) {

                if (f && i != diposonOfPoints.size() - 1) {
                    tempPoint = diposonOfPoints.get(i).maxPoin - 1;
                    if (tempPoint > diposonOfPoints.get(i).minPoint && tempPoint >= diposonOfPoints.get(i + 1).maxPoin) {
                        diposonOfPoints.get(i).maxPoin -= 1;
                        f = false;
                    }
                }
                if (tempSum < diposonOfPoints.get(i).minPoint) {
                    f = true;
                    break;
                }
                diposonOfPoints.get(i).maxPoin = Math.min(tempSum, diposonOfPoints.get(i).maxPoin);
                tempSum -= diposonOfPoints.get(i).maxPoin;
            }
            if (!f)
                break;
        }
    }

    /*public static void findOptimalPoints(int sumOfPoints, List<DiposonOfPoints> diposonOfPoints) {
        while (isSumOfPointsElsEdge(diposonOfPoints, sumOfPoints)) {
            for (int i = 0; i < diposonOfPoints.size(); i++) {
                if (sumOfPoints - diposonOfPoints.get(i).curentPoint > 0) {
                    sumOfPoints -= diposonOfPoints.get(i).curentPoint;
                } else if (sumOfPoints > diposonOfPoints.get(i).minPoint) {
                    diposonOfPoints.get(i).curentPoint = sumOfPoints;
                } else {
                    diposonOfPoints.get(i).curentPoint = diposonOfPoints.get(i).minPoint;
                    for (int j = 0; j < diposonOfPoints.size(); j++) {
                        if (diposonOfPoints.get(i).canRudeceOne()) {
                            diposonOfPoints.get(i).curentPoint--;
                            break;
                        }
                    }
                }
            }
        }
    } */

    private static boolean isSumOfPointsElsEdge(List<DiposonOfPoints> diposonOfPoints, int expectedSumOfPoints) {
        int curentSum = 0;
        for (var d : diposonOfPoints) {
            curentSum += d.maxPoin;
        }
        return curentSum == expectedSumOfPoints;
    }

    private static List<DiposonOfPoints> inmutDiaposonse(int countOfStudents) {
        List<DiposonOfPoints> diposonOfPoints = new ArrayList<>();
        for (int i = 0; i < countOfStudents; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            diposonOfPoints.add(new DiposonOfPoints(min, max));
        }
        return diposonOfPoints;
    }
}

/*
3 27
11 14
2 10
11 14

7 42
5 5
3 5
7 9
6 7
3 8
10 10
1 1
 */


