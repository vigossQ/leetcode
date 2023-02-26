package com.vigoss.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reimu Hakurei
 */
public class Node {
    /**
     * 入度
     */
    private int in;
    /**
     * 出度
     */
    private int out;
    /**
     * 值
     */
    private int value;
    /**
     * 直接相邻的点
     */
    private List<Node> nexts;
    /**
     * 由此节点出发的边
     */
    private List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getNexts() {
        return nexts;
    }

    public void setNexts(List<Node> nexts) {
        this.nexts = nexts;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Node{" +
                "in=" + in +
                ", out=" + out +
                ", value=" + value +
                ", nexts=" + nexts.size() +
                '}';
    }
}
