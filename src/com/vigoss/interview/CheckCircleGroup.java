package com.vigoss.interview;

import com.vigoss.group.Group;
import com.vigoss.group.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Reimu Hakurei
 * @date 2022/12/12 16:56
 */
public class CheckCircleGroup {

    public static boolean checkCircleGroup(int[] A, int[] B) {

        Group group = Group.generateGroup(A, B);
        Map<Integer, Node> nodes = group.getNodes();
        // 如果入度和出度有一个为0则一定不为环
        Node start = null;
        for (Node value : nodes.values()) {
            if (value.getIn() == 0 || value.getOut() == 0) {
                return false;
            }
            start = value;
        }
        if (start == null) {
            return false;
        }
        // 遍历
        Queue<Node> queue = new LinkedList<>();
        Node[] arr = new Node[nodes.size()];
        queue.add(start);
        arr[start.getValue() - 1] = start;
        int len = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (Node next : poll.getNexts()) {
                if (arr[next.getValue() - 1] == null) {
                    queue.offer(next);
                    len++;
                } else {
                    break;
                }
            }
        }
        System.out.println(len);
        return len == nodes.size();
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{2, 3, 4, 1};
        boolean b = checkCircleGroup(A, B);
        System.out.println(b);
    }
}
