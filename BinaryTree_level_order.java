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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while(size>0)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                queue.offer(node.left);
                if(node.right!=null)
                queue.offer(node.right);
                size--;
            }
            res.add(list);
        }
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while(size>0)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                queue.offer(node.left);
                if(node.right!=null)
                queue.offer(node.right);
                size--;
            }
            res.add(list);
        }
        return res;
        
    }
}       return res;
        
    }
}
