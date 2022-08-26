/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static int length(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int lenA=length(headA);
       int lenB=length(headB);
       ListNode temp1=null;
       temp1= (lenA>lenB) ? headA:headB;
        
       ListNode temp2=null;
       temp2=(lenA>lenB) ? headB:headA; 
      
       for(int i=0; i<Math.abs(lenA-lenB); i++){
           temp1=temp1.next;
       }
        while(temp1!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
        
        //Best Approach
//         ListNode a = headA, b = headB;
    
//         while(a!=b){
//           if(a==null) a = headB;
//           else a = a.next;
        
//           if(b==null) b = headA;
//           else b = b.next;
//         }
        //return b;
    }
}