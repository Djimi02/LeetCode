public class MergeTwoSortedLists {
    //counting the length of a linked list given head
    public int nodeCounter(ListNode head){
        ListNode currentNode = head;
        int nodeCounter = 1;

        if (head == null) {
            return 0;
        }

        while (currentNode.next != null){
            currentNode = currentNode.next;
            nodeCounter++;
        }

        return nodeCounter;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int lenghtOfNewList = nodeCounter(list1) + nodeCounter(list2);
        
        // if one of them is empty simply return the other one
        if (nodeCounter(list1) == 0) {
            return list2;
        }
        if (nodeCounter(list2) == 0) {
            return list1;
        }

        // use additional node that points to the first one
        ListNode initialNode = new ListNode(0,null);
        if (list1.val <= list2.val) {
            initialNode.next = list1;
            list1 = list1.next;
        } else {
            initialNode.next = list2;
            list2 = list2.next;
        }
        
        ListNode currentNode = initialNode.next;
        for (int i = 1; i < lenghtOfNewList; i++) {
            // if one of the lists is empty simpli use the other one 
            if (list1 == null){
                currentNode.next = list2;
                break;
            }
            if (list2 == null){
                currentNode.next = list1;
                break;
            }

            // check which of the lists has smaller element and link the new list to it. Then go to the new element and repeat
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
                currentNode = currentNode.next;
            }
        }

        return initialNode.next;
    }
        
    public static void main(String[] args) {
        ListNode sixthNode = new ListNode(6);
        ListNode fifthNode = new ListNode(5, sixthNode);
        ListNode fourthNode = new ListNode(3, fifthNode);
        ListNode thirdNode = new ListNode(4);
        ListNode secondListNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondListNode);

        ListNode startNode = new MergeTwoSortedLists().mergeTwoLists(null, null);

        if (startNode == null) {
            System.out.println("empty");
        } else {
            while (startNode.next != null){
                System.out.println(startNode.val);
                startNode = startNode.next;
            }
            System.out.println(startNode.val);
        }
    }
}
