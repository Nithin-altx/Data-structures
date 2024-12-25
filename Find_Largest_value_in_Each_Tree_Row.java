class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //Tc=O(N)
        //Sc=O(N)
        List<Integer> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty())
        {
            int n=pq.size();
            int maxele=Integer.MIN_VALUE;
            while(n>0)
            {
                TreeNode node=pq.poll();
                maxele=Math.max(node.val,maxele);
                if(node.left!=null)
                {
                    pq.add(node.left);
                }
                if(node.right!=null)
                {
                    pq.add(node.right);
                }
                n--;
            }
            res.add(maxele);

        }
        return res;
    }
}
//DFS TC=O(N) SC=O(1)//STACK SPACE O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List<Integer> res=new ArrayList<>();
    void dfs(TreeNode root,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(depth==res.size())
        {
            res.add(root.val);
        }
        else{
            res.set(depth,Math.max(root.val,res.get(depth)));
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,0);
        return res;
        
    }
}

