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
    //Tc=O(N)
    //SC=O(k)
    public ListNode[] splitListToParts(ListNode head, int k) {
        int N=0;
        ListNode temp=head;
        while(temp!=null)
        {
            N++;
            temp=temp.next;
        }
        temp=head;
        int parts=N/k;
        int rparts=N%k;
        ListNode res[]=new ListNode[k];
        for(int i=0;i<k;i++)
        {
         ListNode curr=temp;
        ListNode prev=null;
            if(temp==null)
            break;
            int len=0;
            while(temp!=null&&len<parts)
            {
                prev=temp;
                temp=temp.next;
                len++;
            }
            if(rparts>0)
            {
                prev=temp;
                temp=temp.next;
                rparts--;
            }
            prev.next=null;
            res[i]=curr;

        }
         return res;


    

        
    }
}
