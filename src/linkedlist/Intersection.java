package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Intersection {

    //t: O(n^2), s: O(1)
    public boolean isIntersectionBruteForce(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (headA != null) {
            while (headB != null) {
                if (headA.val == headB.val) {
                    return true;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = hB;
        }
        return false;
    }

    //t: O(n), s: O(1)
    public boolean isIntersection(ListNode headA, ListNode headB) {
        while (headA != headB) {
            headA = headA == null ? headB : headA.next;
            headB = headB == null ? headA : headB.next;
        }
        return headA != null;
    }

    //t: O(n), s: O(n)
    public boolean isIntersectionAdditionalSpace(ListNode headA, ListNode headB) {
        Set<ListNode> visitedA = new HashSet<>();
        while (headB != null) {
            if (visitedA.contains(headB)) {
                return true;
            }
            if (headA != null) {
                visitedA.add(headA);
                headA = headA.next;
            }
            headB = headB.next;
        }
        return false;
    }

}
