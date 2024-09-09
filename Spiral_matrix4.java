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
    //Tc=O(m*n)
    //sc=O(m*n);
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(a[i],-1);
        }
        int top=0,down=m-1;
        int left=0,right=n-1;
        int dir=0;
        while(top<=down&&left<=right)
        {
            if(dir==0)//Left->right
            {
                for(int i=left;i<=right&&head!=null;i++)
                {
                   a[top][i]=head.val;
                   head=head.next;
                }
                top++;

            }
            if(dir==1)//Top->down
            {
                for(int i=top;i<=down&&head!=null;i++)
                {
                  a[i][right]=head.val;
                    head=head.next;

                }
                right--;
                
            }
            if(dir==2)//Right->left
            {
                for(int i=right;i>=left&&head!=null;i--)
                {
                    a[down][i]=head.val;
                      head=head.next;
                }
                down--;
                
            }
            if(dir==3)//Down->top
            {
                for(int i=down;i>=top&&head!=null;i--)
                {
                    a[i][left]=head.val;
                    head=head.next;
                }
                left++;
                
            }
            dir=(dir+1)%4;
        }
        return a;
        
    }
}
