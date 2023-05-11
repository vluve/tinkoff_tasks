import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class context6 {

    public static class DiposonOfPoints implements Comparable<DiposonOfPoints> {
        Integer minPoint;
        Integer maxPoin;
        Integer currentPoint;
        public DiposonOfPoints(Integer minPoint, Integer maxPoin) {
            this.minPoint = minPoint;
            this.maxPoin = maxPoin;
            this.currentPoint = 0;
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
       int tempSum, tempPoint;
       boolean f = false;
       while (true) {
           tempSum = sumOfPoints;
           for (int i = 0; i < diposonOfPoints.size(); i++) {
               if (f && i != diposonOfPoints.size() - 1) {
                   tempPoint = diposonOfPoints.get(i).maxPoin - 1;
                   if (tempPoint > diposonOfPoints.get(i).minPoint && tempPoint > diposonOfPoints.get(i + 1).currentPoint) {
                       diposonOfPoints.get(i).maxPoin -= 1;
                       f = false;
                   }
               }
               if (tempSum < diposonOfPoints.get(i).minPoint) {
                   f = true;
                   break;
               }
               diposonOfPoints.get(i).maxPoin = Math.max(tempSum, diposonOfPoints.get(i).maxPoin);
               tempSum -= diposonOfPoints.get(i).maxPoin;
           }
           if (!f)
               break;
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
