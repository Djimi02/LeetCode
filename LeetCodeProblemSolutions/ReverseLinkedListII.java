import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode head1 = head;
        ListNode beforeLeft = null;

        List<ListNode> listToBeReversed = new ArrayList<>();

        int position = 1;

        while (head1 != null) {
            if (position == left - 1) {
                beforeLeft = head1;
            }

            if (position >= left && position <= right) {
                listToBeReversed.add(head1);
            }

            head1 = head1.next;
            position++;
        }

        if (beforeLeft != null) {
            beforeLeft.next = listToBeReversed.get(listToBeReversed.size() - 1);
        }
        listToBeReversed.get(0).next = listToBeReversed.get(listToBeReversed.size() - 1).next;
        for (int i = listToBeReversed.size() - 1; i > 0; i--) {
            listToBeReversed.get(i).next = listToBeReversed.get(i-1);
        }

        if (left == 1) {
            return listToBeReversed.get(listToBeReversed.size() - 1);
        }
        return head;
    }

    public static void main(String[] args) {

    }
}