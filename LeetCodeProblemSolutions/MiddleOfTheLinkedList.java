public class MiddleOfTheLinkedList {
    public int nodeCounter(ListNode head){
        ListNode currentNode = head;
        int nodeCounter = 1;

        while (currentNode.next != null){
            currentNode = currentNode.next;
            nodeCounter++;
        }

        return nodeCounter;
    }

    public ListNode middleNode(ListNode head) {
        int nodeCounter = nodeCounter(head);

        for (int i = 1; i < nodeCounter/2 + 1; i++) {
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode sixthNode = new ListNode(6);
        ListNode fifthNode = new ListNode(5, sixthNode);
        ListNode fourthNode = new ListNode(4, fifthNode);
        ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondListNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondListNode);

        System.out.println(new MiddleOfTheLinkedList().nodeCounter(firstNode));
        System.out.println(new MiddleOfTheLinkedList().middleNode(firstNode).val);
    }
}
