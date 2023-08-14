import java.util.ArrayList;
import java.util.List;

public class RotateList {

    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        
        ListNode currentNode = head;
        List<ListNode> list = new ArrayList<>();

        while (currentNode.next != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        list.add(currentNode);

        if (k >= list.size()) {
            k = k % list.size();
        }

        if (k == 0 || k == list.size()) {
            return head;
        }
        
        ListNode output = list.get(list.size() - 1 - k).next;
        list.get(list.size() - 1 - k).next = null;
        list.get(list.size() - 1).next = list.get(0);

        return output;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode newHead = head;

        for (int i = 0; i < k; i++) {
            while (currentNode.next != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            currentNode.next = newHead;
            previousNode.next = null;
            newHead = currentNode;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(2, node3);
        // ListNode node1 = new ListNode(1, node2);

        ListNode result = new RotateList().rotateRight2(node4, 2);

        while (result.next != null) {
            System.err.print(result.val);
            result = result.next;
        }
        System.err.print(result.val);

    }
}
