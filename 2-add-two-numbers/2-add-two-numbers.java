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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int sum=0;
        ListNode dummy=new ListNode(-1);
        ListNode l3=dummy;
        while(l1!=null || l2!=null){
            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;
            sum+=carry;
           
            int lastDigit = sum%10;
            carry=sum/10;
            ListNode newnode=new ListNode(lastDigit);
           
            l3.next=newnode;
            l3=l3.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            sum=0;
        }
        if(carry>0){
            ListNode newnode=new ListNode(carry);
            l3.next=newnode;
        }
       return dummy.next;
        
    }
}