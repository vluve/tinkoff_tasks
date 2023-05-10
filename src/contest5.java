import java.util.*;


public class contest5 {
    private final static Scanner sc = new Scanner(System.in);

    private static Set<List<Integer>> setOfNormal;
    private static Set<List<Integer>> setOfNotNormal;

    private static Integer countOfNormalDays;


    public static void main(String[] args) {
        System.out.println(countOfNormalDays(inputArr()));
    }

    private static List<Integer> inputArr() {
        int countOfDays = sc.nextInt();
        List<Integer> arrOfSalary = new ArrayList<>();
        for (int i = 0; i < countOfDays; i++) {
            arrOfSalary.add(sc.nextInt());
        }

        return arrOfSalary;
    }

    public static int countOfNormalDays(List<Integer> arrOfSalary) {
        countOfNormalDays = 0;
        List<Integer> arrNumOfDays = new ArrayList<>();

        setOfNormal = new HashSet<>();
        setOfNotNormal = new HashSet<>();

        for (int i = 1; i <= arrOfSalary.size(); i++) arrNumOfDays.add(i);
        countOfNormalDaysInner(arrOfSalary, arrNumOfDays);

        return countOfNormalDays;
    }

    private static boolean countOfNormalDaysInner(List<Integer> arrOfSalary, List<Integer> arrNumOfDays) {
        if (setOfNotNormal.contains(arrNumOfDays)) return false;
        if (setOfNormal.contains(arrNumOfDays)) return true;

        boolean isNormal = isPerfectTime(arrOfSalary);
        isNormal = findNormalInSubArr(arrOfSalary, arrNumOfDays, isNormal);

        if (isNormal) {
            countOfNormalDays++;
            setOfNormal.add(arrNumOfDays);
        } else {
            setOfNotNormal.add(arrNumOfDays);
        }

        return isNormal;
    }

    private static boolean findNormalInSubArr(List<Integer> arrOfSalary, List<Integer> arrNumOfDays, boolean isNormal) {
        if (arrOfSalary.size() > 2) {
            var isFirstPartNormal = countOfNormalDaysInner(
                    arrOfSalary.subList(0, arrOfSalary.size() - 1),
                    arrNumOfDays.subList(0, arrNumOfDays.size() - 1));

            var isLastPartNormal = countOfNormalDaysInner(
                    arrOfSalary.subList(1, arrOfSalary.size()),
                    arrNumOfDays.subList(1, arrOfSalary.size()));

            isNormal = isNormal || isFirstPartNormal || isLastPartNormal;
        }

        return isNormal;
    }

    private static boolean isPerfectTime(List<Integer> arrOfSalary) {
        int sum = 0;
        for (Integer day : arrOfSalary) {
            sum += day;
        }

        return sum == 0;
    }
}