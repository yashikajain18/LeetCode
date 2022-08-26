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
    public static int length(ListNode head){
        int len=0;
        while(head!=null) {
            head=head.next;
            len++;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        
        int len=length(head);
       
        ListNode temp=head;
        if (len == n) return head.next;
        for(int i=1; i<len-n; i++){
            temp=temp.next;
        }
        
        if (temp.next!=null) temp.next = temp.next.next;
        else temp.next = null;
        return head;
       
    }
}