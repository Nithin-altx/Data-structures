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
   public  int gcd(int a,int b)
    {
        int g=0;
        for(int i=1;i<=Math.min(a,b);i++)
        {
            if(a%i==0&&b%i==0)
            {
                g=i;
            }
        }
        return g;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        while(temp.next!=null)
        {
            int x=gcd(temp.val,temp.next.val);
            ListNode gcd=new ListNode(x);
            gcd.next=temp.next;
            temp.next=gcd;
            temp=gcd.next;
        }
        return head;
 
        
    }
}
