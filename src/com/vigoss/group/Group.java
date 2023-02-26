package com.vigoss.group;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Reimu Hakurei
 */
public class Group {

    private Map<Integer, Node> nodes = new HashMap<>();

    private Set<Edge> edges = new HashSet<>();

    public Map<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }

    /**
     * 生成一张图
     * 参数数组 A 和 B 的长度一致
     *
     * @param A from的点
     * @param B to的点
     * @return group
     */
    public static Group generateGroup(int[] A, int[] B) {
        Group group = new Group();
        for (int i = 0; i < A.length; i++) {
            Node nodeA = group.getNodes().get(A[i]);
            if (nodeA == null) {
                nodeA = new Node(A[i]);
                group.getNodes().put(A[i], nodeA);
            }
            Node nodeB = group.getNodes().get(B[i]);
            if (nodeB == null) {
                nodeB = new Node(B[i]);
                group.getNodes().put(B[i], nodeB);
            }
            Edge edgeAtoB = new Edge(nodeA, nodeB, 0);
            group.getEdges().add(edgeAtoB);
            nodeA.getEdges().add(edgeAtoB);
            nodeA.setOut(nodeA.getOut() + 1);
            nodeB.setIn(nodeB.getIn() + 1);
            nodeA.getNexts().add(nodeB);
        }
        return group;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{2, 3, 1};
        Group group = generateGroup(A, B);
        System.out.println(group);
    }
}
