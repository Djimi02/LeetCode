
public class RemoveNthNodeFromEndofList {

    public int nodeCounter(ListNode head){
        ListNode currentNode = head;
        int nodeCounter = 1;

        while (currentNode.next != null){
            currentNode = currentNode.next;
            nodeCounter++;
        }

        return nodeCounter;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLenght = nodeCounter(head);

        if (listLenght == 1) {
            return null;
        }

        if (listLenght - n == 0) {
            return head.next;
        }

        ListNode currentNode = head;
        for (int i = 0; i < listLenght - n - 1; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        // ListNode sixthNode = new ListNode(6);
        // ListNode fifthNode = new ListNode(5, sixthNode);
        // ListNode fourthNode = new ListNode(4, fifthNode);
        // ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondListNode = new ListNode(2, null);
        ListNode firstNode = new ListNode(1, secondListNode);

        System.out.println(new RemoveNthNodeFromEndofList().nodeCounter(firstNode));
        System.out.println(new RemoveNthNodeFromEndofList().removeNthFromEnd(firstNode,2));
    }
}
