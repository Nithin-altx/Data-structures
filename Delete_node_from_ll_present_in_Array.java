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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            st.add(nums[i]);
        }
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            if(st.contains(temp.val))
            {
                if(prev==null)
                {
                    head=head.next;
                    temp.next=null;
                    temp=head;
                }
                else
                {
                    prev.next=temp.next;
                    temp.next=null;
                    temp=prev.next;
                   
                }
            }
            else
            {
                prev=temp;
                temp=temp.next;
            }
        }
        return head;

        
    }
}
