import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelescopeSystem {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // вводим граф задачи
        int numOfTelescopes, numOfStars, numOfModes;
        numOfTelescopes = sc.nextInt();
        numOfStars = sc.nextInt();
        numOfModes = sc.nextInt();
        int[] modes = new int[numOfTelescopes];
        for (int i = 0; i < numOfTelescopes; i++)
            modes[i] = sc.nextInt();

        // делим алгоритмом Краскала граф на независимые букеты
        int[] subgraphsNumbers = KruskalAlgorithm(numOfTelescopes, numOfStars);
        List<List<Integer>> subgraphs = splitGraph(subgraphsNumbers);
        // находим минимальное количество необходимых изменений
        System.out.println(findMinPath(numOfModes, modes, subgraphs));
    }
    // возвращает минимальное необходимое количество смен режимов
    static int findMinPath(int numOfModes, int[] modes, List<List<Integer>> subgraphs) {
        int res = 0;
        for (var sbgrph : subgraphs) {
            int[] modeCounters = countModes(numOfModes, modes, sbgrph);
            int mostUsedMode = getMostUsedMode(modeCounters);
            res += findMinPathInSubgraph(modes, sbgrph, mostUsedMode);
        }
        return res;
    }

    // посчитать количества режимов
    static int[] countModes(int numOfModes, int[] modes, List<Integer> subgraph) {
        int[] res = new int[numOfModes];
        for (int i = 0; i < subgraph.size(); i++)
            res[modes[subgraph.get(i)] - 1]++;
        return res;
    }

    // возвращает минимальное количество изменений режима в букете
    static int findMinPathInSubgraph(int[] modes , List<Integer> subgraph, int targetMode) {
        int res = 0;
        for (var telescope : subgraph) {
            if ((modes[telescope] - 1) != targetMode)
                res++;
        }
        return res;
    }

    // возвращает наиболее используемый режим
    private static int getMostUsedMode(int[] modeNums) {
        int mostUsedMode = 0;
        int count = 0;
        for (int i = 0; i < modeNums.length; i++)
            if (modeNums[i] > count) {
                count = modeNums[i];
                mostUsedMode = i;
            }
        return mostUsedMode;
    }

    // алгоритм Краскала для выделения букетов
    private static int[] KruskalAlgorithm(int countOfTelescopes, int countOfStars) {
        int[] groupOfTelescopes = new int[countOfTelescopes];
        for (int i = 0; i < countOfTelescopes; i++) {
            groupOfTelescopes[i] = i;
        }
        for (int i = 0; i < countOfStars; i++) {
            int firstTelescope = sc.nextInt();
            int thecondTelescope = sc.nextInt();

            if (groupOfTelescopes[firstTelescope - 1] != groupOfTelescopes[thecondTelescope - 1]) {
                changeSubgraph(groupOfTelescopes[firstTelescope - 1], groupOfTelescopes[thecondTelescope - 1], groupOfTelescopes);
            }
        }

        return groupOfTelescopes;
    }

    private static List<List<Integer>> splitGraph(int[] subgraph) {
        boolean[] checks = new boolean[subgraph.length];
        List<List<Integer>> subgraphs = new ArrayList<>();

        for (int i = 0; i < subgraph.length; i++) {
            if (!checks[subgraph[i]]) {
                checks[subgraph[i]] = true;
                List<Integer> group = new ArrayList<>();
                for (int j = i; j < subgraph.length; j++)
                    if (subgraph[i] == subgraph[j])
                        group.add(j);
                subgraphs.add(group);
            }
        }

        return subgraphs;
    }

    private static void changeSubgraph(int mode1, int mode2, int[] subgraph) {
        for (int i = 0; i < subgraph.length; i++)
            if (subgraph[i] == mode2)
                subgraph[i] = mode1;
    }

}