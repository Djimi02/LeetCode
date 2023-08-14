import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    // public int findTheSizeOfLinkedList(ListNode head){
    //     int counter = 1;
    //     ListNode currentNode = head;

    //     while (currentNode.next != null) {
    //         counter++;
    //         currentNode = currentNode.next;
    //     }

    //     return counter;
    // }

    public int findTheWholeNumberInLinedList(ListNode head){
        // int listSize = findTheSizeOfLinkedList(head);
        int finalNumber = 0;
        int power = 0;

        while (head.next != null) {
            finalNumber += (int) (head.val * Math.pow(10, power));
            head = head.next;
            power++;
        }
        finalNumber += (int) (head.val * Math.pow(10, power));

        // for (int i = 0; i < listSize; i++) {
        //     System.out.println(head.val + " na stepen " + i);
        //     finalNumber += (int) (head.val * Math.pow(10, i));
        //     head = head.next;
        // }

        return finalNumber;
    }

    public ListNode converFromNumToLinkedList(int num){
        List<ListNode> listOfNodes = new ArrayList<>();
        int lenghtOfNum = 0;

        if (num == 0) {
            listOfNodes.add(new ListNode(0));
        }
        else {
            while (num != 0) {
                lenghtOfNum++;
                listOfNodes.add(new ListNode(num%10));
                num = num / 10;
            }
    
            for (int i = 0; i < lenghtOfNum - 1; i++) {
                listOfNodes.get(i).next = listOfNodes.get(i+1);
            }
        }
        return listOfNodes.get(0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int numOne = findTheWholeNumberInLinedList(l1);
        int numTwo = findTheWholeNumberInLinedList(l2);
        int thirdNumber = numOne + numTwo;

        return converFromNumToLinkedList(thirdNumber);

    }

    public static void main(String[] args) {
        ListNode sixthNode = new ListNode(9);
        ListNode fifthNode = new ListNode(9, sixthNode);
        ListNode fourthNode = new ListNode(9,fifthNode);
        ListNode thirdNode = new ListNode(9, fourthNode);
        ListNode secondListNode = new ListNode(1, thirdNode);
        ListNode firstNode = new ListNode(9);

        ListNode output = new AddTwoNumbers().addTwoNumbers(fourthNode, firstNode);

        // System.out.println(new AddTwoNumbers().findTheWholeNumberInLinedList(fourthNode));
        // System.out.println(new AddTwoNumbers().findTheWholeNumberInLinedList(firstNode));

        while (output.next != null) {
            System.out.println(output.val);
            output = output.next;
        }
        System.out.println(output.val);
    }
}
