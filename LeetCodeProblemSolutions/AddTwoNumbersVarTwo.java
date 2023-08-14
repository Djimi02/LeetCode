import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersVarTwo {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> listOfNodes = new ArrayList<>();
        int sum = 0;
        int carryOver = 0;

        while (l1.next != null || l2.next != null) {

            sum = l1.val + l2.val + carryOver;
            carryOver = 0;

            if (sum > 9){
                carryOver++;
                sum = sum % 10;
            }

            listOfNodes.add(new ListNode(sum));

            if (l1.next != null) {
                l1 = l1.next;
            }else{
                l1.val = 0;
            }

            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2.val = 0;
            }
            
        }

        sum = l1.val + l2.val + carryOver;
        carryOver = 0;

        if (sum > 9){
            carryOver++;
            sum = sum % 10;
        }

        listOfNodes.add(new ListNode(sum));

        if (carryOver != 0) {
            listOfNodes.add(new ListNode(carryOver));
        }

        for (int i = 0; i < listOfNodes.size() - 1; i++) {
            listOfNodes.get(i).next = listOfNodes.get(i+1);
        }

        return listOfNodes.get(0);
    }

    public static void main(String[] args) {
        ListNode sixthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(6, sixthNode);
        ListNode fourthNode = new ListNode(5,fifthNode);
        ListNode thirdNode = new ListNode(3);
        ListNode secondListNode = new ListNode(4, thirdNode);
        ListNode firstNode = new ListNode(2, secondListNode);

        ListNode output = new AddTwoNumbers().addTwoNumbers(firstNode, fourthNode);

        // System.out.println(new AddTwoNumbers().findTheWholeNumberInLinedList(fourthNode));
        // System.out.println(new AddTwoNumbers().findTheWholeNumberInLinedList(firstNode));

        while (output.next != null) {
            System.out.println(output.val);
            output = output.next;
        }
        System.out.println(output.val);
    }
}
