/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            int n=que.size();
            long levelsum=0;
            for(int i=0;i<n;i++)
            {
                 TreeNode pe=que.poll();
                 levelsum+=pe.val;
                if(pe.left!=null)
                {
                    que.add(pe.left);
                }
                if(pe.right!=null)
                {
                    que.add(pe.right);
                }
            }
            pq.add(levelsum);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.size()<k?-1:pq.peek();
    }
}
