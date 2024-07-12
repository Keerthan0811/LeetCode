// 148. Sort List
// Given the head of a linked list, return the list after sorting it in ascending order.

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
    static ListNode findmid(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow=head,fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next=(l1 != null)? l1:l2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode mid=findmid(head);
        ListNode newHead=mid.next;
        mid.next=null;
        ListNode leftHead=sortList(head);
        ListNode rightHead=sortList(newHead);
        return merge(leftHead,rightHead);
    }
}
