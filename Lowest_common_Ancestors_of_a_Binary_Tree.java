class Solution {
    //Tc=O(N)
    //sc=O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        return null;

        if(root==p||root==q)
        return root;

        TreeNode leftN=lowestCommonAncestor(root.left,p,q);
        TreeNode rightN=lowestCommonAncestor(root.right,p,q);

        if(leftN==null)
        return rightN;
        else if(rightN==null)
        return leftN;
        else
        return root;
        
    }
}
