import java.util.*;

public class contest5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> components = new ArrayList<>();
        for (int i = 0; i < n; i++)
            components.add(sc.nextInt());
        int res = countMaxFrequency(components);
        System.out.println(res);
    }

    static int countMaxFrequency(List<Integer> components) {
        Collections.sort(components);
        int res = 0;
        for (int i = 0; i < components.size(); i++) {
            int sum = 0;
            int f = components.get(i);
            sum += f;
            for (int j = i + 1; j < components.size(); j++)
                sum += components.get(j) - components.get(j) % f;
            if (res < sum)
                res = sum;
        }
        return res;
    }
}