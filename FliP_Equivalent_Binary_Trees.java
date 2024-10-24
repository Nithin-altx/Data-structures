class Solution {
    //Tc=O(4*N)
    //SC=O(Max depth of Tree)
    boolean flip(TreeNode root1, TreeNode root2)
    {
        if(root1==null&&root2==null)
        return true;
        if(root1==null||root2==null)
        return false;
        if(root1.val==root2.val)
        {
            boolean withoutflip=flip(root1.left,root2.left)&&flip(root1.right,root2.right);
            boolean withflip=flip(root1.left,root2.right)&&flip(root1.right,root2.left);
            return withoutflip||withflip;
        }
        else{
            return false;
        }
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flip(root1,root2);
        
    }
}
