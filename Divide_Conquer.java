// 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.


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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        while (lists.length > 1) {
            int mergedSize = (lists.length + 1) / 2;
            ListNode[] mergedLists = new ListNode[mergedSize];
            
            for (int i = 0; i < lists.length / 2; i++) {
                mergedLists[i] = mergeList(lists[2 * i], lists[2 * i + 1]);
            }
            
            if (lists.length % 2 == 1) {
                mergedLists[mergedSize - 1] = lists[lists.length - 1];
            }
            
            lists = mergedLists;
        }
        
        return lists[0];
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        
        return dummy.next;
    }
}
