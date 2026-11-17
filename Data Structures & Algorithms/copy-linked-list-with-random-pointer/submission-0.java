/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/



class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // Pass 1: create a copy of every node (values only)
        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }

        // Pass 2: wire up next and random pointers using the map
        for (Node curr = head; curr != null; curr = curr.next) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);       // map.get(null) returns null
            copy.random = map.get(curr.random);   // same for a null random
        }

        return map.get(head);
    }
}