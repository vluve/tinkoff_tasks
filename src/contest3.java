import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class contest3 {
    static class Tree {
        Node[] nodes;

        public Tree(int[] characteristicsOfFilter, int[] parentsOfFilter, int[] distanceBetweenFilters) {
            nodes = new Node[characteristicsOfFilter.length];


            for (int i = 0; i < characteristicsOfFilter.length; i++) {
                nodes[i] = new Node();
                nodes[i].setA(characteristicsOfFilter[i]);
            }

            for (int i = 0; i < parentsOfFilter.length; i++) {
                nodes[parentsOfFilter[i] - 1].getChilds().add(nodes[i + 1]);
                nodes[i + 1].setLongToParent(distanceBetweenFilters[i]);
            }
        }

        public void find() {
            for (int i = 0; i < nodes.length; i++) {
                find(nodes[i], 0, nodes[i]);
                System.out.print(nodes[i].getCountOfOverloadedServers() + " ");
            }
        }

        public void find(Node childNode, int length, Node parentNode) {
            List<Node> children = childNode.getChilds();
            if (childNode != parentNode) {
                length += childNode.getLongToParent();
            }

            if (children.size() != 0) {
                for (var child : children) {
                    if (length + child.getLongToParent() <= child.getA()) {
                        parentNode.incCountOfOverloadedServers();
                    }
                    find(child, length, parentNode);
                }
            }
        }

        static class Node {
            public List<Node> childs = new ArrayList<>();

            public int a;
            public int longToParent;

            Integer countOfOverloadedServers = 0;

            public void incCountOfOverloadedServers() {
                countOfOverloadedServers++;
            }

            public Integer getCountOfOverloadedServers() {
                return countOfOverloadedServers;
            }


            public List<Node> getChilds() {
                return childs;
            }




            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getLongToParent() {
                return longToParent;
            }

            public void setLongToParent(int longToParent) {
                this.longToParent = longToParent;
            }
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int countOfFilter = sc.nextInt();

            int[] characteristicsOfFilter = new int[countOfFilter];
            for (int i = 0; i < characteristicsOfFilter.length; i++) {
                characteristicsOfFilter[i] = sc.nextInt();
            }

            int[] parentsOfFilter = new int[countOfFilter - 1];
            for (int i = 0; i < parentsOfFilter.length; i++) {
                parentsOfFilter[i] = sc.nextInt();
            }

            int[] distanceBetweenFilters = new int[countOfFilter - 1];
            for (int i = 0; i < distanceBetweenFilters.length; i++) {
                distanceBetweenFilters[i] = sc.nextInt();
            }

            Tree tree = new Tree(characteristicsOfFilter, parentsOfFilter, distanceBetweenFilters);
            tree.find();

        }
    }
}