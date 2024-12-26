import java.util.*;

class Node {
    int index;
    Node prev;
    Node next;

    Node(int index) {
        this.index = index;
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < n; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }

        Node current = nodes[k];
        Stack<Node> deleted = new Stack<>();


        for (String command : cmd) {
            String[] parts = command.split(" ");
            String op = parts[0];

            if (op.equals("U")) {
                int x = Integer.parseInt(parts[1]);
                for (int i = 0; i < x; i++) {
                    current = current.prev;
                }
            } else if (op.equals("D")) {
                int x = Integer.parseInt(parts[1]);
                for (int i = 0; i < x; i++) {
                    current = current.next;
                }
            } else if (op.equals("C")) {
                deleted.push(current);
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                    current = current.next;
                } else {
                    current = current.prev;
                }
            } else if (op.equals("Z")) {
                Node node = deleted.pop();
                if (node.prev != null) {
                    node.prev.next = node;
                }
                if (node.next != null) {
                    node.next.prev = node;
                }
            }
        }

        char[] result = new char[n];
        Arrays.fill(result, 'O');
        while (!deleted.isEmpty()) {
            result[deleted.pop().index] = 'X';
        }

        return new String(result);
    }
}