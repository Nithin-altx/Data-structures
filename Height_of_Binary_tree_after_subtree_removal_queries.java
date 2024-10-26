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
    int level[]=new int[100001];
    int height[]=new int[100001];
    int levelMh[]=new int[100001];
    int levelsecMh[]=new int[100001];
    //Tc=O(N)
    //sc=O(N)
    int findhight(TreeNode root,int l)
    {
        if(root==null)
        return 0;
        level[root.val]=l;
        height[root.val]=Math.max(findhight(root.left,l+1),findhight(root.right,l+1))+1;
        if(levelMh[l]<height[root.val])
        {
            levelsecMh[l]=levelMh[l];
            levelMh[l]=height[root.val];
        }
        else if(levelsecMh[l]<height[root.val])
        {
            levelsecMh[l]=height[root.val];

        }
        return height[root.val];
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        findhight(root,0);
        int res[]=new int[queries.length];
      for(int i=0;i<queries.length;i++)
      {
        int L=level[queries[i]];
        int temp=L+(levelMh[L]==height[queries[i]]?levelsecMh[L]:levelMh[L])-1;
        res[i]=temp;
      }
      return res;
        
    }
}
