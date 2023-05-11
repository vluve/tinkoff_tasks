import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class context6 {

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

        diposonOfPoints.sort(Collections.reverseOrder());

        findOptimalPoints(sumOfPoints, diposonOfPoints);

        System.out.println(diposonOfPoints.get(diposonOfPoints.size() / 2 + 1).maxPoin);
    }

    private static void findOptimalPoints(int sumOfPoints, List<DiposonOfPoints> diposonOfPoints) {
        var tempSumOfPoints = sumOfPoints;
        while (tempSumOfPoints != 0) {
            for (int i = 0; i < diposonOfPoints.size(); i++) {
                if (tempSumOfPoints - diposonOfPoints.get(i).maxPoin > 0) {
                    tempSumOfPoints -= diposonOfPoints.get(i).maxPoin;
                } else if (tempSumOfPoints - diposonOfPoints.get(i).maxPoin < 0) {
                    for (int j = 0; j < diposonOfPoints.size(); j++) {
                        if (diposonOfPoints.get(j).maxPoin - 1 > diposonOfPoints.get(j + 1).maxPoin
                                && diposonOfPoints.get(j).canRudeceOne()) {
                            diposonOfPoints.get(j).maxPoin--;
                        }
                    }
                    tempSumOfPoints = sumOfPoints;
                    break;
                }
            }
        }
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
