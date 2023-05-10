import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class context6 {

    public record DiposonOfPoints(Integer minPoint, Integer maxPoin) implements Comparable<DiposonOfPoints> {

        @Override
        public int compareTo(DiposonOfPoints o) {
            var resOfCompare = o.maxPoin.compareTo(this.maxPoin);
            if (resOfCompare == 0) {
                return o.minPoint.compareTo(this.minPoint);
            }

            return resOfCompare;
        }


        public boolean canRudeceOne() {
            return
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int countOfStudents = sc.nextInt();
        int sumOfPoints = sc.nextInt();

        List<DiposonOfPoints> diposonOfPoints = new ArrayList<>();
        for (int i = 0; i < countOfStudents; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            diposonOfPoints.add(new DiposonOfPoints(min, max));
        }


        diposonOfPoints.sort(Collections.reverseOrder());
        var tempSumOfPoints = sumOfPoints;
        while (true) {
            for (int i = 0; i < diposonOfPoints.size(); i++) {
                if (tempSumOfPoints - diposonOfPoints.get(i).maxPoin > 0) {
                    tempSumOfPoints -= diposonOfPoints.get(i).maxPoin;
                }
                else {
                    for (int j = 0; j < diposonOfPoints.size(); j++) {
                        if (diposonOfPoints.get(j).maxPoin - 1 > diposonOfPoints.get(j + 1).maxPoin
                                && diposonOfPoints.get(j).canRudeceOne())
                    }
                }
            }
        }


    }


}
