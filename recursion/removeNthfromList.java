// Problem: Combination Sum II

// Pattern: Recursion, Backtracking with Loop-Based Choice Pattern

// Approach:
// Make fast and slow pointers
// Move fast pointer n steps ahead
// Move both pointers until fast reaches the end
// Remove the nth node from the end by changing the next pointer of slow

// TC: O(N)




//Brute force: Find the length of linked list and then remove the (length-n)th node from the start.  
  
  
  
  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class removeNthfromList {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0) {
         fast = fast.next;
         n--;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

