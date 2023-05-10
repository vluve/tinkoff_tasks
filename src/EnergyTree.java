import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnergyTree {
    static Node[] nodes;
    static int numOfNodes;
    static class Node {
        int wireToParentLen; // l
        List<Node> children;
        int a;
        int numOfOverloaders = 0;
    }
    static void inputTree() {
        Scanner sc = new Scanner(System.in);
        numOfNodes = sc.nextInt();

        nodes = new Node[numOfNodes];
        // инициализация дерева
        for (int i = 0; i < numOfNodes; i++) {
            nodes[i] = new Node();
            nodes[i].children = new ArrayList<Node>();
            nodes[i].a = sc.nextInt();
        }
        // инициализация массивов потомков
        for (int i = 1; i < numOfNodes; i++) {
            int numOfParent = sc.nextInt();
            nodes[numOfParent - 1].children.add(nodes[i]);
        }
        // инициализация длин проводов
        for (int i = 1; i < numOfNodes; i++)
            nodes[i].wireToParentLen = sc.nextInt();
    }

    static void countOverloaders() {
        for (Node node: nodes) {
            countOverloaders(node, 0, node);
            System.out.print(node.numOfOverloaders + " ");
        }
    }
    static void countOverloaders(Node targetNode, int wireLen, Node currentNode) {
        List<Node> children = currentNode.children;
        if (currentNode != targetNode)
            wireLen += currentNode.wireToParentLen;

        if (children.size() > 0)
            for (Node child : children) {
                if (wireLen + child.wireToParentLen <= child.a)
                    targetNode.numOfOverloaders++;
                countOverloaders(targetNode, wireLen, child);
            }
    }

    public static void main(String[] args) {
        inputTree();
        countOverloaders();
    }
}
