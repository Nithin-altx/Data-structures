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
    //Tc=O(2n)
    //SC=O(n)
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> ls=new ArrayList<>();
        if(root==null)
        return root;
        que.add(root);
        while(!que.isEmpty())
        {
            int n=que.size();
            int levelsum=0;
            for(int i=0;i<n;i++)
            {
                TreeNode pe=que.poll();
                levelsum+=pe.val;
                if(pe.left!=null)
                que.add(pe.left);
                if(pe.right!=null)
                que.add(pe.right);
            }
            ls.add(levelsum);
        }
        que.add(root);
        root.val=0;
        int idx=1;
        while(!que.isEmpty())
        {
            int n=que.size();
            for(int i=0;i<n;i++)
            {
                TreeNode curr=que.poll();
                int sibilingsum=curr.left!=null?curr.left.val:0;
                sibilingsum+=curr.right!=null?curr.right.val:0;
                if(curr.left!=null)
                {
                    curr.left.val=ls.get(idx)-sibilingsum;
                    que.add(curr.left);
                }
                if(curr.right!=null)
                {
                    curr.right.val=ls.get(idx)-sibilingsum;
                    que.add(curr.right);
                }

            }
            idx++;

        }
        return root;
        
    }
}
//**********************Approach2**********************

class Solution {
    //Tc=O(n)
    //SC=O(n)
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> ls=new ArrayList<>();
        if(root==null)
        return root;
        que.add(root);
        int levelsum=root.val;
       while(!que.isEmpty())
       {
        int n=que.size();
        int nextlevelsum=0;
        for(int i=0;i<n;i++)
        {
            TreeNode curr=que.poll();
            curr.val=levelsum-curr.val;
            int sibilingsum=curr.left!=null?curr.left.val:0;
            sibilingsum+=curr.right!=null?curr.right.val:0;
            if(curr.left!=null)
            {
                nextlevelsum+=curr.left.val;
                curr.left.val=sibilingsum;
                que.add(curr.left);
            }
             if(curr.right!=null)
            {
                 nextlevelsum+=curr.right.val;
                curr.right.val=sibilingsum;
                que.add(curr.right);
            }
            
        }
        levelsum=nextlevelsum;
        

       }
        return root;
        
    }
}
