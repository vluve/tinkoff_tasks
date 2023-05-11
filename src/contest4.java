import java.util.*;

public class contest4 {
    public static boolean isSetBoring(ArrayList<Integer> a, HashMap<Integer, Integer> map) {
        if (a.size() < 3)
            return true;
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (Integer num : a) {
            tempMap = (HashMap<Integer, Integer>)map.clone();
            tempMap.put(num, tempMap.get(num) - 1);
            if (tempMap.get(num) == 0)
                tempMap.remove(num);
            HashSet<Integer> countSet = new HashSet<>(tempMap.values());
            if (countSet.size() == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            int num = sc.nextInt();
            if (map.get(num) == null)
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
            a.add(num);
            if (isSetBoring(a, map))
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