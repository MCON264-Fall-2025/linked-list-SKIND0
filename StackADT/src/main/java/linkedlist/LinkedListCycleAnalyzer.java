package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head){
        //throw new NotImplementedException("TODO: implement this method");
        if (head == null) { //empty list.
            return new CycleInfo(-1, 0);
        }

        LLNode<T> slow = head;
        LLNode<T> fast = head;

        while (fast != null && fast.getLink() != null){
            slow = slow.getLink();
            fast = fast.getLink().getLink();
            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.getLink() == null){ //no cycle.
            return new CycleInfo(-1, 0);
        }

        slow = head;
        int entryIndex = 0;
        while (slow != fast) {
            slow = slow.getLink();
            fast = fast.getLink();
            entryIndex++;
        }

        int cycleLength = 1;
        fast = slow.getLink();

        while (fast != slow){
            fast = fast.getLink();
            cycleLength++;
        }
        return new CycleInfo(entryIndex, cycleLength);
    }
}
