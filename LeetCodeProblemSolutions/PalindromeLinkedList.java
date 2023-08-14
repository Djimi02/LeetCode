import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    //first variant
    public int lengthOfLinkedList(ListNode head){
        ListNode currentNode = head;
        int counter = 1;

        while (currentNode.next != null) {
            counter++;
            currentNode = currentNode.next;
        }

        return counter;
    }
    // first variant
    public int[] convertLinkedListToArray(ListNode head){
        int array[] = new int[lengthOfLinkedList(head)];

        for (int i = 0; i < array.length; i++) {
            array[i] = head.val;
            head = head.next;
        }
        
        return array;
    }
    // first variant
    public boolean isPalindrome(ListNode head) {
        int array[] = convertLinkedListToArray(head);
        boolean output = true;

        for (int i = 0; i < array.length/2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                output = false;
            }
        }

        return output;
    }

    // second variant
    public List<Integer> convertLinkedListToArray2(ListNode head){
        List<Integer> output = new ArrayList<>();

        while (head.next != null) {
            output.add(head.val);
            head = head.next;
        }
        output.add(head.val);

        return output;
    } 

    // second variant
    public boolean isPalindrome2(ListNode head) {
        List<Integer> arrayList = convertLinkedListToArray2(head);
        boolean output = true;

        for (int i = 0; i < arrayList.size() / 2; i++) {
            if (arrayList.get(i) != arrayList.get(arrayList.size() - 1 - i)) {
                output = false;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        ListNode sixthNode = new ListNode(1);
        ListNode fifthNode = new ListNode(2, sixthNode);
        ListNode fourthNode = new ListNode(3, fifthNode);
        ListNode thirdNode = new ListNode(3, fourthNode);
        ListNode secondListNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondListNode);

        System.out.println(new PalindromeLinkedList().isPalindrome2(firstNode));
    }
}
