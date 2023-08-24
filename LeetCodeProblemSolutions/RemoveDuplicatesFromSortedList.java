public class RemoveDuplicatesFromSortedList {

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
        
        ListNode currentNode = head;

        while (currentNode.next != null) {

            if (currentNode.val == currentNode.next.val) { // In case of duplicate between the current node and the next one 
                currentNode.next = findTheNextNodeWithDiffVal(currentNode);
            } else {
                currentNode = currentNode.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        // ListNode node7 = new ListNode(5, null);
        // ListNode node6 = new ListNode(4, node7);
        // ListNode node5 = new ListNode(3, null);
        // ListNode node4 = new ListNode(2, null);
        ListNode node3 = new ListNode(2, null);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = new RemoveDuplicatesFromSortedList().deleteDuplicates(node1);

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
