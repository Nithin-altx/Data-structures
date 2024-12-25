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

//Using Dfs Iterative
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Stack<Pair<TreeNode,Integer>> st=new Stack<>();
        List<Integer> res =new ArrayList<>();
        if(root==null)
        return res;
        st.push(new Pair<>(root,0));
        while(!st.isEmpty())
        {
            Pair<TreeNode,Integer> pair=st.pop();
            TreeNode node=pair.getKey();
            int depth=pair.getValue();
            if(depth==res.size())
            {
                res.add(node.val);
            }
            else{
                res.set(depth,Math.max(node.val,res.get(depth)));
            }
            if(node.left!=null)
            {
                st.push(new Pair<>(node.left,depth+1));
            }
            if(node.right!=null)
            {
                st.push(new Pair<>(node.right,depth+1));
            }
        }
        return res;
    }
}
