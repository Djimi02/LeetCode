public class RemoveDuplicatesFromSortedListII {

    private ListNode findTheNextNodeWithDiffVal(ListNode node) {
        ListNode currentNode = node;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.val != node.val) {
                return currentNode;
            }
        }

        return null;
    }
    
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }
        
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode.next != null) {

            if (currentNode.val == currentNode.next.val) { // In case duplicate found withing the current and the next node
                if (previousNode == null || previousNode == currentNode) {
                    previousNode = findTheNextNodeWithDiffVal(currentNode);
                    head = previousNode;
                    currentNode = previousNode;
                } else {
                    previousNode.next = findTheNextNodeWithDiffVal(currentNode);
                    currentNode = previousNode.next;
                }
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode == null) {
                break;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        // ListNode node7 = new ListNode(5, null);
        // ListNode node6 = new ListNode(4, node7);
        // ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(2, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = new RemoveDuplicatesFromSortedListII().deleteDuplicates(node1);

        if (head != null) {
            System.out.println(head.val);
            while (head.next != null) {
                head = head.next;
                System.out.println(head.val);
            }
        } else {
            System.out.println(head);
        }
        
    }
}