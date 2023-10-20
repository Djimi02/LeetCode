public class PartitionList {

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode startBigger = new ListNode(-1, null);
        ListNode nextBigger = startBigger;

        ListNode startSmaller = new ListNode(-1, null);
        ListNode nextSmaller = startSmaller;

        ListNode pointer = head;

        while (pointer != null) {
            
            if (pointer.val >= x) {
                nextBigger.next = pointer;
                nextBigger = nextBigger.next;
            } else {
                nextSmaller.next = pointer;
                nextSmaller = nextSmaller.next;
            }

            pointer = pointer.next;
        }

        nextSmaller.next = startBigger.next; 
        nextBigger.next = null;       

        return startSmaller.next;
    }


    public static void main(String[] args) {
        // ListNode node6 = new ListNode(2, null);
        // ListNode node5 = new ListNode(5, node6);
        // ListNode node4 = new ListNode(2, node5);
        // ListNode node3 = new ListNode(3, node4);
        // ListNode node2 = new ListNode(4, node3);
        // ListNode node1 = new ListNode(1, node2);

        ListNode node6 = new ListNode(2, null);
        ListNode node5 = new ListNode(1, node6);


        PartitionList object = new PartitionList();
        object.printList(object.partition(node5, 3));
    }
}