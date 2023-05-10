import java.util.*;

public class contest4 {

    public static int findUniqueElement(ArrayList<Integer> seq) {
        HashMap<Integer, Boolean> isUniqueMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < seq.size(); i++) {
            if (isUniqueMap.get(seq.get(i)) == null) {
                isUniqueMap.put(seq.get(i), true);
            } else
                isUniqueMap.put(seq.get(i), false);
        }
        int res = 0; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return res;
    }
    public static boolean isSetBoring(HashMap<Integer, Integer> map) {
        // сделать проверку, что в мапе все элементы равны кроме одного, который на один больше
        // ИЛИ все элементы в мапе равны кроме одного, который равен 1
        var vals = map.values();
        // если в последовательности только одинаковые элементы
        if (vals.size() == 1)
            return true;
        Set<Integer> valsSet = new HashSet<>(vals);
        // если в последовательности числа, количества которых - три разных (не получится тут ниче удалить)
        if (valsSet.size() > 2)
            return false;
        ArrayList<Integer> valsArray = new ArrayList<>(valsSet);
        int uniqueElemI = findUniqueElement((ArrayList<Integer>) vals); // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (uniqueElemI != -1) {
            return (((valsArray.get(uniqueElemI) - valsArray.get(1 - uniqueElemI)) == 1) || (valsArray.get(uniqueElemI) == 1)); //!!!!!!!!!!!!!!!111
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            int num = sc.nextInt();
            if (map.get(num) == null)
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
            if (isSetBoring(map))
                res = i;
        }
        System.out.println("DEBUG: " + map);
        System.out.println(res);
    }
}
// 13
//1 2 3 1 2 2 3 3 3 1 4 4 5
// ответ: 10

//10
//1 2 4 2 3 1 3 9 15 23
// ответ: 7