class Solution {
    int maxd=0;
    //Tc=O(N)
    //Sc=O(N)
      Map<TreeNode,Integer> mp=new HashMap<>();
    void depth(TreeNode root,int d)
    {
        if(root==null)
        return;
        maxd=Math.max(maxd,d);
        mp.put(root,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
    TreeNode lca(TreeNode root)
    {
        if(root==null)
        return null;
        if(mp.get(root)==maxd)
        return root;
        TreeNode l=lca(root.left);
        TreeNode r=lca(root.right);

        if(l!=null && r!=null)
        {
            return root;
        }
        else if(l==null)
        {
            return r;
        }
        else{
            return l;
        }


    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return lca(root);
        

        
    }
}
